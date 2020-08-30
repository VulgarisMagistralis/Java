package week_10_1;

import java.util.function.BiConsumer;

public class Main {
	void clean(Washer w) {
		if(w.wash()) System.out.println("WASHED!");
	}
	static boolean date(String s) {
		System.out.println(s);
		return false;
	}
	public static void main(String[] args) {
		Main test = new Main();
		test.clean(new Pimp());		
		/*
		test.clean(new Washer(){
			public boolean wash() {
				System.out.println("NOT CLEAN! SHAME!");
				return false;
			}
		});
		*///SAME AS THIS~~~~~ only useful for short stuff
		/* good when there is only one function in interface!!!
		test.clean(() -> {
			System.out.println("PFFFF");
			return true;
			}
		);
		*/
		Gangster hitman = new Gangster();
		Hoe cleanup = hitman::kill;
		//test.clean1(hitman::kill);
		/*
		 * good for using static methods perhaps
		 * if class had a static method
		 * test.clean(Foo::staticMethod)
		 * 
		 * */
		//sameeeeeeeeeeeee
		/*
		Hoe h0 = new Hoe() {
			public boolean wash(String s) {
				return Main.date(s);
			}
		};
		Hoe h = s -> Main.date(s);
		Hoe h1 = Main::date;
		 */
		///if we need data in object
		
		Maddog cnt = new Maddog("DOOM");
		Hoe w = cnt::bark;
		test.clean1(w);
		
		BiConsumer<Maddog, String> wut = Maddog::bark;
	}
	void walking(Washer w,String s) {
		
	}
	void clean1(Hoe h) {
		System.out.println("DEAD: "+ h);
	}

}
