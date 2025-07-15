package com.shopibuy.other;

public class Offer {

    public String code;
    public double discountPercent;

    public Offer(String code, double discountPercent) {
        this.code = code;
        this.discountPercent = discountPercent;
    }

    public double applyOffer(double total) {
        double discount = total * (discountPercent / 100);
        return total - discount;
    }
}
