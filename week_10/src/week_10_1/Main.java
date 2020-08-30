package week_10_1;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
public final class Main {	
	//exceptions must be handled not to be thrown 
	public static void main(String[] args) throws MyException, IOException {
		try {System.out.println(avg(12,32));}
		finally {System.out.println("mandatoy ops here");}
		
		
		Queue<String> vector = new LinkedList<>();
		String s = vector.poll(); // returns null
		//System.out.println(s);
		try { //without try catch exception gives error  prog stops - BAD!
			String s2 = vector.remove();
			System.out.println(s2);
		}catch(NoSuchElementException w) {
			System.err.println("Retard");
		}
		try {
			MyException ex = null;
			ex.stuff = 0;
		}catch(NullPointerException n) {
			System.err.println("oops");
			throw n;
		}
		//System.out.println(avg());
		//most specific catch first, compiler warns soooo
		try { // if you catch you dont need throws
			System.out.println(avg());
			System.out.println(avg(12,4,33));
		}catch(Exception e) {
			System.err.println("bigger fish");
		}
	}
	private static void meth(){
		
	}
	
//	@SuppressWarnings("unchecked")
	static private <T extends Number> double avg(T...args) {
		if(args.length == 0) throw new Error(); // no need to throws because errors are unchecked
		double avg = 0;
		for(T d : args) avg = avg + d.doubleValue();
		return (avg / args.length);
	}
}