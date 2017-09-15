package s4j.scala.chapter03

object Interop {

  val list = new java.util.ArrayList[String]

  list.add("Hello")

  list add "World!"

  // note this is Java's forEach method and not Scala's foreach method
  list.forEach((value: String) => println(value))
}
