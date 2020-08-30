package Bank;

public class PlatinumAccount extends PremiumAccount{

	public PlatinumAccount(String name, String surname, double initialBalance) {
		super(name, surname, initialBalance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getInterest() {
		// TODO Auto-generated method stub
		return initialBalance * 0.007;
	}

	@Override
	public double getPenalty() {
		// TODO Auto-generated method stub
		if(initialBalance <= 500)	return 0;
		return initialBalance * 0.007;
	}
	

}
