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

package s4j.scala.chapter03

object Collections {

  val list = List("a", "b", "c")

  val map = Map(1 -> "a", 2 -> "b")

  list.foreach(value => println(value))

  // short hand version (similar to method reference in Java)
  list.foreach(println)


  // different ways to process a list with a 'for' loop

  for (value <- list) println(value)

  for (value <- list.reverse) println(value)

  for (value <- list) {
    println(value)
  }

  (0 to 100).foreach(println(_))

}
