package s4j.scala.chatper18

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
