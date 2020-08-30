package Bank;

public class BasicAccount {
	//mostly container -> javabeans?
	protected String name;
	protected String surname;
	protected double initialBalance;
	protected int creditCardTransactionNumber = 0;
	protected double[] creditCardTransactions  = new double[10];
	
	
	
	public double finalAccountBalance() {
		double CCSum = getCCSum();
		double fee = getFee();
		return initialBalance - CCSum - fee;
	}
	
		
	public double getFee() {
		if(initialBalance>100) return initialBalance * 0.1;
		return 10;
	}

	public double getCCSum() {
		double sum =0;
		for(int i = 0; i < creditCardTransactionNumber; i++) sum = sum + creditCardTransactions[i];
		return sum;
	}





	public BasicAccount(String name, String surname, double initialBalance) {
		//super(); // referring to Object class of java
		this.name = name;
		this.surname = surname;
		this.initialBalance = initialBalance;
	}	
	public String printCreditCardTransactions() {
/*
		String all = "Found: "+creditCardTransactionNumber+"\n";
		for(int i = 0; i < creditCardTransactionNumber; i++) {
			all = all + creditCardTransactions[i] + "\n";
		}better way
		*/
		StringBuilder sb = new StringBuilder();
		sb.append("Found: "+creditCardTransactionNumber+"\n");
		for(int i = 0; i < creditCardTransactionNumber; i++) sb.append(creditCardTransactions[i] + "\n");
		return sb.toString();
	}
	public void insertCreaditCardTransaction(double transaction) {
		creditCardTransactions[creditCardTransactionNumber++] = transaction;
	}
	@Override
	public String toString() {
		return name+" " +surname+" "+initialBalance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public double[] getCreditCardTransactions() {
		return creditCardTransactions;
	}
	public void setCreditCardTransactions(double[] creditCardTransactions) {
		this.creditCardTransactions = creditCardTransactions;
	}	
}
