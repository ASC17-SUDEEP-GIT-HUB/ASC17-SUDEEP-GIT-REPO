 package com.shopibuy.App;

import com.shopibuy.other.*;

public class MainApp {

    public static void main(String args[]) {
        Profile user = new Profile("Sudeep Gowda");
        user.showProfile();

        //product
        Product p1 = new Product(1, "T-shirt", 599);

        Product p2 = new Product(2, "Pant", 799);

        Product p3 = new Product(3, "Jeans", 999);

        user.cart.addToCart(p2);
        user.cart.addToCart(p3);

        user.wishlt.addToWishList(p1);
        user.wishlt.addToWishList(p3);

        user.wishlt.getWishListTotal();

        Offer offer = new Offer("Discount99", 49);

        Order order = new Order(user.cart, offer);

        order.showOrder();

        Payment pay = new Payment();

        pay.processPayment(order.totalAmount);

    }

}