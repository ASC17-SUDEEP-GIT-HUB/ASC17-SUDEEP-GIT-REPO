package com.demo.exception;

public class HandleMultipleExceptions {


    public static void main(String[] args) {
        String color[] = {"red", "green", "blue"};
        Calculator calculator = new Calculator();
        System.out.println("normal calculator");
        try {
            for(int i=0; i<= 3; i--) {
                System.out.println(color[i]);
            }

        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            calculator.add(50, 50);
            System.out.println("Check index");

        }catch(NullPointerException nullPointerException) {
            System.out.println("Instantiate the calculator");
        }
        finally {
            System.out.println("Thank you");
        }
    }
}
