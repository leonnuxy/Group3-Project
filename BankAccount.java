/** This class checks that a deposit is not negative and that any withdrawl does not exceed a pre set overdraft. This class can be called externally for use in checking fund transfer information */
public class BankAccount {

    // Global variables set to the default values.
    double balance;
    double overdraftAmount = 100.0;
    Customer c;

    /* This is a default constructor */
    public BankAccount(){}

    /* This method creates a constructor that takes the values for a customer and a new balance for the bank account */
    public BankAccount(Customer aCustomer, double balance){
        this.balance = balance;
        this.c = aCustomer;

    }

    /* This method is a getter that returns the customer information */
    public Customer getCustomer() {
        return c;
    }

    /* This method is a setter that sets the name of the customer */
    public void  setCustomer(Customer someCustomer){
        c = someCustomer;
    }

    public void setBalance(double balance){
      this.balance = balance;
    }
    /* This method checks that the deposited amount is greater than 0 and adds to their total balance */
    public void deposit(double deposit_amount) {
        if (deposit_amount >= 0){
            balance = balance + deposit_amount;
        }
    }

    /* This method ensures that the user is not withdrawing more than their specified overdraft amount and calculates their total balance.*/
    public void withdraw(double withdraw_amount) {
        if (withdraw_amount - balance < overdraftAmount) {
            balance = balance - withdraw_amount;
        }
    }

    /* This getter method returns the balance */
    public double getBalance() {
        return balance;
    }

    /* This setter method allows the overdraft amount to be specified externally and returns the overdraftAmount after its assigned to the instance variable.*/
    public double setOverdraftAmount(double amount) {
        overdraftAmount = amount;
        return overdraftAmount;
    }
}
