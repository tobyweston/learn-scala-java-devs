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

object Variables {

  val immutable: String = "Scala"     // immutable can not be reassigned

  var language: String = "Java"
  language = "Scala"                  // var can be reassigned

  val age = 35
  var maxHeartRate = 210 - age * .5   // maxHeartRate: Double = 191.5

}
