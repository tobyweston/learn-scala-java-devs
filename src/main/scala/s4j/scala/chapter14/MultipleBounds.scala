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

class MultipleBounds {

  // we can't set two upper bounds like we can in Java but we can say the bound type
  // must also extend certain traits
  def sort[A <: Lion with Comparable[Animal]](list: List[A]) = { }

  def main(args: String*) {

    var enclosure = List[Lion]()
    enclosure = new Lion +: enclosure
    enclosure = new Lion +: enclosure
    // sort[Lion, Animal](enclosure)      // compiler error
    sort(enclosure)                       // must remove the type hints

//    var zoo = List[Animal]()
//    zoo = new Zebra +: zoo
//    zoo = new Lion +: zoo
//    zoo = new Lion +: zoo
//    sort(zoo)
  }

  class Animal extends Comparable[Animal] {
    def compareTo(o: Animal): Int = 0
  }
  class Lion extends Animal
  class Zebra extends Animal
}
