public class SavingsAccount extends BankAccount {
	private static double annualInterestRate = 0;
	public SavingsAccount() {
    super();
	}

	public SavingsAccount(Customer accountHolder, double startBalance, double annualInterestRate) {
		/*This declaration of the Savings account variable is meant to pass a new instance of annualInterestRate
		as property of SavingsAccount since it has already been declared as a static variable. 
		
		This comes in handy because in referencing annualInterestRate in any class we can make sure that we do
		not need a new object of the SavingsAccount class to use the variable rather we can simply call it by 
		 SavingsAccount.annualInterestRate. */
		
		//SavingsAccount.annualInterestRate = annualInterestRate;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double new_annualInterestRate) {
		annualInterestRate = new_annualInterestRate;

	}

	public double getMonthlyFeesAndInterest() {
		double the_balance = getBalance();
    double the_annualInterestRate = getAnnualInterestRate();
    double adujstedAnnualInterestRate = the_annualInterestRate / 12;
    int monthlyFee = 5;
		double percentile = the_balance*(annualInterestRate/100);
    if (the_balance < 1000.0){
      the_annualInterestRate = adujstedAnnualInterestRate - monthlyFee;
    }
    else if (the_balance >= 1000.0) {
      the_annualInterestRate = percentile/12;
    }
    return the_annualInterestRate;
	}

}
