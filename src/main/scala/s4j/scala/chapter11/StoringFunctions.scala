package s4j.scala.chapter11

object StoringFunctions {

  // a function
  (a: Int, b: Int) => a + b

  // store it, old school
  val plus: Function2[Int, Int, Int] = (a: Int, b: Int) => a + b   // scala

  // store it, new school
  val plus2: (Int, Int) => Int = (a: Int, b: Int) => a + b          // scala

  // abbreviated
  val plus3: (Int, Int) => Int = (a, b) => a + b                    // scala

  // apply the function like this:
  plus(2, 2)               // 4
  plus(plus(2, 2), 4)      // 8
  
}
