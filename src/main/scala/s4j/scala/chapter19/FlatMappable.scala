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

class FlatMappable[A](elements: A*) {

  def flatMap[B](f: A => List[B]): List[B] = {
    val result = collection.mutable.MutableList[B]()
    elements.foreach(element => {
      f(element).foreach(subElement => {
        result += subElement
      })
    })
    result.toList
  }

  // abbreviated / alternative syntax (as shown in the book)
  def flatMapAbbr[B](f: A => List[B]): List[B] = {
    val result = collection.mutable.MutableList[B]()
    elements.foreach {
      f(_).foreach {
        result += _
      }
    }
    result.toList
  }
}


package flatmap {

  object Example extends App {

    def oddNumbersTo(end: Int): List[Int] = {
      val odds = collection.mutable.MutableList[Int]()
      for (i <- 0 to end) {
        if (i % 2 != 0) odds += i
      }
      odds.toList
    }

    val mappable = new FlatMappable(1, 2, 10)
    println(mappable.flatMap(oddNumbersTo))
    println(mappable.flatMapAbbr(oddNumbersTo))
  }

}
