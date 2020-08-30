package week_7;

import java.util.Iterator;

public class GenericClass implements Comparable<GenericClass>, Iterable<GenericClass>{
	private int number;
	public GenericClass(int i) {number = i;}
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	@Override
	public String toString() {return "GenericClass [" + number + "]";}
	@Override
	public int compareTo(GenericClass arg0) {
		//return number - ((GenericClass)arg0).getNumber(); // downcast when it is used generic compareTo
		return number - arg0.getNumber(); // ascending order
	}
	public class CountIterator implements Iterator<GenericClass>{
		private int current = number;
		@Override
		public boolean hasNext() {
			return current >= 0;
		}

		@Override//very stupid example 
		public GenericClass next() {		
			GenericClass i;
			if(current >= 0) {
				i = new GenericClass(current);
				i.setNumber(current--);
				return i;
			}else {
				System.out.println("Ended!");
				return  new GenericClass(1);
			}
		}

		
	}
	
	@Override
	public Iterator<GenericClass> iterator() {// enables nested loops
		return new CountIterator();//siiiiick!!!
	}
	
}
