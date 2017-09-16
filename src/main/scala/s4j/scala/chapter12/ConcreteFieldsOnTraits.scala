
package s4j.scala.chapter12

trait Counter {
  var count = 0
  def increment()
  override def toString = count.toString
}

class IncrementByOne extends Counter {
  override def increment(): Unit = count += 1
}

class ExponentialIncrementer(rate: Int) extends Counter {
  def increment(): Unit = if (count == 0) count = 1 else count *= rate
}


package counter {

  object Example extends App {
    val counter = new ExponentialIncrementer(2)
    println("counter = " + counter)
    counter.increment()
    counter.increment()
    counter.increment()
    counter.increment()
    println("counter = " + counter)
  }

}