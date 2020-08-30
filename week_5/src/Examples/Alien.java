	package Examples;

public class Alien {
	protected String planet;
	private String name;
	private int heads;
	private int arms;
	private int legs;
	protected String colour;
	public void greet() {
		System.out.println(" "+planet + " " +name+" " +heads+" "+colour+" "+legs+" "+ arms);
	}
	public Alien() {
		planet = "earth";
		arms = 2;
		heads = 1;
		legs = 2;
		colour = "purple";
	}
	public Alien(String planet, String name, int heads, int arms, int legs, String colour) {
		super();
		this.planet = planet;
		this.name = name;
		this.heads = heads;
		this.arms = arms;
		this.legs = legs;
		this.colour = colour;
	}

	/*private construct 
	 * to prevent people from creating instances
	 * instead make a static public GetInstance
	 * */
	public String getPlanet() {
		return planet;
	}
	public void setPlanet(String planet) {
		this.planet = planet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeads() {
		return heads;
	}
	public void setHeads(int heads) {
		this.heads = heads;
	}
	public int getArms() {
		return arms;
	}
	public void setArms(int arms) {
		this.arms = arms;
	}
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	

}
