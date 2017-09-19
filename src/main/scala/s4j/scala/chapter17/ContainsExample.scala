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

package s4j.scala.chapter17

object Contains extends App {

  def containsNegativeNumbers(numbers: List[Int]): Boolean = {
    var exists = false
    for (number <- numbers)
      if (number < 0)
        exists = true
    exists
  }

  def containsOddNumbers(numbers: List[Int]): Boolean = {
    var exists = false
    for (number <- numbers)
      if (number % 2 == 1)
        exists = true
    exists
  }

  def contains(numbers: List[Int], predicate: Int => Boolean): Boolean = {
    var exists = false
    for (number <- numbers)
      if (predicate(number))
        exists = true
    exists
  }

 def contains2(numbers: List[Int])(predicate: Int => Boolean): Boolean = {
    var exists = false
    for (number <- numbers)
      if (predicate(number))
        exists = true
    exists
  }


  println(containsNegativeNumbers(List(0, 1, -1, 45)))
  println(containsNegativeNumbers(List(0, 1, 9, 45)))
  println(containsOddNumbers(List(0, 1, -1, 45)))
  println(containsOddNumbers(List(0, 2, 4, 10)))

  // using higher order function
  val negativeNumbers = (x: Int) => x < 0
  println(contains(List(0, 1, -1, 45), negativeNumbers))
  println(contains(List(0, 1, 9, 45), negativeNumbers))

  val oddNumbers = (x: Int) => x % 2 == 1
  println(contains(List(0, 1, -1, 45), oddNumbers))
  println(contains(List(0, 2, 4, 10), oddNumbers))

  println
  println(contains2(List(0, 1, -1, 45)) {
    _ < 0
  })
  println(contains2(List(0, 1, -1, 45)) {
    _ % 2 == 1
  })

}
