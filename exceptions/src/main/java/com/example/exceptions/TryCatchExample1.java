package com.example.exceptions;

public class TryCatchExample1 {
  
    public static void main(String[] args) {

        try {
            int data=50/0;
        } catch (Exception e) { //hanndler
            System.out.println("talking to the chemist");
        }

        System.out.println("rest of the code");  
          
    }  
      
}  