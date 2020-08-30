package week_10_2;
import java.util.List;
public class Main {
	public static void main(String[] args) throws StudentException {
		//Student error = new Student("X","Y",null);
		Student s = new Student("Marc","Miller","XX11");
		Student s1 = new Student("Marc","Miller","XX11");
		System.out.println(s);
		List<Integer> list = s.getVotes();//copies original , changes are not applied to original
		s.getVotes().add(11);
		University polito = new University();
		//since their addresses are different they are both accepted
		polito.addStudent(s);
		polito.addStudent(s1);
		System.out.println(polito.getStudents());
		Student err = polito.getStudent("XX11"); 
		
	}
}