package s4j.java.chapter11;

import java.util.function.BiFunction;

@SuppressWarnings("all")
public class StoringFunctions {

	static {
		BiFunction<Integer, Integer, Integer> plus = (Integer a, Integer b) -> a + b;

		// abbreviated
		BiFunction<Integer, Integer, Integer> plus2 = (a, b) -> a + b;

		// apply the function like this:
		plus.apply(2, 2);                     	// 4
		plus.apply(plus.apply(2, 2), 2);		// 6

	}
}
