package week_10_1;
public class Notes {
/*
 * FRIDAY 11/5/2018
 * passing function references!!!!
 * 
 * STringValue f = String::charAt * 
 * just write your own functional interface, 
 * we need this to understand streams
 * 
 * equivalents!!!!
 * test.clean(s->f.method(s));
 * test.clean(f::method);
 * 
 * 
 * supplier implements get()
 * returns <T>obj;
 * equivalents!!!!
 * Supplier<Washer> sw0 = new Supplier<Washer>(){public Washer get(){return new Pimp();}};
 * Supplier<WAsher> sw = ()->new Pimp();
 * Supplier<Washer> sw1 = Pimp::new;
 * 
 * 
 * -------JAVA STREAMMS
 * 
 * sequence of elements from a source that can be processed with certain operations
 * pipelining
 * 		.sorted() // stream sorted
 * 		.limit(5) // get top five
 * 		.forEach(System.out::println);//always last 
 * 
 * 
 * Collection.stream
 * 
 * intermediate ops
 * 
 * filter 
 * limit
 * skip
 * sorted
 * distinct
 * map
 * 
 * 
 * 
 * 
 */
}
