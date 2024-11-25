package com.example.callbacklib;


public class Student {

    int vigneshAdd(int a, int b){
        return a+b;
    }

    int rahulAdd(int a, int b){
        try {
            Thread.sleep(5000);
            return a+b;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
