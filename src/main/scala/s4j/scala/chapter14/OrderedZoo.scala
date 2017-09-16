package s4j.scala.chapter14

// see http://stackoverflow.com/questions/16430355/translating-generic-wildcards-from-java-to-scala

object OrderedZoo {

  def sort[A](list: List[A])(comparator: Ordering[_ >: A]) = {

  }

  // doesn't compile: illegal cyclic references involving type T
  // def compilerFailure[T <: Comparable[_ >: T]](a: Array[T]) { }

  val animalComparator = new Ordering[Animal] {
    override def compare(x: Animal, y: Animal): Int = ???
  }

  def main(args: Array[String]) {
    var enclosure = List[Lion]()
    enclosure = new Lion +: enclosure
    enclosure = new Lion +: enclosure
    sort(enclosure)(animalComparator)
    var lion: Lion = enclosure(1)

    var zoo = List[Animal]()
    zoo = new Zebra +: zoo
    zoo = new Lion +: zoo
    zoo = new Lion +: zoo
    sort(zoo)(animalComparator)
    var animal: Animal = zoo(1)
  }

  class Animal
  class Lion extends Animal
  class Zebra extends Animal

}


