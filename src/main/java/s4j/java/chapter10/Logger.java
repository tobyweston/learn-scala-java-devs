package s4j.java.chapter10;

import java.util.logging.Level;

import static java.util.logging.Level.INFO;

public final class Logger {

	private static final Logger INSTANCE = new Logger();

	private Logger() { }

	public static Logger getLogger() {
		return INSTANCE;
	}

	public void log(Level level, String string) {
		System.out.printf("%s %s%n", level, string);
	}

	public static void main(String... args) {
		Logger.getLogger().log(INFO, "Everything is fine.");
	}
}
