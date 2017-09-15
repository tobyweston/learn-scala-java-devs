package s4j.scala.chapter11;

object PassingInFunctions {

	val list = List("A", "C", "B", "D")
	list.sorted((a: String, b: String) => a.compareTo(b))     // ascending
	list.sorted((a: String, b: String) => b.compareTo(a))     // descending

  // alternative syntax, implicit arguments
	list.sorted(_.compareTo(_))                               // ascending

  // note that in Scala 2.11 you couldn't do this
  list.sorted((x: String, y: String) => x.compareTo(y))

  // this is because 2.12 uses Java 8 under the covers and can leverage
  // it to convert the lambda to single abstract method (SAM).

  // Scala 2.11 would require you to write it long-hand, like this:
    list.sorted(new Ordering[String] {
    override def compare(x: String, y: String): Int = ???
  })
}
