package s4j.java.chapter13;

@SuppressWarnings("all")
public class DiscountedCustomer extends Customer {

    public DiscountedCustomer(String name, String address) {
        super(name, address);
    }

    @Override
    public Double total() {
        return super.total() * 0.90;
    }

    public Double getDiscountAmount() {
        return 10.0;
    }

}
