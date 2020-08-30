package week_7;

public class Notes2 {

	/*abstract classes -> cannot be used directly
	 * design patterns ->using code without heavy modification-> e.g. singleton
	 * both in method and class name
	 * use case -> for sorter class -> sort for multiple objects
	 * abstract int compare(object a , object b); -> each will implement this independently
	 * core algorithm invokes abstract primitive operations
	 * children will define abstract methods to use whole algorithm
	 * interfaces----
	 * fully abstract class
	 * all attributes are public static final 
	 * "what a class should be"
	 * multiple inheritance -> problematic < C#
	 * comparable and orderable !!
	 * common interface => alternative implementations
	 * defines a set of common methods
	 * communication decoupling 
	 * behavioral parameterization -> encapsulates behavior in a passed object
	 * passing a function to function=> passing class containing the function
	 * public interface Complex{
	 * 	double real();
	 * 	double modulus();
	 *  double argument();
	 * }
	 * 
	 * callback methods
	 * 
	 * defining a proper set of semantics , methods
	 * sort();
	 * Arrays.sort(array);
	 * comparable interface has compareTo(Object o); to be implemented
	 *	 return this - other;
	 *  Student other = (Student)o;-> can be downcast
	 *  iterable -> iterator(); lets you go through a collection of objects
	 *  --boolean hasNext();
	 *  --object next();
	 *  Random exampple in slides-
	 *  moving inside the class that has elements
	 *  binary tree visit -> iterator
	 *  
	 *  behavioural parameterization 
	 *  slide example seems fine -> mental
	 * 	anonymous inner class -> interfaces
	 *  closure ->inner class using outer classes variables
	 *  anonymous inner class comparator to implement compare(x,y);
	 *   overloading Arrays.sort(sv,new Comparator());
	 *   or Arrays.sort(sv, new Comparator(){
	 *   	implement compare(){
	 *   	}
	 *   });
	 *  General rules are defined but implementations are up to you
	 *   
	 *   Theory - software engineering
	 *   
	 */
}
