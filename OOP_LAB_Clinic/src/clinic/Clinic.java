package clinic;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class Clinic {
	Map<String, Patient> sick = new TreeMap<>();
	Map<Integer, Doctor> docs = new TreeMap<>();
	public void addPatient(String first, String last, String ssn) {	if(!sick.containsKey(ssn)) sick.put(ssn, new Patient(first,last,ssn));}
	public String getPatient(String ssn) throws NoSuchPatient {if(!sick.containsKey(ssn)) throw new NoSuchPatient();return sick.get(ssn).toString();}
	public void addDoctor(String first, String last, String ssn, int docID, String specialization){if(!docs.containsKey(docID)) docs.put(docID, new Doctor(first, last, ssn,docID,specialization));}
	public String getDoctor(int docID) throws NoSuchDoctor {if(!docs.containsKey(docID)) throw new NoSuchDoctor();return docs.get(docID).toString();}
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		if(!sick.containsKey(ssn)) throw new NoSuchPatient();
		if(!docs.containsKey(docID)) throw new NoSuchDoctor();
		docs.get(docID).addPatient(sick.get(ssn));
		sick.get(ssn).setDoc(docs.get(docID));
	}
	public int getAssignedDoctor(String ssn) throws NoSuchPatient, NoSuchDoctor {
		if(!sick.containsKey(ssn)) throw new NoSuchPatient();
		if(sick.get(ssn).getDoc() == null) throw new NoSuchDoctor();
		return sick.get(ssn).getDoc().getID();
	}
	public Collection<String> getAssignedPatients(int id) throws NoSuchDoctor {if(!docs.containsKey(id)) throw new NoSuchDoctor();	return docs.get(id).getPatients();}
	public void loadData(Reader reader) throws IOException {
		String text; 
		while((text = (new BufferedReader(reader)).readLine()) !=  null) {
			String[] lineElements = text.split(";");
			if(lineElements.length == 4) addPatient(lineElements[1].trim(), lineElements[2].trim(), lineElements[3].trim());
			else if(lineElements.length == 6) addDoctor(lineElements[2].trim(),lineElements[3],lineElements[4].trim(),Integer.parseInt(lineElements[1]),lineElements[5].trim());
			else System.err.println("Unexpected line formatting! Line skipped");
		}	
	}
	public Collection<Integer> idleDoctors(){
		return docs.values().stream()
				.filter(x->((Doctor)x).getPatients().isEmpty())
				.sorted(Comparator.comparing(Doctor::toString))
				.map(Doctor::getID)
				.collect(Collectors.toList());
	}
	public Collection<Integer> busyDoctors(){
		double average = docs.values().stream().collect(Collectors.averagingInt(x->x.getPatients().size()));
		return docs.values().stream()
				.filter(x->x.getPatients().size()>average)
				.map(Doctor::getID)
				.collect(Collectors.toList());	
	}
	public Collection<String> doctorsByNumPatients(){
		return docs.values().stream()
				.sorted(Comparator.comparing(x->((Doctor)x).getPatients().size(),Comparator.reverseOrder()))
				.map(x->String.format("%3d",x.getPatients().size())+" : "+x.getID()+" "+x.getSurname()+" "+x.getName())
				.collect(Collectors.toList());
	}
	/**
	 * Retrieves the number of patients per (their doctor's)  specialization 
	 * <p>
	 * The information is a collections of strings structured as {@code ### - SPECIALITY}
	 * where {@code SPECIALITY} is the name of the speciality and 
	 * {@code ###} is the number of patients cured by doctors with such speciality (printed on three characters).
	 * <p>
	 * The elements are sorted first by decreasing count and then by alphabetic specialization.
	 * @return the collection of strings with specialization and patient count information.
	 */
	
	public Collection<String> countPatientsPerSpecialization(){
		return docs.values().stream()
				.collect(Collectors.groupingBy(summingInt(x->((Doctor)x).getPatients().size(),Collectors.mapping(x->((Doctor)x).getSpec()));
	}
	
}












