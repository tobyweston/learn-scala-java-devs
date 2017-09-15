package s4j.java.chapter12;

@SuppressWarnings("all")
public class PricedItem implements Item {

    private final Double price;

    public PricedItem(Double price) {
        this.price = price;
    }

    @Override
    public Double price() {
        return price;
    }
}
