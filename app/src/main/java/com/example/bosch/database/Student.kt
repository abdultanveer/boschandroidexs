package com.example.bosch.database;


public class Student {

    String name;
    int age;
    boolean isEligible;
    int phno;

    //ctrl+shift+A

    public Student(String name, int age, boolean isEligible, int phno) {
        this.name = name;
        this.age = age;
        this.isEligible = isEligible;
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }
}
