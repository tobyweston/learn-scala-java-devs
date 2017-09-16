package s4j.scala.chapter14

class Animal extends Comparable[Animal] {
  def compareTo(o: Animal): Int = 0
}
class Lion extends Animal
class Zebra extends Animal