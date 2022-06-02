package bankops;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import account.Account;

public class Bankops {

  public void createAccounts(Map<String, Account> map) {
    Account newAccount1 = new Account("Bob", "Burger", "pass1");
    addAccountToMap(newAccount1, map);
    Account newAccount2 = new Account("Stan", "Smith", "pass2");
    addAccountToMap(newAccount2, map);
    Account newAccount3 = new Account("Your", "Mom", "pass3");
    addAccountToMap(newAccount3, map);
    } 

  public void addAccountToMap(Account newAccount, Map<String, Account> map){
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
}
