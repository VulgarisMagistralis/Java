package university;

public class Student {
	private int ID;
	private int courseCount;
	private String studentName;
	private String studentSurn;
	private final int MAX_COUR = 25;
	private Course courses[] = new Course[1];
	public void addCourse(Course course) {
		if(courseCount >= MAX_COUR){System.err.println("YOU HAVE REACHED YOUR LIMIT!");return;}
		if(courses.length >= courseCount / 2) incCoursesSize();
		courses[courseCount++] = course;
	}
	private void incCoursesSize() {
		Course[] temp = new  Course[(courseCount + 1) * 2];
		for(int i = 0; i < courses.length; i++)	temp[i] = courses[i];
		courses = temp;
	}
	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	public int getMAX_COUR() {return MAX_COUR;}
	public Course[] getCourses() {return courses;}
	public void incCourseCounter() {courseCount++;}
	public int getCourseCount() {return courseCount;}	
	public String getStudentName() {return studentName;}
	public String getStudentSurn() {return studentSurn;}
	public void setStudentName(String studentName) {this.studentName = studentName;}
	public void setStudentSurn(String studentSurn) {this.studentSurn = studentSurn;}
	public Student(String name, String surn){studentName = name;studentSurn = surn;courseCount =0;}
}