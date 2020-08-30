package diet;
public class Menu implements NutritionalElement {
	protected Food food;
	private String name;
	private double fat = 0;
	private double carbs = 0;
	private double proteins = 0;
	private double calories = 0;
	public Menu(String name, Food food){this.name = name;this.food = food;}
	public void addRecipe(String recipe, double quantity) {
		for(NutritionalElement p: food.recipes())
			if(p.getName().equals(recipe)) {
				this.addFat(norm(p.getFat(), quantity, 100)); 
				this.addCarbs(norm(p.getCarbs(), quantity, 100));
				this.addCalories(norm(p.getCalories(), quantity, 100));
				this.addProteins(norm(p.getProteins(), quantity, 100));
				return;
			}
	}
	public void addProduct(String product) {
		for(NutritionalElement p: food.products())
			if(p.getName().equals(product)) {
				this.addFat(p.getFat()); 
				this.addCarbs(p.getCarbs());
				this.addCalories(p.getCalories());
				this.addProteins(p.getProteins());
				return;
			}
	}
	public double getFat() {return fat;}
	public String getName() {return name;}
	public boolean per100g() {return false;}
	public double getCarbs() {return carbs;}
	public double getCalories() {return calories;}
	public double getProteins() {return proteins;}
	public void addFat(double fat) {this.fat += fat;}
	public void addCarbs(double carbs) {this.carbs += carbs;}
	private double norm(double a,double b, double c) {return a * b / c;}
	public void addProteins(double proteins) {this.proteins += proteins;}
	public void addCalories(double calories) {this.calories += calories;}
}