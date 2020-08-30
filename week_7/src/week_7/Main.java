package week_7;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
	public static void main(String[] args) {
		GenericClass[] gs = { new GenericClass(18),
				new GenericClass(33),
				new GenericClass(14),
				new GenericClass(38),
				new GenericClass(99)};
		//order 1#
		Arrays.sort(gs);
		for(GenericClass l: gs)	System.out.println(l);
		System.out.println();
		//order 2#
		Arrays.sort(gs, new Comp());
		for(GenericClass l:gs)System.out.println(l);
		System.out.println();
		//order 3# // always useful when inner class has a few lines
		Arrays.sort(gs, new Comparator<GenericClass>() {
			public int compare(GenericClass a, GenericClass b) {
				return a.getNumber() - b.getNumber();
			}
		});
		for(GenericClass l: gs) System.out.println(l);
		//GenericClass g = new GenericClass(99);
		//for(GenericClass l: g) System.out.println(l);
	}
	private static class Comp implements Comparator{//since static ,exists regardless of outer class
	@Override
		public int compare(Object a, Object b) {
			// TODO Auto-generated method stub
			return -((GenericClass)a).getNumber()+((GenericClass)b).getNumber();
		}
	}
	
}
