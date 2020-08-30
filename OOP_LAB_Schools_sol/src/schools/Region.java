package schools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


/**
 * Represents the region and serves as a facade class
 * for the package.
 * 
 * It provides factory methods for creating instances of
 * {@link Community}, {@link Municipality}, {@link School}, and {@link Branch}
 *
 */
public class Region {
	private String nome;
	private Collection<School> scuole;
	private Collection<Community> comunita;
	private Collection<Municipality> comuni;
	
	/**
	 * Creates a new region with the given name.
	 * @param name the name of the region
	 */
	public Region(String nome){
		this.nome = nome;
		scuole=new LinkedList<>();
		comunita=new LinkedList<>();
		comuni=new LinkedList<>();
	}
	
	/**
	 * Getter method
	 * @return the name of the region
	 */
	public String getName(){return nome;}
	
	/**
	 * Retrieves all schools in the region
	 * @return collection of schools
	 */
	public Collection<School> getSchools() {
		return scuole;
	}
	
	/**
	 * Retrieves all the communities
	 * @return the collection of all communities
	 */
	public Collection<Community> getCommunities() {
		return comunita;
	}
	
	/**
	 * Retrieves all municipalities in the region
	 * @return the collection of municipalities
	 */
	public Collection<Municipality> getMunicipalies() {
		return comuni;
	}
	
	
	// factory methods
	
	/**
	 * Factory method that build a new community of the given type.
	 * The type is {@link Community.Type}
	 * 
	 * @param name name of the community
	 * @param type type of the community
	 * @return the new created community
	 */
	public Community newCommunity(String name, Community.Type type){
		Community c = new Community(name, type);
		comunita.add(c);
		return c;
	}

	/**
	 * Factory method that build a new municipality.
	 * 
	 * @param nome 		name of the municipality
	 * @param province 	province of the municipality
	 * @return the new created municipality
	 */
	public Municipality newMunicipality(String nome, String provincia){
		return newMunicipality( nome,  provincia,  null);
	}
	
	/**
	 * Factory methods, that build a new municipality that
	 * is part of a community.
	 * 
	 * @param nome 		name of the municipality
	 * @param province 	province of the municipality
	 * @param comunita  community the municipality belongs to 
	 * @return the new created municipality
	 */
	public Municipality newMunicipality(String nome, String provincia, Community comunita){
		Municipality c = new Municipality(nome, provincia, comunita);
		comuni.add(c);
		if(comunita!=null){
			comunita.add(c);
		}
		
		return c;
	}
	
	/**
	 * Factory method that creates a new school
	 * 
	 * @param name    name of the school
	 * @param code    code of the school
	 * @param grade	  grade of the school (1 to 4)
	 * @param description  description of the school
	 * 
	 * @return a new school object
	 */
	public School newSchool(String name, String code, int grade,
			String description){
		School s = new School(name, code, grade, description);
		scuole.add(s);
		
		return s;
	}
	
	/**
	 * Factory method that creates a new school branch
	 * 
	 * @param regionalCode	regional code of the branch
	 * @param municipality	municipality where the branch is located
	 * @param address		address of the branch
	 * @param zipCode		zip code of the branch
	 * @param school		school the branch is part of
	 * @return	the new created branch
	 */
	public Branch newBranch(int regionalCode, Municipality municipality, String indirizzo, int cap,
							School school)	{
		Branch s = new Branch(regionalCode, indirizzo, cap, municipality, school);
		school.addBranch(s);
		municipality.addBranch(s);
		
		return s;
	}
	
	/**
	 * Load data from a file.
	 * 
	 * The file must be a CSV file and it is supposed to contain the following fields:
	 * <ul>
	 *  <li>{@code "Provincia"},   (province)
	 *  <li>{@code "Comune"},		(municipality)
	 *  <li>{@code "Grado Scolastico"}, (school grade)
	 *  <li>{@code "Descrizione Scuola"}, (school description)
	 *  <li>{@code "Cod Sede"}, (branch code)
	 *  <li>{@code "Cod Scuola"}, (school code)
	 *  <li>{@code "Denominazione Scuola"}, (name of the school)
	 *  <li>{@code "Indirizzo e n. civico"}, (address of the branch)
	 *  <li>{@code "C.A.P."}, (zip code of the branch)
	 *  <li>{@code "Comunita Collinare"}, (Hill community)
	 *  <li>{@code "Comunita Montana"},  (Mountain community)
	 * </ul>
	 * 
	 * @param file the path of the file
	 */
	public void readData(String file) {
		List<String> lines = null;
		try(BufferedReader in = new BufferedReader(new FileReader(file))){
			lines = in.lines().collect(toList());
		}catch(IOException e) { System.err.println(e.getMessage()); }
				
		
		if(lines==null) return; 
		
		// extract headers and build the relative map 
		String[] headers = lines.remove(0).split(",");
		Map<String,Integer> h2i = new HashMap<>();
		for(int i=0; i<headers.length; ++i){
			h2i.put(headers[i], i);
		}
		lines
		.forEach( r -> {
			String[] row = r.split(",");
			Community comunita = getComunita(h2i,row);
			Municipality comune = comuni.stream()
					 .filter( c -> row[h2i.get("Comune")].equals(c.getName()))
					 .findFirst()
					 .orElseGet(() -> newMunicipality(row[h2i.get("Comune")],
							 						 row[h2i.get("Provincia")],
							 						 comunita
							 ))
					 ;
			School scuola = scuole.stream()
							.filter( s -> s.getCode().equals(row[h2i.get("Cod Scuola")] ))
							.findFirst()
							.orElseGet( () -> newSchool(row[h2i.get("Denominazione Scuola")],
							                            row[h2i.get("Cod Scuola")],
							                            Integer.parseInt(row[h2i.get("Grado Scolastico")].replaceAll(" *-.*$","")),
											  		    row[h2i.get("Descrizione Scuola")]
									))
							;
			/*Sede sede =*/ newBranch(Integer.parseInt(row[h2i.get("Cod Sede")]),
								  comune,
								  row[h2i.get("Indirizzo e n. civico")],
								  Integer.parseInt(row[h2i.get("C.A.P.")]),
								  scuola
					    );
		});
	}

