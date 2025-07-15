package com.demo.lab1;

import java.util.*;

public class Methods {

    public void getCharAt(String str) {
        System.out.println(str.charAt(1));
    }

    public void getContains(HashSet<Integer> set) {
        System.out.println(set.contains(3));
    }

    public void getLength(String str) {
        System.out.println(str.indexOf('o'));
    }

    public void getIndexOf(String str) {
        System.out.println(str.indexOf('r'));
    }

    public void getEquals(String str1, String str2) {
        System.out.println(str1.equals(str2));
    }

    public void getEqualIgnoreCase(String str1, String str2) {
        System.out.println(str1.equalsIgnoreCase(str2));
    }

    public void getJoin(String str1, String str2){
        System.out.println(String.join(str1, str2));
    }

    public void getlastIndexOf(String str) {
        System.out.println(str.lastIndexOf('r'));
    }

    public void getSubStrings(String str) {
        System.out.println(str.substring(1));
    }

    public void getToLowerCase(String str) {
        System.out.println(str.toLowerCase());
    }

    public void getToUpperCase(String str) {
        System.out.println(str.toUpperCase());
    }

    public void getTrim(String str) {
        System.out.println(str.trim());
    }

    public static void main(String args[]) {
        Methods m = new Methods();

        m.getCharAt("Sudeep");

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(2);


        m.getContains(set);

        m.getIndexOf("HelloWorld");

        m.getEquals("Hii", "hiii");

        m.getEqualIgnoreCase("Hii", "hii");

        m.getJoin("Hello", "World");

        m.getlastIndexOf("Sudii");

        m.getSubStrings("Heeloo");

        m.getToLowerCase("HELLO");

        m.getToUpperCase("hello");

        m.getTrim("Sudeep");
    }
}
