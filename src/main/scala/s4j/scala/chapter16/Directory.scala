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

class Directory {
  private val numbers = scala.collection.mutable.Map(
    "Athos" -> "7781 456782",
    "Aramis" -> "7781 823422",
    "Porthos" -> "1471 342383",
    "D`Artagnan" -> "7715 632982"
  )

  def apply(name: String) = {
    numbers.get(name)
  }

  def update(name: String, number: String) = {
    numbers.update(name, number)
  }

  def update(areaCode: Int, newAreaCode: String) = {
    numbers.foreach(entry => {
      if (entry._2.startsWith(areaCode.toString))
        numbers(entry._1) = entry._2.replace(areaCode.toString, newAreaCode)
    })
  }

  def update(areaCode: Int, anotherArgument: String, newAreaCode: String) = ???

  override def toString = numbers.toString()
}

object Directory extends App {

  val yellowPages = new Directory()
  println(yellowPages)
  yellowPages(7781) = "7555"
  yellowPages(7998, "another argument") = "???"
  println(yellowPages)

}
