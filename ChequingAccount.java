public class ChequingAccount{
  double overdraftAmount;
  double overdraftFee;
  BankAccount bank = new BankAccount();
  //Customer cus = new Customer();
  public ChequingAccount(){}
  public ChequingAccount(double overdraftFee){
    overdraftFee = overdraftFee;
  }

  public ChequingAccount(Customer accountHolder, double startBalance, double overdraftFee){
    bank.accountHolder = accountHolder;
    bank.balance = startBalance;
    overdraftFee = overdraftFee;
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

  public double getBalance(){
    return bank.getBalance();
  }

  public void transfer(int amount, BankAccount account){
  }

  public void deposit(double amount){
  }

  public Customer getCustomer(){
    return bank.getCustomer();
  }

  public void withdraw(double amount){

  }
}
