package com.demo.lab1;

public class MethodOverloading {

    static class Adding {
        public int add(int a, int b) {
            return a + b;
        }

        public int add(int a, int b, int c) {
            return a + b  + c;
        }

        public float add(float a, float b) {
            return a + b;
        }

        public String add(String a, int b) {
            return a + b;
        }
    }

    public static void main(String args[]) {
        Adding a = new Adding();
        System.out.println(a.add(10, 20));
        System.out.println(a.add(10, 20, 30));
        System.out.println(a.add("Hello", 20));
    }
}

