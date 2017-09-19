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

package s4j.scala.chapter21

object Desugared {

  for (i <- 0 to 5) {
    println(i)
  }

  // is de-sugared as
  (0 to 5).foreach(println)


  // nested loop
  for (i <- 0 to 5; j <- 0 to 5) {
    println(i + " " + j)
  }

  // is de-sugared as
  (0 to 5).foreach { i =>
    (0 to 5).foreach { j =>
      println(i + " " + j)
    }
  }


  // for with yield
  for (i <- 0 to 5) yield {
    i + 2
  }

  // is de-sugared as
  (0 to 5).map(i => i + 2)


  // more interesting example
  val x: Seq[(Int, Int)] = for {
    i <- 0 to 5
    j <- 0 to 5
  } yield {
    (i, j)
  }

  val x2: Seq[(Int, Int)] = (0 to 5).flatMap {
    i => (0 to 5).map {
      j => (i, j)
    }
  }

}
