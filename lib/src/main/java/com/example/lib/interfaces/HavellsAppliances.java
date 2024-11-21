package com.example.lib.interfaces;

public class HavellsAppliances implements  SwitchBoardListenenr{

    @Override
    public void switchOne() {
        System.out.println("havells ac is on");
    }

    @Override
    public void switchTwo() {
        System.out.println("havells fan is on");

    }

    @Override
    public void switchThree() {
        System.out.println("havells light is on");

    }

    @Override
    public void switchFour() {
        System.out.println("havells heater is on");

    }
}
