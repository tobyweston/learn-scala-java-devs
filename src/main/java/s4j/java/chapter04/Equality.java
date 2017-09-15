package s4j.java.chapter04;

public class Equality {

	static {
		boolean a = new String("A") == new String("A");		// true in scala, false in java
		boolean b = new String("B").equals(new String("B"));	// true in scala and java
	}
}
