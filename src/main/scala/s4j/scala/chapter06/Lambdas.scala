package s4j.scala.chapter06

object Lambdas {

  val tuesday = true

  def test(f: () => Boolean) = f.apply

  // pass in a function literal
  test(() => if (!tuesday) true else false)


  // alternative example
  //
  // this will take a predicate (String => Boolean) and test
  // it against a value (in our case "monday").
  //
  def test(f: String => Boolean): Boolean = {
    // get some value
    val dayOfWeek = "monday"
    f(dayOfWeek)
  }

  // call it with a function literal
  test(value => if (value == "tuesday") true else false)


}
