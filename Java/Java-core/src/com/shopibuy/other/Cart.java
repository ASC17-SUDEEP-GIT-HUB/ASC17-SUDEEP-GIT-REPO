package com.shopibuy.other;
import java.util.*;

public class Cart {

    public List<Product> items = new ArrayList<>();

    public void addToCart(Product product) {
        items.add(product);
        System.out.println(product.name + " added to cart");
    }

    public double getTotal() {
        double total = 0;

        for(Product p : items) {
            total += p.price;
        }
        return total;
    }

    public void showCart() {
        System.out.println("Cart contents: ");
        for(Product p : items) {
            p.showProduct();
            System.out.println("Total: " + getTotal());
        }
    }
}
