import java.util.Iterator;
//siiiiick bounding
public class Classroom<T extends Student> implements Iterable<T>{
	private int pos = 0;
	private final static int NUM_MAX = 512;
	private T[] students =(T[]) new Object[NUM_MAX];//lol
	public void add(T s) {students[pos++] = s;}
	private class inner implements Iterator<T>{
		int pos2 = 0;
		@Override
		public boolean hasNext() {return pos2 < pos;}
		@Override
		public T next() {	++pos2;	return students[pos2-1];}
	}
	@Override//becausseeee iterating on students not classrooms
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		//return new inner();
		///muche better anonymous
		return new Iterator<T>() {
			int pos2 = 0;
			@Override
			public boolean hasNext() {return pos2 < pos;}
			@Override
			public T next() {	++pos2;	return students[pos2-1];}
		};
	}
}
