package diet;
public class RawMaterial implements NutritionalElement{
	private String name;
	private double fat;
	private double carbs;
	private double proteins;
	private double calories;
	RawMaterial(String name, double calories,  double proteins, double carbs, double fat){
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.name = name;
		this.fat = fat;
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		RawMaterial other = (RawMaterial) obj;
		if (Double.doubleToLongBits(proteins) != Double.doubleToLongBits(other.getProteins()))return false;
		if (Double.doubleToLongBits(carbs) != Double.doubleToLongBits(other.getCarbs()))return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.getFat()))return false;
		if (name == null) return false; // actually names are already checked in hash
		else if (!name.equals(other.getName())) return false;
		return true;
	}
	public double getFat() {return fat;}
	public String getName() {return name;}
	public boolean per100g() {return true;}
	public double getCarbs() {return carbs;}
	public double getCalories() {return calories;}
	public double getProteins() {return proteins;}
	public int hashCode() {int code = Integer.parseInt(this.name); return code;}
}