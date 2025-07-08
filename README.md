# 🛍️ Fawry Ecommerce System

A simple backend simulation of an e-commerce system built in Java, designed for the Fawry Rise Internship Challenge.

This system models products, carts, checkout logic, and shippable behavior — with full validation and receipt generation.

---

## 🚀 Features

- Add products with price, quantity, expiry, and weight
- Cart system that handles:
  - Quantity checks
  - Expired product filtering
  - Shipping fee calculation
  - Empty cart and balance validation
- Checkout prints a receipt and optionally triggers shipping
- Supports product types:
  - 📦 ExpirableShippableProduct
  - 📄 ShippableProduct
  - 📍 ExpirableProduct
  - 🧾 Regular Product



## ✅ Test Coverage

- ✔️ Normal checkout with mixed product types
- ❌ Empty cart error
- ❌ Expired product rejection
- ❌ Out-of-stock prevention
- ❌ Insufficient balance handling
- ✔️ E-products (non-shippable) skip shipping fee


## ▶️ How to Run

1. Open in IntelliJ IDEA
2. Run `Main.java`
3. View all scenarios in the console

---

## 📌 Notes

- Shipping fee: fixed 30 EGP (if any item is shippable)
- Products use grams internally; shipping displays total weight in kg

---

## 🧠 Design Highlights

- Interface-based polymorphism (`Expirable`, `Shippable`)
- Open-Closed Principle: add product types without modifying core logic
- Clear validation and exception handling for real-world readiness
