public class BankAccount {
    
    // Global variables set to the default values.
    double balance;
    double overdraftAmount = 100.0;
    Customer c = new Customer();
    
    public BankAccount(){}
    public BankAccount(Customer aCustomer, double balance){
        this.balance = balance;
        this.c = aCustomer;
        
    }
    
    public Customer getCustomer() {
        return c;
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


