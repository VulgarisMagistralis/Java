package week_9;

public class Cani implements Cow{

	@Override
	public void speak() {
		System.out.println("thype: "+this.getClass());		
	}

	@Override
	public int getMilk() {
		// TODO Auto-generated method stub
		return 50;
	}

}
