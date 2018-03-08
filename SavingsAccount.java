public class SavingsAccount extends BankAccount {
	private double annualInterestRate = 0;
	public SavingsAccount() {
    super();
	}

	public SavingsAccount(Customer accountHolder, double startBalance, double annualInterestRate) {}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double new_annualInterestRate) {
		annualInterestRate = new_annualInterestRate;

	}

	public double getMonthlyFeesAndInterest() {
		double the_balance = getBalance();
    double the_annualInterestRate = getAnnualInterestRate();
    double adujstedAnnualInterestRate = the_annualInterestRate / 12;
    int monthlyFee = 5;
    if (the_balance < 1000.0){
      the_annualInterestRate = adujstedAnnualInterestRate - monthlyFee;
    }
    else if (the_balance >= 1000.0) {
      the_annualInterestRate = the_annualInterestRate /12;
    }
    return the_annualInterestRate;
	}

}
