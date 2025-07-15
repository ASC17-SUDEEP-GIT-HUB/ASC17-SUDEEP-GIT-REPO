package com.demo.accessModifier.p1;

public class P1C1 {
    //instance variable
    private String privateVar;
    private void privateMethod() {
        System.out.println(privateVar);
    }

    public static void main(String[] args){
        P1C1 p1c1 = new P1C1();
        System.out.println(p1c1.privateVar);
        p1c1.privateMethod();
    }
}
