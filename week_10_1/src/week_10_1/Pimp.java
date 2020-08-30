package week_10_1;

public class Pimp implements Washer, Hoe{

	@Override
	public boolean wash() {
		System.out.println("Pimp is clean");
		return true;
	}

	@Override
	public boolean wash(String s) {
		
		return false;
	}

}
