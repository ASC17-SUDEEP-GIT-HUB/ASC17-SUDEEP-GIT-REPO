package com.demo.SOLID.CouplingCohesion;

public class HighCoupling {

}

//Tightly coupling means car class directly depends on engine
class Engine1 {
    void start() {
        System.out.println("Engine started");
    }
}

class Car1 {
    Engine1 engine = new Engine1();

    void startCar() {
        engine.start();
    }
}


