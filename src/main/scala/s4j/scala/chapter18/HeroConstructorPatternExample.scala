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

object HeroConstructorPatternExample extends App {

  val bruce = new SuperHero("Batman", "Bruce Wayne", List("Speed", "Agility"))
  val steve = new SuperHero("Captain America", "Steve Rogers", List("Tactics", "Speed"))
  val jane = new Person("Jane Doe")


  def superPowersFor(person: Person) = {
    person match {
      case SuperHero(_, _, powers) => powers
      case _                       => List()
    }
  }

  // What super-powers does an otherwise unknown person have, if they are a
  // superhero with the alter-ego Bruce Wayne?

  println("Bruce has the following powers: " + superPowersFor(bruce).mkString(", "))
  println("Steve has the following powers: " + superPowersFor(steve).mkString(", "))
  println("Jane has the following powers: " + superPowersFor(jane).mkString(", "))
}
