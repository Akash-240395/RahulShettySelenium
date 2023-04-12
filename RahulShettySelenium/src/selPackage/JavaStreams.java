package selPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Get the count of names starting with A

		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Abhilash");
		names.add("Yoga");
		names.add("Sarayu");
		names.add("Akshay");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actualName = names.get(i);
			if (actualName.startsWith("A")) {
				count++;
			}
		}
		System.out.println("Count of names starting with A:::: " + count);

		// using java Streams
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Akash");
		names2.add("Abhilash");
		names2.add("Yoga");
		names2.add("Sarayu");
		names2.add("Akshay");

		long c = names2.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		
		//Need not create collections/ ArrayList to store, use Stream instead
		long d = Stream.of("Akash", "Abhilash", "Yoga", "Sarayu", "Akshay").filter(s->
		{
			
		s.startsWith("S");
		return true;
		
		}).count();
		System.out.println(d);
		
		//Print names from the list having length of characters greater than 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//Print all names from the list
		names.stream().forEach(s->System.out.println(s));
		
		//Print names from the list having length of characters greater than 4 and limit to 1 only
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		System.out.println();
		
		//Print names with last letter ending with h and in uppercase
		names.stream().filter(s->s.endsWith("h")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Print names with last letter ending with h and in uppercase and sorted
		names.stream().filter(s->s.endsWith("h")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println();
		
		//merging 2 streams
		ArrayList<String> names3 = new ArrayList<String>();
		names3.add("Ramesh");
		names3.add("Suresh");
		names3.add("Chiku");		
		
		Stream<String> newStream =Stream.concat(names.stream(), names3.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//Checking if name is present in Stream or not and validating with Assert
		//boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Chiku"));
		//System.out.println(flag);
		//Assert.assertTrue(flag);
		
		System.out.println();
		
		//Storing new Stream starting with "a" in List instead of printing
		List<String> modStream = newStream.filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(modStream.get(1));
		
		System.out.println();
		
		//int[] values = {1, 2, 2, 5, 10, 9, 8, 8};
		List<Integer> values = Arrays.asList(1, 2, 2, 5, 10, 9, 8, 8);
		//Print unique numbers only from this array and sort
		List<Integer> modList =values.stream().distinct().sorted().collect(Collectors.toList());
		// 1, 2, 5, 8, 9, 10
		System.out.println(modList.get(2));
		
		
		
		
		
		
		

	}

}















