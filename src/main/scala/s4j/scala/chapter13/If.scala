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

package s4j.scala.chapter13

class If {
  val age = 23

  // verbose version
  if (age > 55) {
    retire()
  } else {
    carryOnWorking()
  }

  // without the braces
  if (age > 55)
    retire()
  else
    carryOnWorking()

  // succinct version
  if (age > 55) retire() else carryOnWorking()


  def retire() = ()
  def carryOnWorking() = ()
  def savings: Int = 0
}
