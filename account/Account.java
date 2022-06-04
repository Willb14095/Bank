package account;
public class Account extends AccountAbstract{

    public Account(String fName, String lName, String password) {

        setFname(fName);
        setLname(lName);
        setUsername(fName, lName);
        setPassword(password);
        generateAccountNumber();
    }  

    public void deposit(double amount) {
        if (amount > 0) {
            updateBalance(amount);
        } else {
            System.out.println("Can only enter a postive amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
           updateBalance(amount * -1);
        } else {
            System.out.println("Can only enter a postive amount");
        }
        
    }
}
