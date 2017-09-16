package s4j.scala.chapter18

object HeroConstructorPatternExample extends App {

  val bruce = new SuperHero("Batman", "Bruce Wayne", List("Intellect", "Speed", "Agility", "Strength"))
  val youngBruce = new Person("Bruce Wayne")
  val jane = new Person("Jane Doe")

  def superPowersFor(person: Person) = {
    person match {
      case SuperHero(_, name, powers) => powers
      case _                          => List()
    }
  }

  // Example of a constructor pattern

  // What super powers does a person have, if they are in fact a super hero who's alter ego is Bruce Wayne?
  val person = bruce
  println("Bruce has the following powers " + superPowersFor(person))
  println("Young Bruce has the following powers " + superPowersFor(youngBruce))
  println("Jane has the following powers " + superPowersFor(jane))
}
