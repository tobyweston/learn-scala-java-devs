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

object CovariantArray {

  def copy(source: List[_ <: AnyVal], destination: List[_ >: AnyVal]) {
    for (number <- source) {
      destination.+:(number)
    }
  }

  def copyUsage {
    val ints: List[Int] = List(1, 2, 3, 4)
    val doubles: List[Double] = List(3.14, 6.28)
    val objects: List[AnyVal] =  List()
    copy(ints, objects)
    copy(doubles, objects)
  }

  class Foo[T] {
    def append1[U <: T](x: U): T = x
    // def append2(x: _ <: T): _ = x
  }

}
