package week_10_1;

public interface Hoe {
	final int washCount = 10;
	boolean wash(String s);
	default boolean washHard(String s) {
		for(int n = 0;n<washCount;n++)wash(s);
		return wash(s);
	}
}
