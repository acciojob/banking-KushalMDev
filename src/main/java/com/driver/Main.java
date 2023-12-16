package com.driver;

public class Main {
    public static void main(String[] args) {
      //  SavingsAccount savings=new SavingsAccount("Kushal",100000.0,5000,10.0);
      BankAccount bank=new BankAccount("SBi", 1000, 10);
      try {
        System.out.println(bank.generateAccountNumber(3, 20));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}