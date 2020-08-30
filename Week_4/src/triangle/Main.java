package triangle;

public class Main {
	//design patterns !s
	//enum ype
	//final cannot be change after construction of obj
	//when multiple objs created stataci attributes stay the same for all instances
	//slides of mmory
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t = new Triangle(10);
		Triangle t1 = new Triangle(10); // instead this return previous object ~> pooling
		//when they have same size otherwise creates new with the given size
		/*
		int [][] val = t.getTriangle();
		for(int x = 0; x < val.length;++x) {
			for(int u = 0; u < val[x].length; ++u) {
				System.out.print(val[x][u]+ " ");
			}
			System.out.println(" ");
		}
		 */
		for(int[] row: t.getTriangle()) {
			for(int v: row)	System.out.print(v +" ");
			System.out.println(" ");
		}
		//cant call sum();
		int v1 = sum (1,2,3,4,4,5,6);
		int v2 = sum(1,3,4,1,2,31,4,4);
		System.out.println("1- "+v1+" 2- "+ v2);
		System.out.println(Triangle.triCount); //! accessing static way
	}
	static int sum (int ... val) {
		int s = 0;
		for(int v :val) s  = s + v;
		return s;		
	}
}

