package week_8;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	void sayHello(Creature[] creatures) {
		for(Creature x : creatures) {
			System.out.print(x.name()+ " " );
			x.greet();
			System.out.println("LEVEL: "+x.isHappy());
			System.out.println();
		}
	}
	//sort implementation like, execution on a condition
	void sayHi(Creature[] creatures, Condo condo) {
		for(Creature x : creatures) {
			if(condo.condtion(x)) {
				System.out.print(x.name()+ " " );
				x.greet();
				System.out.println("LEVEL: "+x.isHappy());
				System.out.println();
			}
		}
	}	
	void exeAll(Creature[] cs, Action cheer) { // generic action on all, standard name, applies to all
		for(Creature c: cs) {
			cheer.operation(c);
			System.out.println("nothing happens here");
		}
	}
	public static void main(String[] args) {
		//commmon pattern
		Main ex = new Main();
		Creature[] hs = {
				new Human("NOT"),
				new Human("MY"),
				new Human("IDEA"),
				new Dog("FINALLY")
		};
		//this is the way to pass a function not-properly, solution more interface!!!!
		ex.sayHello(hs);
		//Cheerup action = new Cheerup(); -> no needed we can do it with anonymous class
		//very useful,practical , a class has no name
		ex.exeAll(hs, new Action() {public void operation(Creature c){c.makeSad();}});
		ex.exeAll(hs, new Action() {public void operation(Creature c){c.makeHappy();}});
		//ex.sayHello(hs);
		System.out.println("Happy ones");
		ex.sayHi(hs, new Condo() {
			@Override
			public boolean condtion(Creature c) {
				return c.isHappy();
			}
			
		});
		//or we can use handmade interface which is worse, instead of this
		Arrays.sort(hs,new Comparator<Creature>() {	public int compare(Creature o1, Creature o2) {return o1.name().compareTo(o2.name());}});
	ex.sayHello(hs);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
