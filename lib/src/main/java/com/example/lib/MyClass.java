package com.example.lib;

public class MyClass {

    public static void main(String[] args) {
        MathOperations mathOperations = new MathOperations();
        mathOperations.add(10,20,30);

        IncomeTax tax = new IncomeTax();
        System.out.println("the tax is --"+tax.calculateTax(100000));

        Gst gst = new Gst();
        System.out.println("gst is "+gst.calculateTax(100000));
    }
}