
public class Genreal_Test {
	public static void  main(String args[]) {
		/*
		int[] list1 = {1,2,3,4,5,6,8,9};
		for(int d:list1) System.out.println(d);

		String s ="retards"; // comes from the string immutable property= not modifiable
        String s1 = "Retards"; // for the same reason we have string buffers 
        String s2 = new String("retards");
        System.err.println(s == s1); //looks to object addresses to compare
        System.out.println(s1.toLowerCase().equals(s)); //semantical comparison
        System.out.println(s.equals(s2));
        
		StringBuffer s = new StringBuffer("dafsdf");//all three are different created by "new"
		StringBuffer s1 = new StringBuffer("dafsdf");
		StringBuffer s2 = new StringBuffer("Dafsdf");
		System.out.println(s == s1);
		System.out.println(s.toString().equals((s2.toString().toLowerCase())));
		System.out.println(s.toString().equals(s1.toString()));
		//seems to be only reasonable way to compare them
		*/
		//static definition of an object array type Empty
		Empty[] d = {new Empty("Charles"), new Empty("Elliot"), new Empty("Winston")}; 
	//	for(Empty i: d) System.out.println(i.name);
		
		hoes(d);
	}
	public static void hoes(Empty ... taken) {
		System.out.println("Well then:");
		for(int i = 0; i < taken.length; i++)
			System.err.println(taken[i].name); //repeated runs generate different outputs???
	}
}
