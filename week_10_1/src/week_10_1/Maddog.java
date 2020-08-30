package week_10_1;

public class Maddog {
	String name;
	String col;
	double weight;
	int bodycount = 1845;
	
	public Maddog(String n) {
		name = n;
	}
	
	@Override
	public String toString() {
		return "Maddog [name=" + name + "  " + bodycount + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getBodycount() {
		return bodycount;
	}

	public void setBodycount(int bodycount) {
		this.bodycount = bodycount;
	}

	public boolean bark(String s) {
		System.out.println("DEATH COMES");
		return false;
	}


}
