package account;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public abstract class AccountAbstract {

    String fName;
    String lName;
    String username;
    String password;
    BigDecimal balance = new BigDecimal("0.0");
    String accountNumber;

    public BigDecimal getBalance(){
        return balance;
    }

    public void updateBalance(Double value){

        if (value >=0) {
            BigDecimal bd = BigDecimal.valueOf(value);
            balance = balance.add(bd);
        } else {
            BigDecimal bd = BigDecimal.valueOf(Math.abs(value));
            balance = balance.subtract(bd);
        }
    }

    public void setUsername(String first, String last){
        if (first.length() >= 2 && last.length() >= 4) {
            username = first.substring(0,2).toLowerCase() + last.substring(0,4).toLowerCase();
        } else {
            username = first.substring(0,2).toLowerCase() + last.toLowerCase();
        } 
    }
    public String getUsername(){
        return username;
    }

    public void setFname(String name){
        fName = name;
    }
    public void setLname(String name){
        lName = name;
    }

    public String getFname(){
        return fName;
    }
    public String getLname(){
        return lName;
    }

    public void generateAccountNumber(){
        accountNumber = UUID.randomUUID().toString(); //change this to smaller String
    }
    public String getAccountNumerString(){
        return accountNumber;
    }

    public void setPassword(String pass){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(pass.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            password = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public String getPassword(){
        return password;
    }
}