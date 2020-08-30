package v2;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
public class Main {
	public static void main(String[] args) {
		//fifo implementation
		Queue<Integer> qList = new LinkedList<>();
		//organized priority
		Queue<Integer> queue = new PriorityQueue<>();
		Set<Integer> tree = new TreeSet<>(new Comparator<Integer>() {
			public int compare(Integer arg0, Integer arg1) {
				return arg0-arg1;
			}
		});
		Set<Integer> hash = new HashSet<>();	
		tree.add(11);
		tree.add(30);		
		tree.add(21);	
		tree.add(43);
		for(int t: tree) System.out.println(" "+t);
		System.out.println("After");
		tree.add(91);
		tree.add(72);
		tree.add(65);
		//natural order
		/*
		for(int t: tree) {
			System.out.println(" "+t);
			if(t%2 == 0)
				tree.remove(t);//gives exception do it with iterator methods
		}
		*/
		//proper way to do it
		Iterator<Integer> iterate = tree.iterator();
		while(iterate.hasNext()) {
			int i = iterate.next();
			System.out.println(" "+i);
			if(i%2 == 0)iterate.remove(); // iterator function provided by remove - optional-so dont do removes			
		}		
		
		queue.add(23);
		queue.add(10);
		queue.add(44);

		qList.add(23);
		qList.add(10);
		qList.add(44);
		System.out.println("Poll: "+queue.poll());
		System.out.println("Poll: "+queue.poll());
		System.out.print("List:");
		for(int i: qList) System.out.print(" "+i);
		System.out.println();
		System.out.print("Queue:");
		for(int i: queue) System.out.print(" "+i);
		System.out.println();
		System.out.println("Peek: "+qList.peek());
		System.out.println("Peek: "+queue.peek());
		//queue.element(); // gives exception at emmpty list
	
	}

}
