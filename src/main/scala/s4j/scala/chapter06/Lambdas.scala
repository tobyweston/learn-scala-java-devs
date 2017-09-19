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

package s4j.scala.chapter06

object Lambdas {

  val tuesday = true

  def test(f: () => Boolean) = f.apply

  // pass in a function literal
  test(() => if (!tuesday) true else false)


  // alternative example
  //
  // this will take a predicate (String => Boolean) and test
  // it against a value (in our case "monday").
  //
  def test(f: String => Boolean): Boolean = {
    // get some value
    val dayOfWeek = "monday"
    f(dayOfWeek)
  }

  // call it with a function literal
  test(value => if (value == "tuesday") true else false)


}
