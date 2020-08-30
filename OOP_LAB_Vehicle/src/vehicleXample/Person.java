package vehicleXample;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
public class Person {
	protected int age;
	protected String name;
	protected String sName;
	protected final String fCode;
	protected String garageFile;
	protected double balance = 100000;
	private ArrayList<Vehicle> garage = new ArrayList<Vehicle>();
	//add banking loans, access balance by bank etc.
	public void buyCar(Person seller, String vehicleID) {
		Vehicle onSale = null;
		for(Vehicle v: this.getGarage())if(v.getId().equals(vehicleID)) onSale = v;
		if(onSale == null) {System.err.println("NO car!"); return;}
		if(this.getBalance() < onSale.getPrice()) {System.err.println("YOU CANT");return;}
		System.out.println("Buying...");
		seller.updateBalance(onSale.getPrice(), 0);
		this.updateBalance(onSale.getPrice(), 1);
		this.removeCar(vehicleID);
		seller.addToGarage(onSale);
	}
	public void putOnSale(String vehicleID) {
		for(Vehicle v: getGarage())	if(v.getId().equals(vehicleID))
			if(!v.isOnSale()) v.setOnSale(true);
			else System.err.println("Already on sale, wanker!");
		System.err.println("Vehicle NOT found!");
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Person other = (Person) obj;
	    if(!name.equals(other.name)) return false;
		if(!sName.equals(other.sName))	return false;
		return fCode.equals(other.fCode);
	}
	public int getAge() {return age;}
	public String getName() {return name;}
	public String getfCode() {return fCode;}
	public String getsName() {return sName;}
	public String getFile() {return garageFile;}
	public double getBalance() {return balance;}
	public void setAge(int age) {this.age = age;}
	public int hashCode() {return fCode.hashCode();}
	public void setName(String name) {this.name = name;}
	public ArrayList<Vehicle> getGarage() {return garage;}
	public void setsName(String sName) {this.sName = sName;}
	public void addToGarage(Vehicle newVehicle) {garage.add(newVehicle);}
	public Person() {name = "Government"; sName = "Property"; fCode = "00000";}
	public void updateBalance(double spent, int operation){balance = balance + spent*((-1) ^ operation);}
	public Person(String name,String surname,String fiscal) {fCode = fiscal;this.name = name;this.sName = surname;age = 100;garageFile = sName+"_"+fCode+".txt";}
	public void removeCar(String vehicleID){for(Vehicle v : getGarage()) if(v.getId().equals(vehicleID))getGarage().remove(v);}
	public void printGarage() {
		Collections.sort(garage,new Comparator<Vehicle>() {	public int compare(Vehicle o1, Vehicle o2) {return (int) (o2.getPrice() - o1.getPrice());}});
		System.out.println(String.format("%-10s %-10s %-10s", name, sName, "'s garage:")); for(Vehicle v: garage) v.printVehicle();
	}	
}