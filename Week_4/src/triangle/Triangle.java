package triangle;
//import static package.Utility.*; => imports all static members 
public class Triangle {
	private int[][] triangle;
	final static int SIZE = 69;
	private static Triangle[] cache;
	//private static String name = "adsf"; // constant only for the class
	public static int triCount = 0;
	static{
		cache = new Triangle[SIZE];
	}
	static public  Triangle getTriangle(int size) { // this trick is used for String types since they are immutable
		for(Triangle t: cache) 	if(t != null && t.triangle.length == size) return t;
		Triangle t = new Triangle(size);
		for(int i = 0; i < cache.length; ++i) if(cache[i] == null) {cache[i] = t; break;}
		return t;
	}
	private Triangle(int size) {	
		if(size < 0) {System.err.println("NOPE!");	System.exit(1);}
		triangle = new int[size][];
		triCount++;
		//rewrite this shit+slides - getting private ref lets you modify privates
		for(int t =0; t<size; ++t) triangle[t] = new int[t+1];
		for(int i= 0; i<triangle.length;++i) {
			triangle[i][0] = 1;
			for(int j = 1; j < triangle[i].length-1; ++j) 	triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
			triangle[i][triangle[i].length-1] = 1;
		}
		/*
		currentTimeMillis()
		exit(int code)
		PrintStream out;
		*/
	}
	public int[][] getTriangle() {return triangle;}
	public void setTriangle(int[][] triangle) {	this.triangle = triangle;}
}


