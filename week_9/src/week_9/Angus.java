package week_9;

public class Angus  implements Cow{

	@Override
	public void speak() {
		System.out.println("type: "+this.getClass());
		
	}
	@Override
	public int getMilk() {return 60;}
	
}
