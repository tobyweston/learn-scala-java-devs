package s4j.scala.chapter05

object NamedArgs {

  swap(3, 1)                    // (1, 3)
  swap(first = 3, second = 1)   // (1, 3)
  swap(second = 1, first = 3)   // (1, 3)

  def swap(first: Int, second: Int) = (second, first)
}
