package s4j.java.chatper08;

import java.util.stream.IntStream;

public class Declarative {

	static {
		// typical imperative loop
		for (int count = 0; count < 100; count++) {
			System.out.println(count);
		}

		// declarative scala
		// (0 to 100).foreach(println(_))

		// declarative java
		IntStream.range(0, 100).forEach(System.out::println)
	}
}
