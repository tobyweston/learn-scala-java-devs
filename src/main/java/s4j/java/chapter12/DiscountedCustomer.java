package s4j.java.chapter12;

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

class TestDiscount {
    public static void main(String... args) {
        Customer joe = new DiscountedCustomer("Joe", "128 Bullpen Street");
        joe.add(() -> 2.5);
        joe.add(() -> 3.5);
        System.out.println("Joe's basket will cost $ " + joe.total());
    }
}