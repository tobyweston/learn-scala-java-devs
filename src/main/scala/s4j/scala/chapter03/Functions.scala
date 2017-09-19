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

object Functions {

  def min(x: Int, y: Int): Int = {
    if (x < y)
      return x
    else
      return y
  }

  val res1 = min(34, 3)          // res1: Int = 3
  val res2 = min(10, 50)         // res2: Int = 10


  // return can be dropped

  def min2(x: Int, y: Int): Int = {
    if (x < y)
      x
    else
      y
  }

  val res3 = min(300, 43)         // res3: Int = 43


  // last statement as a return value

  def buggy_min(x: Int, y: Int): Int = {
    if (x < y)
      x
    y         // bug! where's the else?
  }

  val res4 = min(10, 230)         // res4: Int = 230


  // the return type can be omitted

  def min3(x: Int, y: Int) = {
    if (x < y)
      x
    else
      y
  }


  def min4(x: Int, y: Int) = if (x < y) x else y


  // doesn't compile (missing = symbol)

  //  def min5(x: Int, y: Int) {
  //    if (x < y) x else y
  //  }

}
