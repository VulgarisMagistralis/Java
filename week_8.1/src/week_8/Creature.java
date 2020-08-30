package week_8;
//passing a behavior ,set of methods
//what can the  implemented objects can do
//adding a method -> ripple effect?
public interface Creature {
	String name();
	void greet();
	void makeHappy();
	void makeSad();
	boolean isHappy();
	// wut
	default void wut() {System.err.println("D'oh!");}
	static void wierd() {System.out.println("Static in interface");}
}
