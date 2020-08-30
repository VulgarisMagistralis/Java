package week_10_2;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;
public class Main {
	boolean predicate(String s) {return s.length() == 10;}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> consumer = new Consumer() {public void accept(Object arg0) {System.out.println(arg0);}};
		//static method reference
		//Stream.of("flippin","tosser","bugger off","elementary").sorted().forEach(System.out::println);
		//Stream.of("flippin","tosser","bugger off","elementary").sorted().forEach(consumer);
		//Stream.of("flippin","tosser","bugger off","elementary").sorted().forEach(s->System.out.println(s));
		//Stream.of("flippin","tosser","bugger off","elementary").filter(s->s.length()==7).forEach(System.out::println);
		//if predicate is static
		//Stream.of("flippin","tosser","bugger off","elementary").filter(Main::predicate).forEach(System.out::println);
		//if predicate is not static
		//Main m = new Main();
		//Stream.of("flippin","tosser","bugger off","elementary").filter(m::predicate).forEach(System.out::println);
		/*
		Stream.of("flippin","tosser","bugger off","tosser","elementary")
			.sorted()
			.distinct()
			.limit(3)
			.forEach(consumer);
		*/
		//maps Stream of string into a Stream of integer
		//Stream.of("flippin","tosser","bugger off","elementary").map(e->e.length()).forEach(System.out::println);
		Stream.of("flippin","wanker","twat","tosser","bugger off","elementary")
			.map(String::length)
			.sorted(new Comparator<Integer>() {
				public int compare(Integer arg0, Integer arg1) {
					// TODO Auto-generated method stub
					return -arg0+arg1;
				}
				
			})
			.forEach(System.out::println);
		System.out.println(System.currentTimeMillis());
		//easier
		//Set<Student> students = new TreeSet<>((s1,s2)->s1.getId().compareTo(s2.getId()));
	}

}
