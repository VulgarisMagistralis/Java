package vehicleXample;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
public class Employee extends Person{
	private ArrayList<Vehicle> soldCars;
	private String companyName; // foreign key
	private int numberOfSales = 0;
	public Employee() {super("Government", "Property", "00000");}
	public Employee(String fiscal, String company, String name, String surname, double initialCredit) {
		super(name, surname, fiscal);
		super.balance = initialCredit;
		companyName = company;
	}
	public String getSaleRep() {
		String report = "";
		double total = 0.0;
		for(Vehicle v : soldCars) {
			total = total + v.getPrice();
			report = report + v.toString() + "\n";
		}
		report = report + "Total sold:" + total;
		return report;
	}
	@Override
	public String toString() {
		NumberFormat toCurrency = NumberFormat.getCurrencyInstance(Locale.ITALY);
		return String.format("%-15s %-15s %-10s %-5d %-7s %-15s", 
				super.name, 
				super.sName,
				super.fCode,
				soldCars.size(),
				toCurrency.format(super.balance),
				companyName);
	}
	public void updateBalance(double spent,int operation) {super.balance = super.balance + spent*((-1) ^ operation) + getAdvance();}
	public double getAdvance() {return numberOfSales * 0.03;}
	public void sellCar(Person buyer, String vehicleID) {
		Vehicle onSale = null;
		for(Vehicle v: this.getGarage())if(v.getId().equals(vehicleID)) onSale = v;
		if(onSale == null) {System.err.println("NO car!"); return;}
		if(this.getBalance() < onSale.getPrice()) {System.err.println("YOU CANT");return;}
		System.out.println("Buying...");
		buyer.updateBalance(onSale.getPrice(), 1);
		this.updateBalance(onSale.getPrice(), 0);
		this.removeCar(vehicleID);
		buyer.addToGarage(onSale);
		numberOfSales++;
	}
}
