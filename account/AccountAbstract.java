package account;
import java.math.BigDecimal;

public abstract class AccountAbstract {

    String fName;
    String lName;

    BigDecimal balance;
    String accountNumber;

    public BigDecimal getBalance(){
        return balance;
    };

    public void updateBalance(Double value){

        if (value >=0) {
            BigDecimal bd = BigDecimal.valueOf(value);
            balance.add(bd);
        } else {
            BigDecimal bd = BigDecimal.valueOf(value);
            balance = bd.subtract(balance);
        }
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
    public String getAccountNumerString(){
        return accountNumber;
    }


}