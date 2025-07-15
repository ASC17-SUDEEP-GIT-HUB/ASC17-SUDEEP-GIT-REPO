package com.shopibuy.other;
import java.util.*;

public class WishList {

    public List<Product> list = new ArrayList<>();


    public void addToWishList(Product product) {
        list.add(product);
        System.out.println("The " + product.name + " added to wishlist");
    }

    public double getWishListTotal() {
        double total = 0;

        for(Product p : list) {
            total += p.price;
        }
        return total;
    }

    public void showWishList() {
        for (Product p : list) {
            p.showProduct();

            System.out.println("The total in WishList is: " + getWishListTotal());
        }
    }
}
