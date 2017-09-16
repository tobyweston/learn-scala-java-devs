package s4j.java.chapter13;

import java.util.HashSet;
import java.util.Set;

public class ShoppingBasket {

    private final Set<Item> basket = new HashSet<>();

    public void add(Item item) {
        basket.add(item);
    }

    public Double value() {
        return basket.stream().mapToDouble(Item::price).sum();
    }
}
