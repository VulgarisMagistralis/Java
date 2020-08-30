import java.util.Arrays;
import java.util.Comparator;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("name1","sname1",3.4);
		Student s2 = new Student("name0","sname0",3.0);
		Classroom<Student> classroom = new Classroom<>();
		classroom.add(s1);
		classroom.add(s2);
		//iterable just so we can use this;
		for(Student s: classroom)System.out.println(s);
		//also possible
		//Classroom<Integer> joke = new Classroom<>();
		//until bounding
		
		
		//first part
		//dont modify elements of arraying during iteration
		/*
		Arrays.sort(classroom, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {return Double.compare(s1.getAvg(),s2.getAvg());}
		});
		for(Student s: classroom)System.out.println(s);
		System.out.println("Sorted 2!");
		Arrays.sort(classroom);
		for(Student s: classroom)System.out.println(s);
		*/
	}

}
