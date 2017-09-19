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

package s4j.scala.chapter11;

object PassingInFunctions {

	val list = List("A", "C", "B", "D")
	list.sorted((a: String, b: String) => a.compareTo(b))     // ascending
	list.sorted((a: String, b: String) => b.compareTo(a))     // descending

  // note that in Scala 2.11 you couldn't do this
  list.sorted((x: String, y: String) => x.compareTo(y))

  // this is because 2.12 uses Java 8 under the covers and can leverage
  // it to convert the lambda to single abstract method (SAM).

  // Scala 2.11 would require you to write it long-hand, like this:
    list.sorted(new Ordering[String] {
    override def compare(x: String, y: String): Int = ???
  })
}
