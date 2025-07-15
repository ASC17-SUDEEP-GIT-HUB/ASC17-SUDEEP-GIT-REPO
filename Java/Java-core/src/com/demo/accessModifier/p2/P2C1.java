package com.demo.accessModifier.p2;

import com.demo.accessModifier.p1.P1C2;

public class P2C1 extends P1C2 {
    public void accessProtected() {
        subMethod();
        System.out.println(suba);
    }
    public static void main(String args[]) {
        P2C1 p1 = new  P2C1();
        p1.accessProtected();
    }
}
