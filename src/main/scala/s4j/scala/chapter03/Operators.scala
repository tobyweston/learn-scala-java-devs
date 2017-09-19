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

package s4j.scala.chapter03

object Operators {

  val age: Int = 34

  age.*(.5)                     // The Int age calls the * method
  5.*(10)                       // 5 is an Int, Int has the * method
  age * .5                      // infix notation

  35 toString                   // toString is also a method on Int

  35 + 10                       // + is a method too (infix example)

  "aBCDEFG" replace("a", "A")   // as is replace (infix example(


  val train = "6:30 from London"
  val passenger = "Mr Smith"

  train + passenger

}
