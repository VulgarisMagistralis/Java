package v2;

public class MyInt implements Comparable<MyInt>{
	private int val;
	MyInt(int x){
		val = x;
	}
	@Override
	public int compareTo(MyInt o) {
		return -val + o.getVal();
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return "" + val;
	}
	

}
