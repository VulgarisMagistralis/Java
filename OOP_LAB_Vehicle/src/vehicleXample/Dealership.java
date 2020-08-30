package vehicleXample;
import java.util.ArrayList;
import java.util.Iterator;
public class Dealership implements Iterable<Person>, Company{
	private String name;
	private String companyId;
	private int totalAssets = 0;
	private int totalWorkers = 0;
	private ArrayList<Vehicle> assets;
	private ArrayList<Employee> workers;
	public Dealership(String name, String id) {
		companyId = id;
		this.name = name;
		assets = new ArrayList<>();
		workers = new ArrayList<>();
	}
	//Utility
	public void updateInventory() {
		boolean present;
		for(Employee e: workers) for(Vehicle v: e.getGarage()) if(!assets.contains(v)){assets.add(v);totalAssets++;}
		for(Vehicle v: assets) {
			present = false;
			for(Employee e: workers) if(e.getGarage().contains(v)) present = true; 
			if(!present) {totalAssets--; assets.remove(v);}
		}	
	}
	@Override // needs a check
	public Iterator<Person> iterator() {
		return new Iterator<Person>() {
			int current = 0;
			public boolean hasNext() {return (current < totalWorkers);}
			public Person next() {return workers.get(current++);}
		};
	}
	//Getters- Setters
	public String getName() {return name;}
	public String getCompanyId() {return companyId;}
	public int getTotalAssets() {return totalAssets;}
	public int getTotalWorkers() {return totalWorkers;}
	public void setName(String name) {this.name = name;}	
	public ArrayList<Vehicle> getAssets() {return assets;}	
	public ArrayList<Employee> getWorkers() {return workers;}
	public void addWorker(Employee... juniors) {
		if(juniors == null) return;
		for(Employee e: juniors)workers.add(e);
		updateInventory();
	}
	public void retireWorker(Employee e) {if(e==null)return;workers.remove(e);updateInventory();}
}