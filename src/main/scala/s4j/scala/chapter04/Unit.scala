package s4j.scala.chapter04

import java.util.concurrent.Callable

object Unit {

  // () is the single instance of the type Unit
  val example: Unit = ()


  // similar to java's Void
  //
  // public class DoNothing implements Callable<Void> {
  //   @Override
  //   public Void call() throws Exception {
  //     return null;
  //   }
  // }

  class DoNothing extends Callable[Unit] {
    def call: Unit = ()
  }
}
