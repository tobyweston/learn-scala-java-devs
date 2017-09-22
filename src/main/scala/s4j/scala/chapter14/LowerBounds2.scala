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

object LowerBounds2 {

  def sort[A <: Comparable[A]](list: List[A]): Unit = { ??? }

  def main(args: String*) {

    // uncomment this section to see the compiler error

//    var enclosure = List[Lion]()
//    enclosure = new Lion +: enclosure
//    enclosure = new Lion +: enclosure
//    sort(enclosure)           // compiler failure

    var zoo = List[Animal]()
    zoo = new Zebra +: zoo
    zoo = new Lion +: zoo
    zoo = new Lion +: zoo
    sort(zoo)                   // wont compile if Animal doesn't implement Comparable
  }

  class Animal extends Comparable[Animal] {
    def compareTo(o: Animal): Int = 0
  }
  class Lion extends Animal
  class Zebra extends Animal
}


