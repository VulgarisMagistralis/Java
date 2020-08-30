package exeercise;

public class SubClass extends Base{
	public void m1() {
		System.out.print("in sub class:   ");
		super.m1();	
	}
	public void m2() {
		System.out.print("in sub class:   ");
		super.m2();
	//	System.out.println("method2 of sub");
	}
	public void m4() {
		System.out.println("unique m");
	}
}
