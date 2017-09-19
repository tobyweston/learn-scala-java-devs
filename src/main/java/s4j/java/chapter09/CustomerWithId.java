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

package s4j.java.chapter09;

public class CustomerWithId {

	private final String name;
	private final String address;

	private String id;

	public CustomerWithId(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void setId(String id) {
		this.id = id;
	}

	static {
		CustomerWithId eric = new CustomerWithId("Eric", "29 Acacia Road");
	}
}
