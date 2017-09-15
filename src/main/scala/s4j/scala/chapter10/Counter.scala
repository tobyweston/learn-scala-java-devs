package s4j.scala.chapter10

class Counter() {
  private var count = 0

  def increment(): Unit = {
    count += 1
  }

  def getCount: Int = count
}
