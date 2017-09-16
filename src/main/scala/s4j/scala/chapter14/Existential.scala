package s4j.scala.chapter14

class Existential {

  // this is described as an existential type

  val foo: List[_ <: AnyRef] = List()

}
