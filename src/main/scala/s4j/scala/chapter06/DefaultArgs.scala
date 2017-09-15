package s4j.scala.chapter06

object DefaultArgs {

  swap(3)                       // (1, 3)
  swap(3, 2)                    // (2, 3)
  swap(first = 3)               // (1, 3)
  swap(first = 3, second = 1)   // (1, 3)

  def swap(first: Int, second: Int = 1) = (second, first)

}
