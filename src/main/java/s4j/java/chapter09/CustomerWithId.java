package s4j.java.chapter09;

public class CustomerWithId {

	private final String name;
	private final String address;

	private String id;

	public CustomerWithId(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void setId(String id) {
		this.id = id;
	}

	static {
		CustomerWithId eric = new CustomerWithId("Eric", "29 Acacia Road");
	}
}
