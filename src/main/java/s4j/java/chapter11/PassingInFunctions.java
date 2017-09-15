package s4j.java.chapter11;

import java.util.Arrays;
import java.util.List;

public class PassingInFunctions {

	static {
		List<String> list = Arrays.asList("A", "C", "B", "D");
		list.sort((a, b) -> a.compareTo(b));                      // ascending
		list.sort((a, b) -> b.compareTo(a));                      // descending

		// as a method reference
		list.sort(String::compareTo);                      		  // ascending
		// descending can't be converted into a method reference
	}
}
