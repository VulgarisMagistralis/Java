package vehicleXample;
import java.util.ArrayList;
public class Bank implements Company{
	private String name;
	private String companyId;
	private ArrayList<Person> users;
	private ArrayList<Employee> bankers;
	private ArrayList<Vehicle> seizedVehicles;
	public Bank(String name, String id) {
		companyId = id;
		this.name = name;
		bankers = new ArrayList<>();
		seizedVehicles = new ArrayList<>();
	}
	public void addToInventory(Vehicle v) {
		if(v == null) return;
		if(seizedVehicles.contains(v)) return;
		seizedVehicles.add(v);
	}
	//Implemented methods
	public void setName(String name){
		if(name.isEmpty()) return;
		this.name = name;
	}
	public void addWorker(Employee ...juniors){
		if(juniors == null) return;
		for(Employee e: juniors) if(!bankers.contains(e)) bankers.add(e);
	}
	public void addUsers(Person ...newUsers){
		if(newUsers == null) return;
		for(Person p : newUsers) users.add(p);
	}
	public ArrayList<Vehicle> getAssets(){return seizedVehicles;}
	public int getTotalAssets() {return seizedVehicles.size();}
	public ArrayList<Employee> getWorkers(){return bankers;}
	public int getTotalWorkers(){return bankers.size();}
	public ArrayList<Person> getUsers() {return users;}
	public String getCompanyId(){return companyId;}
	public String getName() {return name;}
}