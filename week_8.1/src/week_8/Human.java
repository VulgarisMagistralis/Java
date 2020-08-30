package week_8;

public class Human implements Creature{
	private String name;
	private boolean happy;
	public Human(String name) {
		this.name = name;
		happy = false;
	}
	@Override
	public String name() {
		return name;
		
		
	}

	@Override
	public void greet() {
		System.out.println("Hi");
		
	}
	@Override
	public void makeHappy() {
		happy = true;
		
	}
	@Override
	public void makeSad() {
		happy = false;
	}
	@Override
	public boolean isHappy() {
		return happy;
	}

}
