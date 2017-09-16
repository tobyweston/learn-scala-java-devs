package s4j.scala.chapter19

import java.util.Calendar

object MapExample {

  def age(birthYear: Int) = {
    val currentYear = Calendar.getInstance.get(Calendar.YEAR)
    currentYear - birthYear
  }

  val birthdays = List(1990, 1977, 1984, 1961, 1973)

  birthdays.map(age)  // = List(25, 38, 31, 54, 42)

  // written in-line
  birthdays.map(year => Calendar.getInstance.get(Calendar.YEAR) - year)

  // with shorthand parameter _
  birthdays.map(Calendar.getInstance.get(Calendar.YEAR) - _)

}
