package s4j.java.chapter10.example4;

public class Customer {

	// analog to scala/chapter10/example4/Customer.scala

	private static Integer lastId;

	private final String name;
	private final String address;

	private Integer id;

	public static Customer createCustomer(String name, String address) {
		return new Customer(name, address);
	}

	private Customer(String name, String address) {
		this.name = name;
		this.address = address;
		this.id = Customer.nextId();
	}

	private static Integer nextId() {
		return lastId++;
	}

}