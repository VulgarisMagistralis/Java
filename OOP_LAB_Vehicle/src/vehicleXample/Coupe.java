package vehicleXample;
public final class Coupe extends Vehicle{
	public Coupe(int year, String make, String model, Person peep) {
		super(year, make, model, peep);
		super.bodyType = "Coupe";
		super.setPrice(30000000 / year);
	}
	public String getBodyType() {return "coupe";}
}
