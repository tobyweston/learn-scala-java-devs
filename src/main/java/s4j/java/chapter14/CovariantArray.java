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

import s4j.java.chapter13.Customer;
import s4j.java.chapter13.DiscountedCustomer;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CovariantArray {
    public static void main(String... args) {

        // wont compile
        // List<Object> x = new ArrayList<String>();
        // x.add(21);

        Object[] array = new String[1];
        array[0] = 21; // throws exception

        // Covariance //

        // wont compile
        // List<Number> c = new ArrayList<Integer>();
        
        // ok
        List<? extends Number> c1 = new ArrayList<Integer>();
        List<? extends Number> c2 = new ArrayList<Float>();
        Number number = c2.get(0);


        // Contravariance //
        List<? super Integer> c3 = new ArrayList<Number>();
        c3.add(43);
        Object o = c3.get(1);
    }

    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        for (T t : source) {
            destination.add(t);
        }
    }

    public static void copyUsage() {
        List<Integer> ints = asList(1,2,3,4);
        List<Double> doubles = asList(3.14, 6.28);
        List<Object> objects = new ArrayList<Object>();
        copy(ints, objects);
        copy(doubles, objects);
    }

    public static void superExample() {
        List<DiscountedCustomer> customersA = new ArrayList<>();
        List<Customer> customersB = new ArrayList<>();
        copy(customersA, customersB);
    }

    public static class Fruit {}
    public static class Banana extends Fruit {}
    public static class Apple extends Fruit {}

    public static void exampleFruitBowl() {

        // maybe not useful as wildcards are better on method args?
		//
		// List<? extends Fruit> fruit = new ArrayList<>();
		// fruit.add(new Apple()); // can't add apple as it may be a list of bananas
		// fruit.add(new Fruit());
		// fruit.add(new Object());
		// Fruit something = fruit.get(0);

        List<Apple> apples = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        copy(apples, fruits);

        foo(apples);
        foo(fruits);

        List<? super Fruit> bowl = new ArrayList<>();
        bowl.add(new Banana());
        bowl.add(new Apple());
        bowl.add(new Fruit());
        Object thing = bowl.get(0);
    }

    public static void foo(List<? extends Fruit> lists) {

    }
}
