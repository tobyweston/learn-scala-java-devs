
package s4j.scala.chapter14

import scala.collection.mutable

class Wildcards {

  printUnknown(mutable.MutableList[String]())

  // this shouldn't be allowed? I cant add to elements in `printUnknown`???
  //  var list = mutable.MutableList[_]()
  //  list += "Hello"
  //  list += 232
  //  list += new Any
  //  list += null

  //  printUnknown(list)

  def printUnknown(list: mutable.MutableList[_]) {
    for (e <- list) {
      val f: Any = e
      println(e)
    }
  }

  def printAnimals(animals: List[_ <: Animal]) {
    for (animal <- animals) {
      println(animal)
    }
  }

  def addNumbers(numbers: List[_ >: Int]) {
    for (i <- 0 to 99) {
      // ...
    }
  }
}
