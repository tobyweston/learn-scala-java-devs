package s4j.scala.chapter16

object ArrayExample extends App {

  val numerals = Array("I", "II", "III", "IV", "V", "VI", "VII")

  println(numerals(5))

  for (i <- 0 to numerals.length - 1)
    println(i + " = " + numerals(i))

  // could have written this
  for (i <- 0 to numerals.length - 1)
    println(i + " = " + numerals.apply(i))

  // more functional version
  for ((value, index) <- numerals.zipWithIndex)
    println(index + " : " + value)

  numerals(1) = "?"
}
