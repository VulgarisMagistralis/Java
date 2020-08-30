package vehicleXample;
import java.util.ArrayList;
public interface Company {
	//Getters- Setters
	public String getName();
	public int getTotalAssets();
	public String getCompanyId();
	public int getTotalWorkers();
	public void setName(String name);	
	public void addWorker(Employee ...e);
	public ArrayList<Vehicle> getAssets();	
	public ArrayList<Employee> getWorkers();
}
