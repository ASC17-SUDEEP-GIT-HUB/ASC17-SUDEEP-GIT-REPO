package com.demo.SOLID.CouplingCohesion;

interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("petrol engine started");
    }
}

class DiesolEngine implements Engine {
    public void start() {
        System.out.println("diesol engine started");
    }
}

class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
    }
}




