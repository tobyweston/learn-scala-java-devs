package s4j.scala.chapter08

object Declarative {

  // typical imperative loop in java
  //
  // for (int count = 0; count < 100; count++) {
  //    System.out.println(count);
  // }

  // declarative scala
  (0 to 100).foreach(println(_))

  // declarative java version
  //
  // IntStream.range(0, 100).forEach(System.out::println)

}
