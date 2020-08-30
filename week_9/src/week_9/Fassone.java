package week_9;

public class Fassone  implements Cow{

	@Override
	public void speak() {
		System.out.println("type: "+this.getClass());
		
	}

	@Override
	public int getMilk() {
		// TODO Auto-generated method stub
		return 40;
	}

}
