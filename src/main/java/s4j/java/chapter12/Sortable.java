
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

}
