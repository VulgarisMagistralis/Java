package week_8;

public class Dog implements Creature,MoreShit{
	private String name;
	private boolean happy;
	public Dog(String name) {
		this.name = name;
		happy = true;
	}
	@Override
	public String name() {
		return name;		
	}

	@Override
	public void greet() {
		System.out.println("I like doing human activities");
		
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
	@Override // have to choose thie or wut in other interface
	public void wut() {
		// TODO Auto-generated method stub
		Creature.super.wut();
		Creature.wierd();
		//super because it is not a static method
	}
	//static methods cannot be over1ridden and cannot be inherited
	void boring() {
		MoreShit.name(); // like a helper function
	}
	
	
}
