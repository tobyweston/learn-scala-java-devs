package s4j.scala.chapter12

class Animal
trait HasWings extends Animal
trait Bird extends HasWings
trait HasFourLegs extends Animal
class FlyingHorse extends Animal with Bird with HasFourLegs


package linearization {

  import scala.reflect.runtime.universe._

  object Example extends App {
    typeOf[FlyingHorse].baseClasses.reverse foreach { s => println(s"[${s.name}]") }
  }

  /*
    [Any]
    [Object]
    [Animal]
    [HasWings]
    [Bird]
    [HasFourLegs]
    [FlyingHorse]
  */


}