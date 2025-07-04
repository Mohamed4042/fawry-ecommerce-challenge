package fawry;

import fawry.models.*;
import fawry.interfaces.*;
import fawry.services.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Test 1: Normal checkout with mixed products ---");
        run(() -> {
            Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, false, 200);
            Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, false, 700);
            Product scratchCard = new Product("Scratch Card", 50, 10);
            Customer mohamed = new Customer("Mohamed", 1000);
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);
            CheckoutService.checkout(mohamed, cart);
        });

        System.out.println("\n--- Test 2: Empty cart error handling ---");
        run(() -> {
            Customer c = new Customer("Ali", 500);
            Cart cart = new Cart();
            CheckoutService.checkout(c, cart);
        });

        System.out.println("\n--- Test 3: Insufficient balance error handling ---");
        run(() -> {
            Product tv = new ShippableProduct("TV", 3000, 2, 8000);
            Customer c = new Customer("Sara", 500);
            Cart cart = new Cart();
            cart.add(tv, 1);
            CheckoutService.checkout(c, cart);
        });

        System.out.println("\n--- Test 4: Out of stock error handling ---");
        run(() -> {
            Product cheese = new ExpirableShippableProduct("Cheese", 100, 1, false, 200);
            Cart cart = new Cart();
            cart.add(cheese, 3); // only 1 in stock
        });

        System.out.println("\n--- Test 5: Expired product error handling ---");
        run(() -> {
            Product expired = new ExpirableProduct("Old Milk", 40, 5, true);
            Customer c = new Customer("Yara", 300);
            Cart cart = new Cart();
            cart.add(expired, 1);
            CheckoutService.checkout(c, cart);
        });

        System.out.println("\n--- Test 6: Only non-shippable items (no shipping fee) ---");
        run(() -> {
            Product scratchCard = new Product("Scratch Card", 50, 10);
            Customer c = new Customer("Kareem", 500);
            Cart cart = new Cart();
            cart.add(scratchCard, 3);
            CheckoutService.checkout(c, cart);
        });
    }

    static void run(Runnable test) {
        try {
            test.run();
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
