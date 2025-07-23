package com.demo.SOLID.CouplingCohesion;

public class HighCohesion {
    private int amount;

    public int calcAmount() {
        return amount * 10;
    }

    public void invoice() {
        System.out.println("Invoice is generated!");
    }
}

class LowCohesion {

    //low coupling due to many methods in a single class
    public void setAccount(){
        System.out.println("set acc");
    }
    public void setPassword() {
        System.out.println("set password");
    }
    public void sendDetails() {

    }
}