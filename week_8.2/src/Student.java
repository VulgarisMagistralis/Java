
public class Student implements Comparable<Student>{
	private String name;
	private String sname;
	private double avg;
	public Student(String n,String s,double d){
		name=n;
		sname=s;
		avg=d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	@Override
	public int compareTo(Student s) {
		return(this.sname+this.name).compareTo(s.sname+s.name);
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sname=" + sname + "]";
	}
	
}
