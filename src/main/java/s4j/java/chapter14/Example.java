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

import s4j.java.chapter12.Customer;
import s4j.java.chapter12.DiscountedCustomer;
import s4j.java.chapter12.PricedItem;
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String... args) {
        polymorphismInGenericLists();
        exampleOfBoundedTypes();
        assignmentRules();
    }

    private static void polymorphismInGenericLists() {
        List<Customer> customers = new ArrayList<>();
        // customers.add(new HockeyPuck());        // compiler failure

        Customer customerA = new Customer("Bob", "15 Fleetwood Mack Road");
        Customer customerB = new DiscountedCustomer("Derick Jonar", "23 Woodland Way");
        customerA.add(new PricedItem(10D));
        customerB.add(new PricedItem(10D));

        customers.add(customerA);
        customers.add(customerB);

        for (Customer customer : customers) {
            System.out.println(customer.getName() + " : " + customer.total());
        }
    }

    public static void exampleOfBoundedTypes() {

        // what's the difference between these two?

        Stack<Integer> a = new NumberStack<>();
        a.push(12);
        Integer popA = a.pop();

        Stack<Integer> b = new ListStack<>();
        b.push(12);
        Integer popB = b.pop();


        // Stack<String> b = new NumberStack<>(); // compiler failure
    }

    private static void assignmentRules() {

        // simple sub-type assignment

        A a = new A();
        B b = new B();
        a = b;
        // b = a; // compiler failure

        // not the same rules for generics
        List<B> listA = new ArrayList<>();
        List<A> listB = new ArrayList<>();
        // listA = listB;  // compiler failure
        // listB = listA;  // compiler failure
    }

    public static <A extends Comparable> List<A> sort(List<A> list) {
        list.sort((first, second) -> first.compareTo(second));
        return list;
    }

    public static class NumberStack<T extends Number> extends ListStack<T> { }
    private static class HockeyPuck {}
    private static class A {}
    private static class B extends A {}
}
