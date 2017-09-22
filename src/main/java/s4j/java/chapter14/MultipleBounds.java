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
import java.util.Collections;
import java.util.List;

public class MultipleBounds {

	// sets two upper bounds to the generic type A
	public static <A extends Animal & Comparable<Animal>> void sort(List<A> list) {
		Collections.sort(list);
	}

	public static void main(String... args) {

		List<Lion> enclosure = new ArrayList<>();
		enclosure.add(new Lion());
		enclosure.add(new Lion());
		sort(enclosure);

		List<Animal> zoo = new ArrayList<>();
		zoo.add(new Lion());
		zoo.add(new Lion());
		zoo.add(new Zebra());
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
