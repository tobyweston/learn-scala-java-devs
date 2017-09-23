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

object MapExample extends App {

  def age(birthYear: Int) = {
    val currentYear = Calendar.getInstance.get(Calendar.YEAR)
    currentYear - birthYear
  }

  val birthdays = List(1990, 1977, 1984, 1961, 1973)

  val result = birthdays.map(age)
  println(result)
  // results in List(27, 40, 33, 56, 44) when run in 2017

  // written in-line
  birthdays.map(year => Calendar.getInstance.get(Calendar.YEAR) - year)

  // with shorthand parameter _
  birthdays.map(Calendar.getInstance.get(Calendar.YEAR) - _)

}
