package s4j.scala.chapter03

object Functions {

  def min(x: Int, y: Int): Int = {
    if (x < y)
      return x
    else
      return y
  }

  val res1 = min(34, 3)          // res1: Int = 3
  val res2 = min(10, 50)         // res2: Int = 10


  // return can be dropped

  def min2(x: Int, y: Int): Int = {
    if (x < y)
      x
    else
      y
  }

  val res3 = min(300, 43)         // res3: Int = 43


  // last statement as a return value

  def buggy_min(x: Int, y: Int): Int = {
    if (x < y)
      x
    y         // bug! where's the else?
  }

  val res4 = min(10, 230)         // res4: Int = 230


  // the return type can be omitted

  def min3(x: Int, y: Int) = {
    if (x < y)
      x
    else
      y
  }


  def min4(x: Int, y: Int) = if (x < y) x else y


  // doesn't compile (missing = symbol)

  //  def min5(x: Int, y: Int) {
  //    if (x < y) x else y
  //  }

}
