package com.example.callbacklib;


public class Student {

    int vigneshAdd(int a, int b){
        return a+b;
    }

    void rahulAdd(int a, int b,MobilePhone phonneno){
        try {
            Thread.sleep(5000);
            phonneno.callBack(a+b);   //rahul is clicking the switch
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
