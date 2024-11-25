package com.example.callbacklib;

public class CallbacksDemo {

    public static void main(String[] args) {
        System.out.println("callbacks demo");
        Student student = new Student();
        Myself phno = new Myself(); //wiring
        System.out.println("vignesh sum --" + student.vigneshAdd(10,20));
        new Thread(){
            @Override
            public void run() {
                super.run();
                student.rahulAdd(10,20,phno);
            }
        }.start();
        System.out.println("leave for airport");
    }
}