package account;

import java.math.BigDecimal;
import java.util.UUID;

public class Account extends AccountAbstract{

    public Account(String fName, String lName) {

        setFname(fName);
        setLname(lName);

        accountNumber = UUID.randomUUID().toString(); //change this to smaller String
        balance = new BigDecimal(0);
    }
    
}
