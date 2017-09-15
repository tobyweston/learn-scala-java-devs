package s4j.java.chapter11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class AnonymousClasses {

	static {

		// general form of a lambda
		//
		// (String a, String b) -> {
		//    int comparison = a.compareTo(b);
		// 	  return comparison;
		// };

		List<String> list = Arrays.asList("A", "C", "B", "D");
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});

		// first class function
		// (String a, String b) -> a.compareTo(b);

	}
}
