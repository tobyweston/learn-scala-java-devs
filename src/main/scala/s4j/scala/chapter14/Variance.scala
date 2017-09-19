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

class Variance {

  class A {}
  class B extends A {}

  class Container[T] {}                 // invariant
  class CovariantContainer[+T] {}
  class ContravariantContainer[-T] {}

  def main(args: Array[String]) {
    basicSubTyping
    invariant
    covariant
    contravariant
  }

  private def basicSubTyping {
    var a: A = new A
    val b: B = new B

    a = b
    // b = a // compiler failure
  }

  private def invariant {
    var a = new Container[A]
    var b = new Container[B]

    // a = b  // compiler failure
  }

  private def covariant {
    var a = new CovariantContainer[A]
    var b = new CovariantContainer[B] // sub-type

    a = b
    // b = a  // compiler failure
  }

  private def contravariant {
    var a = new ContravariantContainer[A]
    var b = new ContravariantContainer[B]

    // a = b // compiler failure
    b = a
  }
}
