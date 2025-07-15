package com.shopibuy.other;

public class Profile {
    public String username;
    public Cart cart;
    public WishList wishlt;

    public Profile(String username) {
        this.username = username;
        this.cart = new Cart();
        this.wishlt = new WishList();
    }

    public void showProfile() {
        System.out.println("Profile: " + username);
        cart.showCart();
    }
}