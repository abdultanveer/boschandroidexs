package com.example.callbacklib;

public class CallbacksDemo {

    public static void main(String[] args) {
        System.out.println("callbacks demo");
        Student student = new Student();
        System.out.println("vignesh sum --" + student.vigneshAdd(10,20));
        System.out.println("rahul sum --"+ student.rahulAdd(10,20));
        System.out.println("leave for airport");
    }
}