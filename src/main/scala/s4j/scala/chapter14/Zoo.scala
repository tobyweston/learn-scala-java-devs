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

// see http://stackoverflow.com/questions/16430355/translating-generic-wildcards-from-java-to-scala

object Zoo {

  def sortOrdered[A <: Ordered[U], U >: A](list: List[A]) = {
//    Collections.sort(list)
  }

  def badSort[A <: Comparable[A]](list: List[A]) = { }

  def sort[A <: Comparable[U], U >: A](list: List[A]) {
//    Collections.sort(list)
  }

  // is the working `sort` the same as `sort3`?

  def sort3[A <: Comparable[_]](list: List[A]) {
//    Collections.sort(list)
  }

  // doesn't compile: illegal cyclic references involving type T
  // def compilerFailure[T <: Comparable[_ >: T]](a: Array[T]) { }

  def main(args: Array[String]) {
    var enclosure = List[Lion]()
    enclosure = new Lion +: enclosure
    enclosure = new Lion +: enclosure
    sort[Lion, Animal](enclosure)
    var lion: Lion = enclosure(1)

    var zoo = List[Animal]()
    zoo = new Zebra +: zoo
    zoo = new Lion +: zoo
    zoo = new Lion +: zoo
    sort(zoo)
    var animal: Animal = zoo(1)
  }

}


