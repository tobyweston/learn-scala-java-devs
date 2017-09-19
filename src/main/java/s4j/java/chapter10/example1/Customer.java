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

package s4j.java.chapter10.example1;

public class Customer {
	private final String fullname;

	public Customer(String forename, String initial, String surname) {
		if (initial != null && !initial.isEmpty())
			this.fullname =
				String.format("%s %s. %s", forename, initial, surname);
		else
			this.fullname = String.format("%s %s", forename, surname);
	}

	public Customer(String forename, String surname) {
		this(forename, "", surname);
	}

	public static void main(String... args) {
		System.out.println(new Customer("Bob", "J", "Smith").fullname);
		System.out.println(new Customer("Bob", "Smith").fullname);
	}
}