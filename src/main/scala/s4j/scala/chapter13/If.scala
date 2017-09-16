package s4j.scala.chapter13

class If {
  val age = 23

  // verbose version
  if (age > 55) {
    retire()
  } else {
    carryOnWorking()
  }

  // without the braces
  if (age > 55)
    retire()
  else
    carryOnWorking()

  // succinct version
  if (age > 55) retire() else carryOnWorking()


  def retire() = ()
  def carryOnWorking() = ()
  def savings: Int = 0
}
