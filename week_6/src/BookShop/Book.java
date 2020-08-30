package BookShop;

public class Book {
	//holds info => java beans?
	protected String title;
	protected String author;
	protected double price;
	//add exceptions 
	//wrapper classes => to be able to use java framework,collections, autobox saves the day

	@Override //good to check errors in the name of method
	public String toString() {
		return title+" - "+author+" "+price;
	}
	public Book() {	}
	public Book(String author,String title,double price) {
		this.author = author;
		this.price = price;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
