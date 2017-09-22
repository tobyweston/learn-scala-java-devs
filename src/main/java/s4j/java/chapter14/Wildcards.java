/*
 * Copyright (c) 2015-2017 Toby Weston
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package s4j.java.chapter14;


import java.util.ArrayList;
import java.util.List;

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

    static class Animal implements Comparable<Animal> {
        @Override
        public int compareTo(Animal o) {
            return 0;
        }
    }
    static class Lion extends Animal { }
    static class Zebra extends Animal { }
}

