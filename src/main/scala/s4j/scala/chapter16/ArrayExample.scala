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

package s4j.scala.chapter16

object ArrayExample extends App {

  val numerals = Array("I", "II", "III", "IV", "V", "VI", "VII")

  println(numerals(5))

  for (i <- 0 to numerals.length - 1)
    println(i + " = " + numerals(i))

  // could have written this
  for (i <- 0 to numerals.length - 1)
    println(i + " = " + numerals.apply(i))

  // more functional version
  for ((value, index) <- numerals.zipWithIndex)
    println(index + " : " + value)

  numerals(1) = "?"
}
