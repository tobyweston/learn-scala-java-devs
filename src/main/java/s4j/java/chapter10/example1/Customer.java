package s4j.java.chapter10.example1;

public class Customer {
	private final String fullname;

	public Customer(String forename, String initial, String surname) {
		if (initial != null && !initial.isEmpty())
			this.fullname =
				String.format("%s %s. %s", forename, initial, surname);
		else
			this.fullname = String.format("%s %s", forename, surname);
	}

	public Customer(String forename, String surname) {
		this(forename, "", surname);
	}

	public static void main(String... args) {
		System.out.println(new Customer("Bob", "J", "Smith").fullname);
		System.out.println(new Customer("Bob", "Smith").fullname);
	}
}