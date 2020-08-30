package week_13_1;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
	public static void main(String[] args) {
		Stream<String> s= Stream.of("Asdveqqqqqq","asdvvf","dbecvxvs","qeort","vxbgg");
		Map<Integer,List<String>> byLength = s.distinct().sorted().collect(Collectors.groupingBy(String::length));
		byLength.entrySet().stream().forEach(System.out::println);
		Map<Integer,List<String>> sorted = new TreeMap<>((b,a)->a.compareTo(b));//Map<>(reverseORder());
		sorted.putAll(byLength);
		sorted.entrySet().stream().forEach(System.out::println);
		Stream<String> s1 = Stream.of("Asdveqqqqqq","asdvvf","dbecvxvs","qeort","vxbgg");
		s1
		.distinct()
		.collect(Collectors
				.groupingBy(String::length))
		.entrySet()
		.stream()
		.sorted(Comparator
				.comparing(Map.Entry::getKey))
		.flatMap(x->x.getValue().stream()) 
		.forEach(System.out::println);
	}

}
