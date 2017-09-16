package s4j.scala.chapter13

import scala.util.control.Breaks._

object Breaks extends App {
  var i: Int = 0
  breakable {
    while (i < 100) {
      System.out.println(i)
      if (i == 10)
        break()
      i += 1
    }
  }

  breakable {
    for (i <- 0 to 100) {
      System.out.println(i)
      if (i == 10)
        break()
    }
  }
}



