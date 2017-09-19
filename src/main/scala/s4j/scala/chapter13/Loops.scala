
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

object Do extends App {
  var i = 0
  do {
    println(i)
    i += 1
  } while (i < 10)
}

object DoWithFor extends App {
  var i = 0
  do {
    for (j <- 0 to i)
      print("*")
    print("\n")
    i += 1
  } while (i < 10)
}

object While extends App {
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
}

object ForAsAWhile extends App {
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
}

object For extends App {
  for (i <- 0 to 10) {
    println(i)
  }

  (0 to 10).foreach(i => println(i))
  (0 to 10).foreach(println(_))

}





