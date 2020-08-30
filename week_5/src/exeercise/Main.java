package exeercise;

public class Main {

	public static void main(String[] args) {
		Base a = new Base();
		Base b = new SubClass();
		Base c = new SubSubClass();
		b.m1();
		b.m2();
		c.m3();
		c.m1();
		c.m2();
//		c.m4();
		/*
		((SubClass)c).m4(); // explicit up-casting required to run ,not overridden methods 
		m5(new Base());
		m5(new SubClass());
		m5(new SubSubClass());
		*/
	}
	public static void m5(Base b) {
		System.out.println(b);
	}
}