	private Community getComunita(Map<String,Integer> h2i,String[] row){
		int cci = h2i.get("Comunita Collinare");
		String collinare = (cci>=row.length?"":row[cci]);
		int cmi = h2i.get("Comunita Montana");
		String montana = (cmi>=row.length?"":row[cmi]);
		if(collinare.length()!=0){
			return comunita.stream()
					.filter( c -> c.getName().equals(collinare))
					.findFirst()
					.orElseGet(() -> newCommunity(collinare, Community.Type.COLLINARE) );
		}else
		if(montana.length()!=0){
				return comunita.stream()
						.filter( c -> c.getName().equals(montana))
						.findFirst()
						.orElseGet(() -> newCommunity(montana, Community.Type.MONTANA) );
		}else
			return null;
	}
	
	/**
	 * Counts how many schools there exist for each description
	 * @return a map of school count vs. description
	 */
	public Map<String,Long>countSchoolsPerDescription(){
		return scuole.stream()
				.collect(groupingBy( s -> s.getDescription(),counting()))
				;
	}

	
	/**
	 * Count how many school branches there exist for each municipality
	 * @return a map of branch count vs. municipality
	 */
	public Map<String,Long>countBranchesPerMunicipality(){
		return scuole.stream()
				.map(School::getBranches)
				.flatMap(Collection::stream)
				.collect(groupingBy( s->s.getMunicipality().getName(),counting()))
				;
	}

	
	/**
	 * Counts the number of school branches per municipality
	 * and groups them by province.
	 * @return a map of maps the inner reports count of branches vs. municipality
	 * 			the outer reports provinces as keys
	 */
	public Map<String,Map<String,Long>>countBranchesPerMunicipalityPerProvince(){
		return scuole.stream()
		.map(School::getBranches)
		.flatMap(Collection::stream)
		.collect(groupingBy( s->s.getMunicipality().getProvince(), 
							groupingBy( s->s.getMunicipality().getName(),counting())
				))
		
		;
	}

	
	/**
	 * returns a list of strings with format
	 * {@code "### - XXXXXX"}, where 
	 * {@code ###} represents the number of schools (not branches)
	 * and {@code XXXXXX} represents the name of the municipality.
	 * If a school has more than one branch in a municipality
	 * it must be counted only once.
	 * 
	 * @return a collection of strings with the counts
	 */
	public Collection<String> countSchoolsPerMunicipality(){
		
//		return scuole.stream()
//				.map(Scuola::getSedi)
//				.flatMap(Collection::stream)
//				.collect(groupingBy( s->s.getComune().getNome(),
//									 mapping(Sede::getScuola,collectingAndThen(toSet(), Set::size))
//									)
//						)
//				.entrySet().stream()
//				.map( e -> e.getValue()+ " - "+e.getKey())
//				.collect(toList())
//				;
		return comuni.stream()
				.collect(TreeMap::new,
						 (a,c) -> a.put(c.getName(),c.getBranches().stream().map(Branch::getSchool).collect(toSet()).size()),
						 (a1,a2) -> a1.putAll(a2)
						)
				.entrySet().stream()
				.map( e -> e.getValue()+ " - "+e.getKey())
				.collect(toList())
				;
	}
	
	/**
	 * returns a list of strings with format
	 * {@code "### - XXXXXX"}, where 
	 * {@code ###} represents the number of schools (not branches)
	 * and {@code XXXXXX} represents the name of the community.
	 * They are sorted by descending number of schools.
	 * The list must contain only schools having at least
	 * a branch in a municipality part of a community.
	 * 
	 * @return a collection of strings with the counts
	 */
	public List<String> countSchoolsPerCommunity(){
		return scuole.stream()
				.map(School::getBranches)
				.flatMap(Collection::stream)
				.filter( s->s.getMunicipality().getCommunity().isPresent() )
				.collect(groupingBy( s->s.getMunicipality().getCommunity().get().getName(),
									 mapping(Branch::getSchool,collectingAndThen(toSet(), Set::size))
									)
						)
				.entrySet().stream()
				.sorted(comparing(Map.Entry::getValue,reverseOrder()))
				.map( e -> e.getValue()+ " - "+e.getKey())
				.collect(toList())
				;
	}

	
}
