
package s4j.scala.chapter13

object Do extends App {
  var i = 0
  do {
    println(i)
    i += 1
  } while (i < 10)
}

object DoWithFor extends App {
  var i = 0
  do {
    for (j <- 0 to i)
      print("*")
    print("\n")
    i += 1
  } while (i < 10)
}

object While extends App {
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
}

object ForAsAWhile extends App {
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
}

object For extends App {
  for (i <- 0 to 10) {
    println(i)
  }

  (0 to 10).foreach(i => println(i))
  (0 to 10).foreach(println(_))

}





