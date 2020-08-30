package vehicleXample;
public final class Sedan extends Vehicle{
	public Sedan(int year, String make, String model, Person peep) {
		super(year, make, model, peep);
		super.bodyType = "Sedan";
		super.setPrice(10000000 / year);
	}
	public String getBodyType() {return "sedan";}
}
