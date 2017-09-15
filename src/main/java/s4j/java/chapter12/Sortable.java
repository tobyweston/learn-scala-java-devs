
package s4j.java.chapter12;

import java.util.*;

@SuppressWarnings("all")
public interface Sortable<A extends Comparable<A>> extends Iterable<A> {

    default public List<A> sort() {
        List<A> list = new ArrayList<>();
        for (A elements: this)
            list.add(elements);
        list.sort((first, second) -> first.compareTo(second));
        return list;
    }

    public class NumbersUsageExample {
        public static void main(String... args) {
            Sortable<Integer> numbers = new NumberList(1, 34, 65, 23, 0, -1, 45, 67);
            System.out.println(numbers.sort());
        }

        private static class NumberList implements Sortable<Integer> {
            private Integer[] numbers;

            private NumberList(Integer... numbers) {
                this.numbers = numbers;
            }

            @Override
            public Iterator<Integer> iterator() {
                return Arrays.asList(numbers).iterator();
            }
        }
    }

	public class CustomersUsageExample {
        public static void main(String... args) {
            Customers customers = new CustomersSortableBySpend();

            Customer daphne = new Customer("Daphne Blake", "101 Easy St");
            Customer fred = new Customer("Fred Jones", "8 Tuna Lane,");
            DiscountedCustomer norville = new DiscountedCustomer("Norville Rogers", "12 Maple Street");
            Customer velma = new Customer("Velma Dinkley", "316 Circle Drive");

            daphne.add(new PricedItem(2.4));
            daphne.add(new PricedItem(1.4));
            fred.add(new PricedItem(2.75));
            fred.add(new PricedItem(2.75));
            norville.add(new PricedItem(6.99));
            norville.add(new PricedItem(1.50));

            customers.add(daphne);
            customers.add(fred);
            customers.add(norville);
            customers.add(velma);

            System.out.println(customers.sort());
        }
    }
}
