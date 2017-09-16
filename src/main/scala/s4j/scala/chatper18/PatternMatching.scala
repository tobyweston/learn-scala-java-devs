package s4j.scala.chatper18

import java.net.{MalformedURLException, URL}

object PatternMatchingExamples extends App {

  "value" match {
    case "z" => println("z")
    case a => println(a)
    case _ => ???
  }

  // constructor pattern
  Foo("bob", 7) match {
    case Foo(x, 9) => println(x + " 09")
    case Foo(x, _) => println(x)
    case _ => ???
  }

  case class Foo(string: String, int: Int) {
    def this(string: String) = this(string, 0)
  }

}

class Person(val name: String) 

case class SuperHero(heroName: String, alterEgo: String, powers: List[String]) extends Person(alterEgo)

object BasicConstructorPatternExample extends App {

  val hero = new SuperHero("Batman", "Bruce Wayne", List("Intellect", "Speed", "Agility", "Strength"))

  hero match {
    case SuperHero(_, "Bruce Wayne", _) => println("I'm Batman!")
    case SuperHero(_, _, _) => println("I'm Batman!")
    case _ => println("I'm a civilian")
  }
  
}

object HeroConstructorPatternExample extends App {

  val bruce = new SuperHero("Batman", "Bruce Wayne", List("Intellect", "Speed", "Agility", "Strength"))
  val youngBruce = new Person("Bruce Wayne")
  val jane = new Person("Jane Doe")

  def superPowersFor(person: Person) = {
    person match {
      case SuperHero(_, name, powers) => powers
      case _ => List()
    }
  }

  // Example of a constructor pattern

  // What super powers does a person have, if they are in fact a super hero who's alter ego is Bruce Wayne?
  val person = bruce
  println("Bruce has the following powers " + superPowersFor(person))
  println("Young Bruce has the following powers " + superPowersFor(youngBruce))
  println("Jane has the following powers " + superPowersFor(jane))
}

object HeroTypePatternExample extends App {

  val batman = new SuperHero("Batman", "Bruce Wayne", List("Intellect", "Speed", "Agility", "Strength"))
  val youngBruce = new Person("Bruce Wayne")
  val jane = new Person("Jane Doe")

  def nameFor(person: Person) = {
    person match {
      case hero: SuperHero => hero.alterEgo
      case person: Person => person.name
    }
  }

  // Example of type check pattern

  // What's an super hero's alter ego?
  println("Batman's Alter ego is " + nameFor(batman))
  println("Young Bruce's Alter ego is " + nameFor(youngBruce))
  println("Jane's Alter ego is " + nameFor(jane))
}

object ExtractorExample extends App {
  val today = ""

  val customer = new Customer("Bob", "1 Church street")
  customer match {
    case Customer(name, address) => println(name + " " + address)
  }

  customer.yearsACustomer = 3
  val discount = customer match {
    case YearsOfCustom(years) if years >= 5 => Discount(0.5)
    case YearsOfCustom(years) if years >= 2 => Discount(0.2)
    case YearsOfCustom(years) if years >= 1 => Discount(0.1)
    case _ if blackFriday(today) => Discount(0)
    case _ => Discount(0)
  }
  println(discount)

  val discount2 = customer match {
    case DiscountExtractor(d)  => d
  }
  println(discount2)

  val url = "http://baddotrobot.com" match {
    case UrlExtractor(protocol, host) => println(protocol + " " + host)
  }

  def blackFriday(x: String): Boolean = true
}

class Customer(val name: String, val address: String) {
  var yearsACustomer: Int = 0
}

object Customer {
  def unapply(customer: Customer): Option[(String, String)] = Some((customer.name, customer.address))
}

object YearsOfCustom {
  def unapply(customer: Customer): Option[Int] = Some(customer.yearsACustomer)
}

object DiscountExtractor {
  def unapply(customer: Customer): Option[Discount] = {
    if (customer.yearsACustomer >= 5) Some(Discount(0.5))
    else if (customer.yearsACustomer >= 2) Some(Discount(0.2))
    else if (customer.yearsACustomer >= 1) Some(Discount(0.1))
    else None
  }
}

object UrlExtractor {
  def unapply(string: String): Option[(String, String)] = {
    try {
      val url = new URL(string)
      Some((url.getProtocol, url.getHost))
    } catch {
      case _: MalformedURLException => None
    }
  }
}

case class Discount(value: Double)
