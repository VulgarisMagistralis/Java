package week_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* revision
		 * int i;
		// it can use the methods of Integer() -almost
		Integer j = new Integer(5); 
		// wrapper version ,class reference = pointer
		// j = 5 ;could be this = auto-boxing,still auto cast is bad
		i = j*2;
		// they can be used together , interchangbly = auto-boxing
		//performs worse -> wrappers
		System.out.println(i);
		//reading a text - search
		*/
		//take it as args, write a function to read texts
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();  //closes after the first integer taken
		in.close();
		//WordCounter counter = new WordCounter(size); // for user given sizes 
		WordCounter counter = new WordCounter(Integer.parseInt(args[0]));
		counter.addWord("qw");
		counter.addWord("qw");
		counter.addWord("ertge");
		counter.addWord("rthrtg");
		counter.print();
	}

}
