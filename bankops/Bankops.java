package bankops;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import account.Account;

public class Bankops {

  HashMap<String, Account> accountsMap = new HashMap<>();

  public void createAccounts() {
    Account newAccount1 = new Account("Bob", "Burger", "pass1");
    addAccountToMap(newAccount1, accountsMap);
    Account newAccount2 = new Account("Stan", "Smith", "pass2");
    addAccountToMap(newAccount2, accountsMap);
    Account newAccount3 = new Account("Your", "Mom", "pass3");
    addAccountToMap(newAccount3, accountsMap);
    } 

  private void addAccountToMap(Account newAccount, Map<String, Account> map){
    map.put(newAccount.getUsername(), newAccount);
    System.out.println("New account for " + newAccount.getFname() + " " + newAccount.getLname() + " created");
    System.out.println("Your username is " + newAccount.getUsername());
  }
  
  public Account getAccount(String username, String password, Map<String, Account> map){
    Account selectedAccount = map.get(username);
    if (selectedAccount.getPassword().equals(getHash(password))){
      return selectedAccount;
    } else {
      return null;
    }
  }

  public String getHash(String password){
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] bytes = md.digest(password.getBytes());
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
          sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      password = sb.toString();
  } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
  }
    return password;
  }

  public void userInterface() {

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
          addAccountToMap(newAccount, accountsMap);
          break;

        case 2:
          System.out.println("Enter you username and password.");
          System.out.print("Username: ");
          String username = scanner.next();
          System.out.print("Password: ");
          String pass = scanner.next();
          Account acc = getAccount(username.toLowerCase(), pass, accountsMap);
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
    System.out.println("Good Bye");
  }
    
  
}
