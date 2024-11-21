package com.example.lib.interfaces;


public class GEAppliances implements SwitchBoardListenenr {

    @Override
    public void switchOne() {
        System.out.println("GE ac is on");
    }

    @Override
    public void switchTwo() {
        System.out.println("GE fan is on");

    }

    @Override
    public void switchThree() {
        System.out.println("GE light is on");

    }

    @Override
    public void switchFour() {
        System.out.println("GE heater is on");

    }
}
