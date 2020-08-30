package week_9;
import java.util.ArrayList;
import java.util.List;
public class Main {
//	private static final int MAX = 4;
	int milk = 0;
	public static void main(String[] args) {
/*		Cow[] herd = new Cow[MAX];
		herd[0] = new Angus();
		herd[1]=new Cani();
		herd[2] = new Fassone();
		herd[3] = new Angus();
		for(Cow c: herd)c.speak();
*/
		//pointers are saved sequentially but data scattered around
		Main m = new Main();
		m.execution();
	}
	void execution() {
		Farm<Angus> angusHerd = new Farm<>();
		angusHerd.addCows(new Angus());
		//angusHerd.addCows(new Cani()); just to get hte error
		for(int i=0;i<7;i++)angusHerd.addCows(new Angus());
		for(Cow c: angusHerd) c.speak();
		milking(angusHerd);
		System.out.println("Tot:"+milk);
	}
	///parametrization of function + giving heads-up to compiler about T
	<T extends Cow> T getFirst(Farm<T> angusHerd) {//useful''''''
		if(!angusHerd.iterator().hasNext()) return null;
		return angusHerd.iterator().next();
	}
	<T extends Cow> void milking(Farm<T> herd) {
		for(T a : herd)milk = milk + a.getMilk();
	}
	//parameterization not a definition
	//cant use <T extends Cow> obviously
/*	void milking(Farm<? extends Cow> herd) {
		for(Cow a : herd)milk = milk + a.getMilk();
		
		<T> void foo(Zap<T> bar){
		
		}
		
		<T> T void foo(Zap<T> bar){
			return null;
		}
		
		void bar(Zap<?> baz){
		
		}
		
	}*/
	//only permitterd way , telling complier beforehand 
}
