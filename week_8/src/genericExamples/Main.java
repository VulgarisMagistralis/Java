package genericExamples;

public class Main {
	public static void main() {
		Pair<String> ps = new Pair<String>("first","second");
		Pair<Integer> pi = new Pair<Integer>(1,2); // thats why we need generics
		System.out.println(ps.first()+" "+pi.second());
		int var1 = pi.first() + pi.second();
		System.out.println(var1);
		String var2 = ps.first()+ps.second();
		System.out.println(var2);
		//int var3 = ps.first(); => so we can get this notice
	}
}
