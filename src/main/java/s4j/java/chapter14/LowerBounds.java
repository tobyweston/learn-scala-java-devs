
package s4j.java.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBounds {

    public static <A extends Comparable<? super A>> void sort(List<A> list) {
        Collections.sort(list);
    }

    public static void main(String... args) {
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Wolf());
        zoo.add(new Lion());
        zoo.add(new Wolf());
        System.out.println(zoo);
        sort(zoo);
        System.out.println(zoo);

        List<Cat> cattery = new ArrayList<>();
        sort(cattery);
    }

    interface Animal extends Comparable<Animal> {
        default int compareTo(Animal o) {
            return this.getFoodChainRanking().compareTo(o.getFoodChainRanking());
        }
        Integer getFoodChainRanking();
    }

    static class Lion implements Animal {
        @Override
        public Integer getFoodChainRanking() {
            return 10;
        }
    }

    static class Wolf implements Animal {
        @Override
        public Integer getFoodChainRanking() {
            return 8;
        }
    }

    static class DomesticPet {}

    static class Cat extends DomesticPet implements Comparable<DomesticPet>{
        @Override
        public int compareTo(DomesticPet o) {
            return 0;
        }
    }
}
