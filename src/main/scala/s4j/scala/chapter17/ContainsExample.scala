package s4j.scala.chapter17

object Contains extends App {

  def containsNegativeNumbers(numbers: List[Int]): Boolean = {
    var exists = false
    for (number <- numbers)
      if (number < 0)
        exists = true
    exists
  }

  def containsOddNumbers(numbers: List[Int]): Boolean = {
    var exists = false
    for (number <- numbers)
      if (number % 2 == 1)
        exists = true
    exists
  }

  def contains(numbers: List[Int], predicate: Int => Boolean): Boolean = {
    var exists = false
    for (number <- numbers)
      if (predicate(number))
        exists = true
    exists
  }

 def contains2(numbers: List[Int])(predicate: Int => Boolean): Boolean = {
    var exists = false
    for (number <- numbers)
      if (predicate(number))
        exists = true
    exists
  }


  println(containsNegativeNumbers(List(0, 1, -1, 45)))
  println(containsNegativeNumbers(List(0, 1, 9, 45)))
  println(containsOddNumbers(List(0, 1, -1, 45)))
  println(containsOddNumbers(List(0, 2, 4, 10)))

  // using higher order function
  val negativeNumbers = (x: Int) => x < 0
  println(contains(List(0, 1, -1, 45), negativeNumbers))
  println(contains(List(0, 1, 9, 45), negativeNumbers))

  val oddNumbers = (x: Int) => x % 2 == 1
  println(contains(List(0, 1, -1, 45), oddNumbers))
  println(contains(List(0, 2, 4, 10), oddNumbers))

  println
  println(contains2(List(0, 1, -1, 45)) {
    _ < 0
  })
  println(contains2(List(0, 1, -1, 45)) {
    _ % 2 == 1
  })

}
