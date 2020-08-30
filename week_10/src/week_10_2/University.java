package week_10_2;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class University {
	Set<Student> pupils;
	Map<String, Student> forID = new HashMap<>();
	public University() {pupils = new HashSet<>();}
	public void addStudent(Student s) {
		pupils.add(s); //putting the reference into sturcture-bad
		forID.put(s.getId(), s);
	}
	public Collection<Student> getStudents() {return new ArrayList<>(pupils);}
	public Student getStudent(String id) {return forID.get(id);}
}
