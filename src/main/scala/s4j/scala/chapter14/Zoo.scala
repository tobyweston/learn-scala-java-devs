package s4j.scala.chapter14

// see http://stackoverflow.com/questions/16430355/translating-generic-wildcards-from-java-to-scala

object Zoo {

  def sortOrdered[A <: Ordered[U], U >: A](list: List[A]) = {
//    Collections.sort(list)
  }

  def badSort[A <: Comparable[A]](list: List[A]) = { }

  def sort[A <: Comparable[U], U >: A](list: List[A]) {
//    Collections.sort(list)
  }

  // is the working `sort` the same as `sort3`?

  def sort3[A <: Comparable[_]](list: List[A]) {
//    Collections.sort(list)
  }

  // doesn't compile: illegal cyclic references involving type T
  // def compilerFailure[T <: Comparable[_ >: T]](a: Array[T]) { }

  def main(args: Array[String]) {
    var enclosure = List[Lion]()
    enclosure = new Lion +: enclosure
    enclosure = new Lion +: enclosure
    sort[Lion, Animal](enclosure)
    var lion: Lion = enclosure(1)

    var zoo = List[Animal]()
    zoo = new Zebra +: zoo
    zoo = new Lion +: zoo
    zoo = new Lion +: zoo
    sort(zoo)
    var animal: Animal = zoo(1)
  }

}


