package diet;
public class Product implements NutritionalElement{
	private double fat;
	private String name;
	private double carbs;
	private double calories;
	private double proteins;
	Product(String name,  double calories, double proteins, double carbs, double fat){
		this.calories = calories; this.proteins = proteins;
		this.carbs = carbs;this.name = name;this.fat = fat;
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(proteins) != Double.doubleToLongBits(other.getProteins()))return false;
		if (Double.doubleToLongBits(carbs) != Double.doubleToLongBits(other.getCarbs())) return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.getFat())) return false;
		if (name == null) return false; // actually names are already checked in hash
		else if (!name.equals(other.getName())) return false;
		return true;
	}
	public double getFat() {return fat;}
	public String getName() {return name;}
	public double getCarbs() {return carbs;}
	public boolean per100g() {return false;}
	public double getCalories() {return calories;}
	public double getProteins() {return proteins;}
	public int hashCode(){int code = Integer.parseInt(this.name); return code;}
}