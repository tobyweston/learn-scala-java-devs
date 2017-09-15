package s4j.java.chapter10;

import java.util.logging.Level;

import static java.util.logging.Level.INFO;

public enum LoggerEnum {

	LOGGER;

	public void log(Level level, String string) {
		System.out.printf("%s %s%n", level, string);
	}

	public static void main(String... args) {
		LOGGER.log(INFO, "An alternative example using an enum");
	}
}