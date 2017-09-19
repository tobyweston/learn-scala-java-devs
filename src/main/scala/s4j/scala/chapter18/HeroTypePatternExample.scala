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

object HeroTypePatternExample extends App {

  val batman = new SuperHero("Batman", "Bruce Wayne", List("Intellect", "Speed", "Agility", "Strength"))
  val youngBruce = new Person("Bruce Wayne")
  val jane = new Person("Jane Doe")

  def nameFor(person: Person) = {
    person match {
      case hero: SuperHero => hero.alterEgo
      case person: Person  => person.name
    }
  }

  // Example of type check pattern

  // What's an super hero's alter ego?
  println("Batman's Alter ego is " + nameFor(batman))
  println("Young Bruce's Alter ego is " + nameFor(youngBruce))
  println("Jane's Alter ego is " + nameFor(jane))
}
