package genericExamples;

public class Pair<T> {
 /// class Pair<T,P>
	private T a,b;
	Pair(T a, T b){
		this.a = a;
		this.b = b;
	}
	public T first() {
		return a;
	}
	public  T second() {
		return b;
	}
}
