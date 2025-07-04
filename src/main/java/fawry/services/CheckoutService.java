package fawry.services;

import fawry.models.*;
import fawry.interfaces.Expirable;
import fawry.interfaces.Shippable;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                throw new IllegalStateException("Product " + p.getName() + " is expired");
            }
        }

        double subtotal = cart.calculateSubtotal();
        double shipping = cart.getShippableItems().isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (customer.getBalance() < total) throw new IllegalStateException("Insufficient balance");

        if (shipping > 0) ShippingService.ship(cart.getShippableItems());

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shipping);
        System.out.printf("Amount           %.0f\n", total);
        System.out.printf("Balance left     %.0f\n\n", customer.getBalance() - total);

        customer.deduct(total);

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
    }
}
