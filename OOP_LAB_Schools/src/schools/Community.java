package schools;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
public class Community {
	private String name;
	private Type type;
	public enum Type {MONTANA,COLLINARE};
	private Map<String, Municipality> munnies = new TreeMap<>();
	public Type getType(){return type;}
	public String getName() {return name;}
	public Community(String n,Type t) {name = n;type = t;}
	public Collection<Municipality> getMunicipalities() {return munnies.values();}
	public void addMuni(Municipality m) {if(!munnies.containsValue(m)) munnies.put(m.getName(), m);}
}
