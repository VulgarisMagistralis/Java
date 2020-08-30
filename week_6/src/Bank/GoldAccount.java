package Bank;

public class GoldAccount extends PremiumAccount{

	public GoldAccount(String name, String surname, double initialBalance) {
		super(name, surname, initialBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getInterest() {
		return initialBalance * 0.004;
	}

	@Override
	public double getPenalty() {
		if(initialBalance <= 250)	return 0;
		return initialBalance * 0.005;
	}

}
