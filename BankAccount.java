/** This class checks that a deposit is not negative and that any withdrawl does not exceed a pre set overdraft. This class can be called externally for use in checking fund transfer information */
public class BankAccount {
    
    double balance;
    double overdraftAmount = 100.0;
    
    /* This method checks that the deposited amount is greater than 0 and adds to their total balance */
    public void deposit(double entryd) {
        if (entryd >= 0){
            balance = balance + entryd;
        }
        else {
            System.out.println("You cannot deposit a negative amount of funds.");
        }
    }
    
    /* This method ensures that the user is not windrawing more than their specified overdraft amount and calculates their total balance */
    public void withdraw(double entryw) {
        if (balance - entryw < -overdraftAmount) {
            System.out.println("You cannot withdraw more funds than your overdraft limit allows.");
        }
        else {
            balance = balance - entryw;
        }
    }
    
    /* This getter method gets the balance */
    public double getBalance() {
        return balance;
    }
    
    /* This setter method allows the overdraft amount to be specified externally */
    public double setOverdraftAmount(double number) {
        overdraftAmount = number;
        return overdraftAmount;
    }
}
