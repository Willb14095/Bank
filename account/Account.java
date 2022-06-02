package account;
public class Account extends AccountAbstract{

    public Account(String fName, String lName, String password) {

        setFname(fName);
        setLname(lName);
        setUsername(fName, lName);
        setPassword(password);
        generateAccountNumber();
    }  
}
