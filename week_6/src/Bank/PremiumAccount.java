package Bank;

public class PremiumAccount extends BasicAccount{

	public PremiumAccount(String name, String surname, double initialBalance) {
		super(name, surname, initialBalance);
		
		
	}
	public double finalAccountBalance() {
		double CCSum = getCCSum();
		double fee = getFee();
		double penalty = getPenalty();
		double interest = getInterest();
		return initialBalance - CCSum - fee- penalty + interest;
	}
	public double getInterest() {
		return initialBalance * 0.0015;
	}
	public double getPenalty() {//something fishy
		if(initialBalance <= 100)	return 0;
		return initialBalance * 0.003;
	}
}
