package com.demo.accessModifier.p1;

public class P1C2 {
    protected String suba = "Hiiii";
    protected  void subMethod() {
        System.out.println("Hii");
    }

    public static void main(String args[]) {
        P1C2 p1c2 = new P1C2();
        System.out.println(p1c2.suba);
        p1c2.subMethod();
    }
}
