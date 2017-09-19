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

package s4j.scala.chapter19

import java.util.Calendar

object FlatMapExample extends App {

  def ageEitherSide(birthYear: Int): List[Int] = {
    val today = Calendar.getInstance.get(Calendar.YEAR)
    List(today - 1 - birthYear, today - birthYear, today + 1 - birthYear)
  }

  val birthdays = List(1990, 1977, 1984)

  println(birthdays.map(ageEitherSide))
  // outputs:
  // List(List(26, 27, 28), List(39, 40, 41), List(32, 33, 34))

  println(birthdays.flatMap(ageEitherSide))
  // outputs:
  // List(24, 25, 26, 37, 38, 39, 30, 31, 32)

}
