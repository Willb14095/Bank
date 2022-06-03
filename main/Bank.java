package main;

import bankops.Bankops;

public class Bank {


static Bankops bankops = new Bankops();
  public static void main(String[] args) {

    bankops.createAccounts();
    bankops.userInterface();

  }  
}
