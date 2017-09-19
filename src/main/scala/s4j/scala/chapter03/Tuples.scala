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

object Tuples {

  val tuple = ("save", 50, true)

  val event = tuple._1        // "save"
  val millis = tuple._2       // 50
  val success = tuple._3      // true


  // assign directly to variables

  val (event2, millis2, success2) = tuple


  // specifying the type of the val

  val save: (String, Int, Boolean) = ("save", 50, true)


  // a function with a tuple as a typed argument

  def audit(event: (String, Int, Boolean)) = {
    ???
  }
}
