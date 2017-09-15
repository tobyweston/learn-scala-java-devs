package s4j.java.chapter09;

public class Customer {

	private final String name;
	private final String address;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	static {
		Customer eric = new Customer("Eric", "29 Acacia Road");
	}
}
