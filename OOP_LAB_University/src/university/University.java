package university;

public class University {
	private Teacher rector;
	private String uniName;
	private int counterCourse = 0;
	private final int NO_COR = 10;
	private int counterStudent = 0;
	private final int MAX_COUR = 50;
	private final int MAX_STU = 1000;
	private final int NO_STU = 10000;
	private Course[] course_list = new Course[1];
	private Student[] student_list = new Student[1];
	public University(String name){uniName = name;}
	public String getName(){return uniName;}
	public void setRector(String first, String last){
		rector = new Teacher();
		rector.setTeacherName(first);
		rector.setTeacherSurn(last);
	}
	public String getRector(){rector.setIfRector(true);return rector.getTeacherName()+" "+rector.getTeacherSurn();}	
	public int enroll(String first, String last){
		if(counterStudent >= MAX_STU) {System.err.println("Maximum number of students reached! GTFO!"); return 0;}
		if(student_list.length >= counterStudent / 2) increaseStudentSize();
		Student freshman = new Student(first, last);
		freshman.setID(counterStudent + NO_STU);
		student_list[counterStudent++] = freshman;
		return freshman.getID();
	}
	void increaseStudentSize(){ 
		Student[] temp_list = new Student[(counterStudent + 1) * 3];
		for(int i = 0; i < student_list.length; i++) temp_list[i] = student_list[i];
		student_list = temp_list;
	}
	public String student(int id){
		for(Student tempStudent : student_list) if(id == tempStudent.getID()) 
			return "[" + tempStudent.getID()+"] "+ tempStudent.getStudentName()+" "+tempStudent.getStudentSurn();
		System.err.println("STUDENT NOT FOUND!");
		return null;
	}	
	public int activate(String title, String teacher){
		if(counterCourse >= MAX_COUR) {	System.err.println("LIMIT REACHED!");return 0;}
		if(course_list.length >= counterCourse / 2) increaseCourseSize();
		Course newCourse = new Course(title, teacher);
		newCourse.setCourCode(NO_COR + counterCourse);
		course_list[counterCourse++] = newCourse;
		return newCourse.getCourCode();
	}
	private void increaseCourseSize() {
		Course[] temp_list = new Course[(counterCourse + 1) * 3];
		for(int i = 0; i < course_list.length; i++)	temp_list[i] = course_list[i];
		course_list = temp_list;
	}
	public String course(int code){
		for(Course c: course_list) if(c != null && c.getCourCode() == code) return "["+c.getCourCode()+"] "+c.getTitle()+" course by "+c.getTeacher();
		System.err.println("COURSE NOT FOUND!");
		return null;
	}
	public void register(int studentID, int courseCode){
		boolean found1 = false, found2 = false; int student ,course;
		for(student = 0; student < student_list.length && !found1; student++) if(student_list[student].getID() == studentID) found1 = true;
		for(course = 0; course < course_list.length && !found2; course++) if(course_list[course].getCourCode() == courseCode) found2 = true;
		student--; course--;
		if(found1 && found2) {
			if((student_list[student].getCourseCount() >= 25) && (course_list[course].getAttendeeCount() >= 100)) {System.err.println("REGISTRATION CANNOT BE DONE! SORRY!"); return;}
			course_list[course].addAttendee(student_list[student]);
			student_list[student].addCourse(course_list[course]);
		}else System.err.println("OPERATION CANNOT BE DONE!");
	}
	public String listAttendees(int courseCode){
		String list = ""; int i; boolean found = false;
		for(i = 0; i < course_list.length && !found; i++) if(course_list[i].getCourCode() == courseCode) found = true;
		for(Student s: course_list[i].getAttendee_list()) if(s!= null) list = list + student(s.getID()) + "\n";
		return list;
	} 
	public String studyPlan(int studentID){
		String plan = ""; int i; boolean found = false;
		for(i = 0; i < student_list.length && !found; i++) if(student_list[i] != null) if(student_list[i].getID() == studentID) found = true;
		for(Course c: student_list[i].getCourses()) if(c != null) plan = plan + course(c.getCourCode()) + "\n";
		return plan;
	}
}


