package com.example.lib;

public class Gst extends IncomeTax {

    @Override
    public int calculateTax(int income) {
        int oldTax = super.calculateTax(income);
        int newTax = income/20;
        int gst = oldTax + newTax;
        return gst;
    }
}
