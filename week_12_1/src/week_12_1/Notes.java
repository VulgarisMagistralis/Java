package week_12_1;

public class Notes {
	/*MONDAY
	 * students->list
	 *	student.stream.flatMap(new Funtion<Student,Stream<Course>>(){
	 *	public Course apply(Student s){
	 *		return s.getEnrolled().stream();
	 *
	 *	}).distinct().sorted(new Comparator<Course>(){
	 *		public int compare(Course c1,Course c2){
	 *			return c1.getName().compareTo(c2.getName());
	 *
	 *	
	 *	}).froEach(System.out::println);
	 *pull all courses from all students 
	 *turn them into a seperate stream of courses == flat mapped!!!!!
	 *then operate on it
	 *  //v2
	 *  student.stream().
	 *  
	 *  //v3
	 *  	student.stream
	 *  .map(Student::getEnrolledCourses))//into stream of set - for each student
	 *  .flatMap(Collection::stream)
	 *  .distinct() //remove duplicates uses equal -> override to solve address issues!
	 *  .sorted((c1,c2)->c1.getName().compareTo(c2.getName()))
	 *	.forEach(System.out::println);
	 * 
	 *  //what i need to be able to do
	 * students
	 * 		.stream
	 * 		.map(Student::getEnrolledCourses)
	 * 		.flatMap(Collection::stream)//.flatMap(Set::stream)
	 * 		.distinct()
	 * 		.sorted(Comparator.comparing(Course::getName)/*.reversed())  
	 * 		.forEach(print);
	 * 
	 * 
	 * 
	 * interface Collector<element : accumulator : result>{
	 * Supplier<accumulator> supplier() -creates container
	 * BiConsumer<accumulator : element> accumulator() ;- adds a new element into container
	 * BinaryOperator<accumulator> combiner(); - combines two containers - in case of parallized solution
	 * Function<accumulator : result> finisher() ; final transformation step
	 * }
	 * 
	 *LinkedList<Course> list = students
	 * 		.stream
	 * 		.map(Student::getEnrolledCourses)
	 * 		.flatMap(Collection::stream)
	 * 		.distinct()
	 * 		.sorted(Comparator.comparing(Course::getName))  
	 * 		.collect(Collector.of(
	 * 			LinkedList<Course>::new, 
	 * 			LinkedList::add,
	 * 			(a1,a2)->{a1.addAll(a2);return a1;}
	 * 		));
	 * 
	 * 
	 *  4
 Map<Integer, List<Student>> result = studentsList
            .stream()
            .flatMap(x -> x.getCourses().stream().map(y -> new SimpleEntry<>(x, y.getId())))
            .collect(Collectors.groupingBy(
                    Entry::getValue,
                    Collectors.mapping(Entry::getKey, Collectors.toList())));


	 * 
	 */
}
