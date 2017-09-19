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

package s4j.scala.chapter18

object PatternMatchingExamples extends App {

  "value" match {
    case "z" => println("z")
    case a   => println(a)
    case _   => ???
  }

  // constructor pattern
  Foo("bob", 7) match {
    case Foo(x, 9) => println(x + " 09")
    case Foo(x, _) => println(x)
    case _         => ???
  }

  case class Foo(string: String, int: Int) {
    def this(string: String) = this(string, 0)
  }

}
