/** This class checks that a deposit is not negative and that any withdrawl does not exceed a pre set overdraft. This class can be called externally for use in checking fund transfer information */
public abstract class BankAccount {
    
    // Global variables set to the default values.
    private double balance = 0;
    private Customer accountHolder;
    
    /* This is a default constructor */
    public BankAccount(){}
    
    /* This method creates a constructor that takes the values for a customer and a new balance for the bank account */
    public BankAccount(Customer accountHolder, double startBalance){
        balance = startBalance;
        this.accountHolder = accountHolder;
    }
    
    public void  setCustomer(Customer someCustomer){
        accountHolder = someCustomer;
    }
    
    protected void setBalance(double amount){
        balance = amount;
    }
    
    /* This method checks that the deposited amount is greater than 0 and adds to their total balance */
    public void deposit(double amount) {
        if (amount > 0){
            balance = balance + amount;
        }
    }
    
    /* This method ensures that the user is not withdrawing more than their specified overdraft amount and calculates their total balance.*/
    public void withdraw(double amount) {
        if (balance >= amount){
            balance = balance - amount;
        }
    }
    
    public Customer getCustomer() {
        return accountHolder;
    }
    
    /* This method transfers money from one account to a specified account */
    public void transfer(double amount, BankAccount toAccount){
        double balance_check = balance;
        withdraw(amount);
        if (balance_check != balance){
            toAccount.deposit(amount);
        }
    }
    
    /* This getter method returns the balance */
    public double getBalance() {
        return balance;
    }
    
    protected abstract double getMonthlyFeesAndInterest();
    
    public void monthEndUpdate() {
        double month_end_value = getMonthlyFeesAndInterest();
        double a_balance = getBalance();
    		if (getMonthlyFeesAndInterest() < 0) {
    			balance = a_balance + getMonthlyFeesAndInterest();
    		}
    		else {
    			balance = a_balance + month_end_value * 12;
    		}
        //System.out.println("        " + getMonthlyFeesAndInterest());
    }
}
