package schools;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
public class Municipality {
	private String name;
	private String prov;
	private Optional<Community> com = null;
	private Map<String, School> schools = new TreeMap<>();
	public String getName() {return name;}
	public String getProvince() {return prov;}
	public Collection<Branch> getBranches() {
		ArrayList<Branch> branches = new ArrayList<>();
		for(School s: schools.values())if(!s.getBranches().isEmpty()) branches.addAll(s.getBranches());
		return branches;
	}
	public Optional<Community> getCommunity() {return com;}
	public Collection<School> getSchools(){return schools.values();}
	public Municipality(String name, String province, Community c) {com = Optional.ofNullable(c);this.name = name;prov = province;}
}
