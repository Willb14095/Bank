package main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

import account.Account;
import bankops.Bankops;

public class Bank {

static Logger logger = Logger.getLogger(Bank.class.getName());
static HashMap<String, Account> accountsMap = new HashMap<>();
static Bankops bankops = new Bankops();
  public static void main(String[] args) {

    bankops.createAccounts(accountsMap);

    Scanner scanner = new Scanner(System.in);
    Boolean cont = true;
    while ( Boolean.TRUE.equals(cont)) {
      System.out.println("Please select an option below.");
      System.out.println("1. Create a new account");
      System.out.println("2. Select account");
      System.out.println("3. Exit");
      int selection = scanner.nextInt();
      switch (selection) {
        case 1:
          System.out.println("Enter your first and last name.");
          System.out.print("First: ");
          String fName = scanner.next();
          System.out.print("Last: ");
          String lName = scanner.next();
          System.out.println("Enter a password.");
          String password = scanner.next();
          Account newAccount = new Account(fName, lName, password);
          bankops.addAccountToMap(newAccount, accountsMap);
          break;

        case 2:
          System.out.println("Enter you username and password.");
          System.out.print("Username: ");
          String username = scanner.next();
          System.out.print("Password: ");
          String pass = scanner.next();
          Account acc = bankops.getAccount(username.toLowerCase(), pass, accountsMap);
          if (acc != null){
            System.out.println("Select account action.");
          } else {
            System.out.println("Password is wrong.");
          }
          break;
    
        default:
          cont = false;
          break;
      }
    }
    scanner.close();
    logger.info("fin");
  }
}
