package s4j.scala.chapter16

class Directory {
  private val numbers = scala.collection.mutable.Map(
    "Athos" -> "7781 456782",
    "Aramis" -> "7781 823422",
    "Porthos" -> "1471 342383",
    "D`Artagnan" -> "7715 632982"
  )

  def apply(name: String) = {
    numbers.get(name)
  }

  def update(name: String, number: String) = {
    numbers.update(name, number)
  }

  def update(areaCode: Int, newAreaCode: String) = {
    numbers.foreach(entry => {
      if (entry._2.startsWith(areaCode.toString))
        numbers(entry._1) = entry._2.replace(areaCode.toString, newAreaCode)
    })
  }

  def update(areaCode: Int, anotherArgument: String, newAreaCode: String) = ???

  override def toString = numbers.toString()
}

object Directory extends App {

  val yellowPages = new Directory()
  println(yellowPages)
  yellowPages(7781) = "7555"
  yellowPages(7998, "another argument") = "???"
  println(yellowPages)

}
