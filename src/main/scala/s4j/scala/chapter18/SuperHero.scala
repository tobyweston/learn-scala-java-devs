package s4j.scala.chapter18

case class SuperHero(heroName: String, alterEgo: String, powers: List[String]) extends Person(alterEgo)
