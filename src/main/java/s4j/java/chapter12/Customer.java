package s4j.java.chapter12;

@SuppressWarnings("all")
public class Customer implements Comparable<Customer> {

    private final String name;
    private final String address;
    private final ShoppingBasket basket = new ShoppingBasket();

    public static Customer create(String name, String address, Integer yearsACustomer) {
        Customer customer = null;
        if (yearsACustomer > 2) {
            customer = new DiscountedCustomer(name, address);
        } else {
            customer = new Customer(name, address);
        }
        return customer;
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void add(Item item) {
        basket.add(item);
    }

    public Double total() {
        return basket.value();
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Customer other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " $ " + total();
    }
}
