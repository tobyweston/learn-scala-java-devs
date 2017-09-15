package s4j.scala.chapter03

object Collections {

  val list = List("a", "b", "c")

  val map = Map(1 -> "a", 2 -> "b")

  list.foreach(value => println(value))

  // short hand version (similar to method reference in Java)
  list.foreach(println)


  // different ways to process a list with a 'for' loop

  for (value <- list) println(value)

  for (value <- list.reverse) println(value)

  for (value <- list) {
    println(value)
  }

  (0 to 100).foreach(println(_))

}
