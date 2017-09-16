package s4j.scala.chapter17

object Numerals extends App {

  val numerals = List("I", "II", "III", "IV", "V", "VI", "VII")

  private val function = (value: String) => println(value)

  numerals.foreach((value: String) => function(value)) // long hand
  numerals.foreach(function(_))                        // implicit parameter
  numerals.foreach(function)                           // method value

  numerals.foreach((value: String) => println(value)) // long hand
  numerals.foreach(println(_))                        // implicit parameter
  numerals.foreach(println)                           // method value

}
