package s4j.scala.chapter19

class Mappable[A](elements: List[A]) {

  def map[B](f: A => B): List[B] = {
    val result = collection.mutable.MutableList[B]()
    elements.foreach {
      result += f(_)
    }
    result.toList
  }

  // recursive version (with a nested def)
  def recur_map[B](f: A => B): List[B] = {
    def recur(head: A, tail: List[A]): List[B] = {
      tail match {
        case Nil => List(f(head))
        case _   => f(head) +: recur(tail.head, tail.tail)
      }
    }

    recur(elements.head, elements.tail)
  }

  // tail recursive version
  def tail_recur_map[B](f: A => B): List[B] = {
    def recur(accumulator: List[B], elements: List[A]): List[B] = {
      elements match {
        case Nil          => accumulator
        case head :: tail => recur(accumulator :+ f(head), tail)
      }
    }

    recur(List[B](), elements)
  }
}

package map {

  object Example extends App {
    val numbers = List(1, 2, 54, 4, 12, 43, 54, 23, 34)
    val mappable = new Mappable(numbers)

    println(mappable.map(_ * 2))
    println(mappable.recur_map(_ * 2))
    println(mappable.tail_recur_map(_ * 2))
  }

}