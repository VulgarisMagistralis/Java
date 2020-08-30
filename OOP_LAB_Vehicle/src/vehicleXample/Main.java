package vehicleXample;
import java.util.Random;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
public class Main {
	/* 1- Person cannot be both employee and customer -_-
	 * 2-
	 * */
	public static void main(String args[]) throws Exception {
		Main populate = new Main();	
		Map<String, Person> people = populate.readPeople(args[0]);
		Map<Integer, Company> banks = populate.readBanks(args[2]);
		Map<Integer, Company> dealers = populate.readDealer(args[3]);
		Map<String, Vehicle> vehicles = new TreeMap<>();
		populate.initExample(people);
		people.forEach((k,person) ->  {
			System.out.println("Started reading vehicles for " + person.getName());
			try {vehicles.putAll(populate.readVehicles(person));} 
			catch (IOException e) {System.err.println("Cannot add vehicles "+ e.getMessage());}
		});
		vehicles.forEach((k,v) -> System.out.println(v.getId()));
	}
	private Map<String,Vehicle> readVehicles(Person p) throws IOException {
		String line; String[] data; Vehicle tempVehicle;
		//int year, String make, String model,String bodytype
		Map<String,Vehicle> cars = new TreeMap<>();
		FileInputStream fileStream = new FileInputStream(p.getFile());
		BufferedReader userReader = new BufferedReader(new InputStreamReader(fileStream));
		while ((line = userReader.readLine()) != null) {
			//line.replaceAll("\n", "");
 			data = line.split(",");
 			if(data[3].equals("SUV")) tempVehicle = new SUV(Integer.parseInt(data[0]), data[1], data[2], p);
			else if(data[3].equals("Coupe"))tempVehicle = new Coupe(Integer.parseInt(data[0]),data[1],data[2],p);
			else if(data[3].equals("Sedan"))tempVehicle = new Sedan(Integer.parseInt(data[0]),data[1],data[2],p);	 
			else {System.err.println("Unexpected inquiry"); continue;}
			cars.put(tempVehicle.getId(), tempVehicle);
			p.getGarage().add(tempVehicle);
		}
		userReader.close();
		return cars;
	}
	private Map<Integer, Company> readDealer(String fileName) throws IOException {
		String line; String[] data; 
		Map<Integer, Company> comps = new TreeMap<>();
		FileInputStream fileStream = new FileInputStream(fileName);
		BufferedReader userReader = new BufferedReader(new InputStreamReader(fileStream));
		while ((line = userReader.readLine()) != null) {
			data = line.split(",");
			comps.put(data[1].hashCode(), new Dealership(data[0],data[1]));
		}
		userReader.close();
		return comps;
	}
	private Map<Integer, Company> readBanks(String fileName) throws IOException {
		String line; String[] data; 
		Map<Integer, Company> comps = new TreeMap<>();
		FileInputStream fileStream = new FileInputStream(fileName);
		BufferedReader userReader = new BufferedReader(new InputStreamReader(fileStream));
		while ((line = userReader.readLine()) != null) {
			data = line.split(",");
			comps.put(data[1].hashCode(), new Bank(data[0], data[1]));
		}
		userReader.close();
		return comps;
	}
	private Map<String, Person> readPeople(String fileName) throws IOException { ///problem in file format
		String line; String[] data; 
		Map<String, Person> peeps = new TreeMap<>();
		FileInputStream fileStream = new FileInputStream(fileName);
		BufferedReader userReader = new BufferedReader(new InputStreamReader(fileStream));
		while ((line = userReader.readLine()) != null) {
			data = line.split(",");
			if(data.length == 5) {
				// fiscal, company,  name, surname, double initialCredit
				peeps.put(data[2], new Employee(data[0], data[1], data[2], data[3],Double.parseDouble(data[4])));
			}else if(data.length == 4) {
				// fiscal name,  surname, double initialBalance
				peeps.put(data[2], new Customer(data[0], data[1], data[2], Double.parseDouble(data[3])));
			}else System.err.println("Unrecognized Sequence!");		
		}
		userReader.close();
		return peeps;
	}
	/*
	private void buyCars(Vehicle car, Person buyer) {
		if(!car.isOnSale()) {System.err.println("Vehicle NOT for sale");return;}
		if(buyer.getBalance()<car.getPrice()) {System.err.println("Cheap fuck!");return;}
		car.setOnSale(false);
		buyer.addToGarage(car);
		buyer.updateBalance(car.getPrice(), 1);
	}	
 	private void sellCars() {
		int i = 0;
		for(Person p: customers)
			if(i < p.getGarage().size()) p.putOnSale(p.getGarage().get(i++).getId());
			else p.putOnSale(p.getGarage().get(--i).getId());
	}*/
 	private void initExample(Map<String,Person> peeps) {
 		peeps.forEach((k,person) ->	populateSedan(peeps.size() * 2, person));
 		peeps.forEach((k,person) ->	populateCoupe(peeps.size() * 2, person));
 		peeps.forEach((k,person) ->	populateSUV(peeps.size() * 2, person));
 	}
	//int year, String make, String model,String bodytype -reading format
	private void populateSedan(int quantity, Person person) {
		String content, type  =",Sedan";//digrace!
		Random r = new Random(); int year;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(person.getFile()))) {
			for(int i = 0; i < quantity; i++) {
				year = r.nextInt(2018 -1956 + 1) + 1956;
				if(i % 3 == 0) content =  year +",BMW"+",335i"+ type;
				else if(i % 3 == 1) content = year +",MERCEDES"+ ",E250"+ type;
				else content = year + ",AUDI"+",RS6"+ type;
				bw.write(content+"\n");
			}
		}catch(IOException e) {System.err.println("Couldn't write to file "+e.getMessage());}
	}
	private void populateSUV(int quantity, Person person) {
		String content, type =",SUV";//digrace!
		Random r = new Random(); int year;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(person.getFile()))) {
			for(int i = 0; i< quantity; i++) {
				year  = r.nextInt(2019 -1956 + 1) + 1956;
				if(i % 3 == 0) content = year +",VOLVO"+",XC90"+ type;
				else if(i % 3 == 1) content = year +",JEEP"+",WRANGLER"+ type;
				else content = year+",CADILLAC"+",ESCLADE"+ type;
				bw.write(content+"\n");
			}
		}catch(IOException e) {System.err.println("Couln't write to file :" + e.getMessage());}
	}
	private void populateCoupe(int quantity, Person person) {
		String content, type =",Coupe"; //digrace!
		Random r = new Random();int year;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(person.getFile()))) {
			for(int i = 0; i < quantity; i++) {
				year = r.nextInt(2017 -1988 + 1) + 1988;
				if(i % 3 == 0) content = year +",FIAT"+",500"+ type;
				else if(i%3 == 1) content = year +",MAZDA"+",MIATA"+ type;
				else content = year +",PORSCHE"+",911T"+ type;
				bw.write(content+"\n");
			}
		}catch(IOException e) {System.err.println("File couldn't open: "+e.getMessage());}
	}
}






