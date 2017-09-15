package s4j.scala.chapter11

object AnonymousClasses {

  val list = List("A", "C", "B", "D")
  list.sorted(new Ordering[String] {
    def compare(a: String, b: String): Int = a.compareTo(b)
  })

  // first class function
  (a: String, b: String) => a.compareTo(b)

}
