package s4j.scala.chapter03

object Operators {

  val age: Int = 34

  age.*(.5)                     // The Int age calls the * method
  5.*(10)                       // 5 is an Int, Int has the * method
  age * .5                      // infix notation

  35 toString                   // toString is also a method on Int

  35 + 10                       // + is a method too (infix example)

  "aBCDEFG" replace("a", "A")   // as is replace (infix example(


  val train = "6:30 from London"
  val passenger = "Mr Smith"

  train + passenger

}
