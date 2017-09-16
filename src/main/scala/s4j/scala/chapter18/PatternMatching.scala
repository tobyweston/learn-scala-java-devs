package s4j.scala.chapter18

object PatternMatchingExamples extends App {

  "value" match {
    case "z" => println("z")
    case a   => println(a)
    case _   => ???
  }

  // constructor pattern
  Foo("bob", 7) match {
    case Foo(x, 9) => println(x + " 09")
    case Foo(x, _) => println(x)
    case _         => ???
  }

  case class Foo(string: String, int: Int) {
    def this(string: String) = this(string, 0)
  }

}
