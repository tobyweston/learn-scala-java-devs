package s4j.scala.chapter17

object Curry extends App {

  val a = "a"
  val b = "b"

  def f(a: String)(b: String): String = a + b

  val f2: (String) => String = f(a)
  val result: String = f2(b)

  val r: String = f(a)(b)
}
