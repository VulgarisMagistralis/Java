package week_9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Farm<T extends Cow> implements Iterable<T> {
	 List<T> cows = new ArrayList<T>();	//=LinkedList<T>();	
	 public void addCows(T cow) {cows.add(cow);}
	 public Iterator<T> iterator() {return cows.iterator();}
	 
}
