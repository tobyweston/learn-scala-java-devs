package s4j.java.chapter12;

import java.util.ArrayList;
import java.util.List;

public class CustomersSortableBySpend extends Customers {

	@Override
	public List<Customer> sort() {
		List<Customer> customers = new ArrayList<>();
		for (Customer customer: this)
			customers.add(customer);
		customers.sort((first, second) -> second.total().compareTo(first.total()));
		return customers;
	}
}
