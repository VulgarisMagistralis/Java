package week_8;

public interface MoreShit {
	//make a same name method as other interfaces
	//and  implement over the same class
	// not everybody has to implmeent it
	default void wut() {
		System.err.println("Wut!");
	}
	static void name() {
		System.out.println("WELP");
	}
}
