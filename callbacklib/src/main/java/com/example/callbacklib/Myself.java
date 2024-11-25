package com.example.callbacklib;




public class Myself implements MobilePhone{
    @Override
    public void callBack(int sum) {     //implementation/appliance
        System.out.println("rahuls sum = "+sum);
    }
}
