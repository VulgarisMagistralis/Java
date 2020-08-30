package Bank;

public class BankAccountManager {

	public static void main(String[] args) {
		
		BasicAccount[] accountList = new BasicAccount[4];
		
		BasicAccount acc = new BasicAccount("Andrea", "Marcelli", 900);
		System.out.println(acc);
		acc.insertCreaditCardTransaction(20);
		acc.insertCreaditCardTransaction(100);
		acc.insertCreaditCardTransaction(45);
		System.out.println(acc.printCreditCardTransactions());
		
		System.out.println("SUM: " + acc.getCCSum());
		System.out.println("FEE: " + acc.getFee());		
		System.out.println("FINAL:" + acc.finalAccountBalance());
		
		PremiumAccount prem = new PremiumAccount("Andrea", "Marcelli", 900);
		prem.insertCreaditCardTransaction(20);
		prem.insertCreaditCardTransaction(100);
		prem.insertCreaditCardTransaction(45);
		
		System.out.println("FINAL:" + prem.finalAccountBalance());
		GoldAccount gold = new GoldAccount("Andrea", "Marcelli", 900);
		gold.insertCreaditCardTransaction(20);
		gold.insertCreaditCardTransaction(100);
		gold.insertCreaditCardTransaction(45);
		System.out.println("FINAL:"+ gold.finalAccountBalance());
		
		PlatinumAccount pl = new PlatinumAccount("Andrea", "Marcelli", 900);
		pl.insertCreaditCardTransaction(20);
		pl.insertCreaditCardTransaction(100);
		pl.insertCreaditCardTransaction(45);
		System.out.println("FINAL:"+ pl.finalAccountBalance());
		accountList[0] = acc;
		accountList[1] = prem;
		accountList[2] = gold;
		accountList[3] = pl;
		///compute all balnce to 
		for(BasicAccount b: accountList) {
			System.out.println(b.finalAccountBalance());
		}
		
		
	}

}
