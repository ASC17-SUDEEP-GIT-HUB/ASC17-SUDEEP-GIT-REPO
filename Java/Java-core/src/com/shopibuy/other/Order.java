package com.shopibuy.other;

public class Order {
    public Cart cart;
    public double totalAmount;

    public Order(Cart cart, Offer offer) {
        this.cart = cart;
        double rawTotal = cart.getTotal();
        this.totalAmount = offer != null ? offer.applyOffer(rawTotal) : rawTotal;
    }

    public void showOrder() {
        cart.showCart();
        System.out.println("Final payable Amount : " + totalAmount);
    }
}
