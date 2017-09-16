package s4j.scala.chapter18

object BasicConstructorPatternExample extends App {

  val hero = new SuperHero("Batman", "Bruce Wayne", List("Speed", "Agility", "Strength"))

  hero match {
    case SuperHero(_, "Bruce Wayne", _) => println("I'm Batman!")
    case SuperHero(_, _, _)             => println("I'm Batman!")
    case _                              => println("I'm a civilian")
  }

}
