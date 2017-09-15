package s4j.java.chapter12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("all")
public class Customers implements Sortable<Customer> {

	private final Set<Customer> customers = new HashSet<>();

	public void add(Customer customer) {
		customers.add(customer);
	}

	@Override
	public Iterator<Customer> iterator() {
		return customers.iterator();
	}
}
