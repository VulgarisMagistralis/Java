package week_10_2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Student {
	private String id;
	private String sName;
	private String name;
	private List<Integer> votes;
	public Student(String name, String sName, String id) throws StudentException {
		if(id==null)throw new StudentException();
		this.votes = new LinkedList<>();
		this.sName = sName;
		this.name = name;
		this.id = id;
	}
	@Override
	public int hashCode() {return id.hashCode();}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Student other = (Student) obj;
		if (!id.equals(other.id))return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		return "Student [id=" + id + ", sName=" + sName + ", name=" + name + " Votes "+votes+"]";
	}
	public String getsName() {return sName;}
	public String getName() {return name;}
	public List<Integer> getVotes() {return new ArrayList<>(votes);}//copying to send
	public String getId() {return id;}
}
