package week_12_1;
import java.util.HashMap;
import java.util.Map;
//cant make a proper example ,dont use singleton
public class Courses {
	static private Map<String, Course> courseList = new HashMap<>();
	private Courses() {
		//to prevent people from creating it
	}
	public Course createCourse(String id, String name) {
		if(!courseList.containsKey(id))	courseList.put(id, new Course(id,name));
		return courseList.get(id);
	}
}
