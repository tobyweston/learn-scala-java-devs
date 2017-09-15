package s4j.scala.chapter03

object Tuples {

  val tuple = ("save", 50, true)

  val event = tuple._1        // "save"
  val millis = tuple._2       // 50
  val success = tuple._3      // true


  // assign directly to variables

  val (event2, millis2, success2) = tuple


  // specifying the type of the val

  val save: (String, Int, Boolean) = ("save", 50, true)


  // a function with a tuple as a typed argument

  def audit(event: (String, Int, Boolean)) = {
    ???
  }
}
