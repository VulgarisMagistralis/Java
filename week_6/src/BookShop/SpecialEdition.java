package BookShop;

public class SpecialEdition extends Book{
	public SpecialEdition(String title, String author, double price) {	
		super(title,author,price*1.3);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	public boolean isSpecailEdtion() {
		return true;
	}
	
/*	
	
	public double getPrice() {
		return price * 1.3;
	}
	*/
	
	
	
}
