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
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @see s4j.java.chapter12.Sortable for usage/alternative examples. Reproduced here as a
 * smaller example to fit with chapter 14.
 */
public class UpperBounds {

	public interface Sortable<A extends Comparable<A>> extends Iterable<A> {
		default public List<A> sort() {
			List<A> list = new ArrayList<>();
			for (A elements : this)
				list.add(elements);
			list.sort((first, second) -> first.compareTo(second));
			return list;
		}
	}

	public class Customers implements Sortable<Customer> {
		@Override
		public List<Customer> sort() {
			return null;
		}

		@Override
		public Iterator<Customer> iterator() {
			return null;
		}

		@Override
		public void forEach(Consumer<? super Customer> action) {

		}

		@Override
		public Spliterator<Customer> spliterator() {
			return null;
		}
	}

	class Customer implements Comparable<Customer> {
		@Override
		public int compareTo(Customer o) {
			return 0;
		}
	}
}