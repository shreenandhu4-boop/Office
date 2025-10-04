package com.org.office.practice.examples;

abstract class Vehicle {
	abstract void accelerate();
    abstract void brake(); // Abstract methods (what it can do)
    
    void startEngine() {
        System.out.println("Engine started!");
    } // Concrete method (common to all vehicles)
}

class Car extends Vehicle {
    @Override
    void accelerate() {
        System.out.println("Car: Pressing gas pedal...");
        // Hidden complex logic: fuel injection, gear shifting, etc.
    }
    @Override
    void brake() {
        System.out.println("Car: Applying brakes...");
        // Hidden logic: hydraulic pressure, brake pads, etc.
    }
    public class Main {
        public static void main(String[] args) {
            Vehicle myCar = new Car();
            myCar.startEngine();  
            myCar.accelerate();   
            myCar.brake();        
        }
    }
}

