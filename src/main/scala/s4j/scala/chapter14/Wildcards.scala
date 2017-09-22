
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

package s4j.scala.chapter14

import scala.collection.mutable

class Wildcards {

  printUnknown(mutable.MutableList[String]())

  // this shouldn't be allowed? I cant add to elements in `printUnknown`???
  //  var list = mutable.MutableList[_]()
  //  list += "Hello"
  //  list += 232
  //  list += new Any
  //  list += null

  //  printUnknown(list)

  def printUnknown(list: mutable.MutableList[_]) {
    for (e <- list) {
      val f: Any = e
      println(e)
    }
  }

  def printAnimals(animals: List[_ <: Animal]) {
    for (animal <- animals) {
      println(animal)
    }
  }

  def addNumbers(numbers: List[_ >: Int]) {
    for (i <- 0 to 99) {
      // ...
    }
  }
}

class Animal extends Comparable[Animal] {
  def compareTo(o: Animal): Int = 0
}
class Lion extends Animal
class Zebra extends Animal