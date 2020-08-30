package BookShop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Book[] selist = new SpecialEdition[3];
		Book[] booklist = new Book[3];
		/*
		Book book = new Book("Deaver", "Sleeping Dool", 12.3);
		System.out.println(book); /// calls to String method automatically - sick
		booklist[0] = book;
		book = new Book();
		book.setAuthor("Deaver");
		book.setTitle("why");
		book.setPrice(15);
		System.out.println(book);
		booklist[1] = book;
		SpecialEdition se = new SpecialEdition("Deaver", "Sleeping Dool", 12.3);
		Book se = new SpecialEdition("Deaver", "Sleeping Dool", 12.3); //=> polymorphism
		System.out.println(se);
		System.out.println(se.getAuthor());
		System.out.println(se.isSpecailEdtion());
		System.out.println("Price is: "+se.getPrice());	
		booklist[2] = se;		
		System.out.println(String.format("%-20s %-20s %-10s", "Author","Title","Price"));
		for(int i=0;i<3;i++) {//what i needed
			System.out.println(String.format("%-20s %-20s %-10f", booklist[i].getAuthor(),booklist[i].getTitle(),booklist[i].getPrice()));
		}
	   */		
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {
			System.out.println("Title: "); String title = in.nextLine();
			System.out.println("Author: "); String author = in.nextLine();
			System.out.println("Price: "); double price = Double.parseDouble(in.nextLine());
			booklist[i] = new Book(title, author, price);
			selist[i] = new SpecialEdition(title, author, price);
		}
		in.close();
		System.out.println(String.format("%-20s %-20s %-10s", "Author","Title","Price"));
		for(Book b: booklist) if(b != null) System.out.println(String.format("%-20s %-20s %-10s", b.getAuthor(), b.getTitle(), b.getPrice()));
		for(Book b: selist) if(b != null) System.out.println(String.format("%-20s %-20s %-10s", b.getAuthor(), b.getTitle(), b.getPrice()));
	}
	
	

}
