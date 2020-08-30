package singleton;

public class Main {

	public static void main(String[] args) {
		// why printing order is different in err and out
		Directory d = Directory.getInstance();
		Directory d1 = Directory.getInstance();
		System.out.println(d);
		System.out.println(d1);
		//Directory d2 = new Directory();
	}

}
