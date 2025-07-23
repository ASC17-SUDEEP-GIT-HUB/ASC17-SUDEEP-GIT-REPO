package com.demo.Collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Map {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        Laptop lap1 = new Laptop("Inspire", 10);
        Laptop lap2 = new Laptop("Hpp", 12);

        map.put("Hp", lap1);

        map.put("Lenovo", lap1);

        map.put(null, new Laptop("Macbook", 12));

        map.put("null", new Laptop("Tuf", 32));

        map.put(null, new Laptop("rog", 22));

        map.put("null", new Laptop("vaio", 11));
        System.out.println(map);

//        for(int i=0; i<map.size(); i++) {
//            System.out.println(map.get(i));
//        }

        Collection<Object> values = map.values();

        for(Object value : values) {
            System.out.println(value);
        }
    }

    public static void treeMap() {
        TreeMap<Object, Object> map1 = new TreeMap<Object, Object>();

        Laptop laptop1 = new Laptop("I", 90);

    }
}

class Laptop {
    String name;
    float price;

    public Laptop(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop [laptopName: " + name + ", price: " + price + "]";
    }
}
