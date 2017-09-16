
package s4j.java.chapter14;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Zoo {

    public static <A extends Comparable<? super A>> void sort(List<A> list) {
    }

    // public static <A extends Comparable<?>, U> void scalaLikeSort(List<A> list) {
    public static <A extends Comparable<?>> void scalaLikeSort(List<A> list) {
        // eg. Collections.sort(list);
    }

    public static void main(String... args) {
        List<Lion> enclosure = new ArrayList<>();
        enclosure.add(new Lion());
        enclosure.add(new Lion());
        sort(enclosure);

        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Zebra());
        zoo.add(new Lion());
        zoo.add(new Lion());
        sort(zoo);
    }

    static class Animal implements Comparable<Animal> {
        @Override
        public int compareTo(Animal o) {
            return 0;
        }
    }
    static class Lion extends Animal { }
    static class Zebra extends Animal { }
}
