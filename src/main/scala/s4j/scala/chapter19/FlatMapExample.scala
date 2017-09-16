package s4j.scala.chapter19

import java.util.Calendar

object FlatMapExample extends App {

  def ageEitherSide(birthYear: Int): List[Int] = {
    val today = Calendar.getInstance.get(Calendar.YEAR)
    List(today - 1 - birthYear, today - birthYear, today + 1 - birthYear)
  }

  val birthdays = List(1990, 1977, 1984)

  println(birthdays.map(ageEitherSide))
  // outputs:
  // List(List(26, 27, 28), List(39, 40, 41), List(32, 33, 34))

  println(birthdays.flatMap(ageEitherSide))
  // outputs:
  // List(24, 25, 26, 37, 38, 39, 30, 31, 32)

}
