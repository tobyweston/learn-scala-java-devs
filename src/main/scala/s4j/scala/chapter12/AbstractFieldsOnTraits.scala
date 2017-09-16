
package s4j.scala.chapter12

trait IntCounter {
  var count: Int  // <--- abstract
  def increment()
}

class ZeroBasedCounter extends IntCounter {
  override var count: Int = 0
  override def increment(): Unit = count += 1
}

// override is optional as both are already abstract
class OneBasedCounter extends IntCounter {
  var count: Int = 1
  def increment(): Unit = count += 1
}

