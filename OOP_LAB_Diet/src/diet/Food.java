package diet;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
public class Food {
	SortedMap<String,NutritionalElement> recipes = new TreeMap<>();
	SortedMap<String,NutritionalElement> rawMats = new TreeMap<>();
	SortedMap<String,NutritionalElement> products = new TreeMap<>();
	public void defineRawMaterial(String name, double calories, double proteins, double carbs, double fat){
		RawMaterial newRaw = new RawMaterial(name, calories, proteins, carbs, fat);
		rawMats.put(name, newRaw);
	}
	public void defineProduct(String name,  double calories, double proteins, double carbs, double fat){
		Product newPro = new Product(name, calories, proteins, carbs, fat);
		products.put(name, newPro);
	}
	public void addRecipe(NutritionalElement r){recipes.put(r.getName(),r);}
	public Collection<NutritionalElement> recipes(){return recipes.values();}
	public NutritionalElement getRecipe(String name){return recipes.get(name);}
	public Collection<NutritionalElement> products(){return products.values();}
	public NutritionalElement getProduct(String name){return products.get(name);}
	public Collection<NutritionalElement> rawMaterials(){return rawMats.values();}
	public NutritionalElement getRawMaterial(String name){return rawMats.get(name);}
}