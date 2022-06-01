package main;

import account.Account;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class UserInterface {

static Logger logger = Logger.getLogger(UserInterface.class.getName());
static HashMap<String, Account> accountsMap = new HashMap<>();
    public static void main(String[] args) {

      createAccounts();

      Scanner scanner = new Scanner(System.in);
      logger.info("Please select an option below.");
      logger.info("1. Create a new account");
      logger.info("2. Select account");

      int selection = scanner.nextInt();
      switch (selection) {
        case 1:
          System.out.println("Enter your first name.");
          String fName = scanner.next();
          System.out.println("Enter your last name.");
          String lName = scanner.next();
          Account newAccount = new Account(fName, lName);
          accountsMap.put(newAccount.getAccountNumerString(), newAccount);
          break;
        case 2:
          //get an account
        default:
          break;
      }
      scanner.close();
      logger.info("fin");
    }

  static void createAccounts() {
    Account newAccount1 = new Account("Bob", "Burger");
    accountsMap.put(newAccount1.getAccountNumerString(), newAccount1);
    Account newAccount2 = new Account("Stan", "Smith");
    accountsMap.put(newAccount2.getAccountNumerString(), newAccount2);
    Account newAccount3 = new Account("Your", "Mom");
    accountsMap.put(newAccount3.getAccountNumerString(), newAccount3);
  }
}
