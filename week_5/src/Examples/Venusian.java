package Examples;

public class Venusian extends Alien{

	private String jazz = "sadas";

	public Venusian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venusian(String planet, String name, int heads, int arms, int legs, String colour) {
		super(planet, name, heads, arms, legs, colour);
		// TODO Auto-generated constructor stub
	}
	public void playJazz() {
		System.out.println(jazz);
	}
	
}
