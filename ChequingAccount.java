/**
 Chequing account that is the child of Bank account. Allows for some override and a little more freedom than the stadnard bank account.
 */
public class ChequingAccount extends BankAccount {
    
    //Initialize instance variables
    double overdraftAmount;
    double overdraftFee;
    
    /* Constructor to set a new overdraft fee */
    public ChequingAccount(double new_overdraftFee){
        overdraftFee = new_overdraftFee;
    }
    
    /* Constructor to create a new chequing account */
    public ChequingAccount(Customer new_accountHolder, double new_startBalance, double new_overdraftFee){
        accountHolder = new_accountHolder;
        balance = new_startBalance;
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
    @Override
    public void withdraw(double amount){
        double adjusted_withdrawl = amount + overdraftFee;
        if (amount <= (balance + overdraftAmount) && amount > balance) {
            balance = balance - adjusted_withdrawl;
            //setBalance(balance);
        }
        else if (amount >= balance + overdraftAmount) {
            
        }
        else {
            balance = balance - amount;
        }
    }
}
