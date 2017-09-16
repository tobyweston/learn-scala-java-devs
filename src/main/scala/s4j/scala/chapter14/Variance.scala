package s4j.scala.chapter14

class Variance {

  class A {}
  class B extends A {}

  class Container[T] {}                 // invariant
  class CovariantContainer[+T] {}
  class ContravariantContainer[-T] {}

  def main(args: Array[String]) {
    basicSubTyping
    invariant
    covariant
    contravariant
  }

  private def basicSubTyping {
    var a: A = new A
    val b: B = new B

    a = b
    // b = a // compiler failure
  }

  private def invariant {
    var a = new Container[A]
    var b = new Container[B]

    // a = b  // compiler failure
  }

  private def covariant {
    var a = new CovariantContainer[A]
    var b = new CovariantContainer[B] // sub-type

    a = b
    // b = a  // compiler failure
  }

  private def contravariant {
    var a = new ContravariantContainer[A]
    var b = new ContravariantContainer[B]

    // a = b // compiler failure
    b = a
  }
}
