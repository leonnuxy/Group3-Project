/**
 Chequing account that is the child of Bank account. Allows for some override and a little more freedom than the stadnard bank account.
 */
public class ChequingAccount extends BankAccount {
    
    //Initialize instance variables
    private double overdraftAmount;
    private double overdraftFee;
    
    /* Constructor to set a new overdraft fee */
    public ChequingAccount(double new_overdraftFee){
        overdraftFee = new_overdraftFee;
    }
    
    /* Constructor to create a new chequing account */
    public ChequingAccount(Customer new_accountHolder, double new_startBalance, double new_overdraftFee){
        setCustomer(new_accountHolder);
        setBalance(new_startBalance);
        overdraftFee = new_overdraftFee;
    }
    
    public double getOverdraftFee(){
        return overdraftFee;
    }
    
    public void setOverdraftFee(double fee){
        overdraftFee = fee;
    }
    
    public void setOverdraftAmount(double amount){
        overdraftAmount = amount;
    }
    
    public double getOverdraftAmount(){
        return overdraftAmount;
    }
    
    /* Method to override the bank acount withdraw method to give the cequing account user more freedom in purchases and handle a withdrawl fee */
    public void withdraw(double amount){
        double new_balance = 0;
        double balance = getBalance();
        double adjusted_withdrawl = amount + overdraftFee;
        
        if ((balance - amount) < -overdraftAmount) {
            
            }
        else if ((balance - amount) >= -overdraftAmount) {
            if (amount <= (balance + overdraftAmount) && amount > balance) {
                new_balance = (balance - adjusted_withdrawl);
                setBalance(new_balance);
            }
            else if (amount >= balance + overdraftAmount) {
                
            }
            else {
                new_balance = balance - amount;
                setBalance(new_balance);
            }
        }
    }
    
    protected double getMonthlyFeesAndInterest() {
		double the_balance = getBalance();
		double return_value;
		if (the_balance > 0) {
			return_value = 0;
		}
		else {
			return_value = the_balance * 0.2;
		}
		return return_value;
	}
}
