package s4j.java.chapter10.example2;

public class Customer {

	private static Integer lastId;

	private final String name;
	private final String address;

	private Integer id;

	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
		this.id = Customer.nextId();
	}

	private static Integer nextId() {
		return lastId++;
	}

}
