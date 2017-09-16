package s4j.java.chapter14;


import java.util.ArrayList;
import java.util.List;

import static s4j.java.chapter14.Zoo.Animal;
import static s4j.java.chapter14.Zoo.Lion;

@SuppressWarnings("all")
public class Wildcards {

    public static void main(String... args) {
        cantAddToList();

        // printObjects(new ArrayList<String>()); // compiler error
        printObjects(new ArrayList<Object>());

        // print anything (List<?>)
        printUnknown(new ArrayList<String>());
        printUnknown(new ArrayList<Lion>());

        // printAnimals(new ArrayList<String>());
        printAnimals(new ArrayList<Lion>());

        // addNumbers(new ArrayList<String>());
        addNumbers(new ArrayList<Integer>());
        addNumbers(new ArrayList<Number>());
        addNumbers(new ArrayList<Object>());
    }

    // can't add anything to this collection (except null), see http://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
    private static void cantAddToList() {
        List<?> list = new ArrayList<String>();
        // list.add(new Object());  // compiler error
        // list.add("Hello");       // compiler error
        list.add(null); // ok
    }

    static void printObjects(List<Object> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    static void printUnknown(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    static void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    static void addNumbers(List<? super Integer> numbers) {
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
    }
}
