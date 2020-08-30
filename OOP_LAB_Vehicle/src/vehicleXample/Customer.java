package vehicleXample;
import java.text.NumberFormat;
import java.util.Locale;
public class Customer extends Person{
	public Customer(){super("DumbassBros", "Inc.", "00000");}
	public Customer(String fiscal, String name, String surname, double initialBalance) {
		super(name, surname, fiscal);
		super.balance = initialBalance;		
	}
	@Override
	public String toString() {
		NumberFormat toCurrency = NumberFormat.getCurrencyInstance(Locale.ITALY);
		return String.format("%-15s %-15s %-10s %-5d %7s",
				super.name,
				super.sName,
				super.fCode,
				super.getGarage().size(),
				toCurrency.format(super.balance));
	}
}
