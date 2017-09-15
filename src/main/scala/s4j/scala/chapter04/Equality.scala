package s4j.scala.chapter04

object Equality {

  new String("A") == new String("A")        // true in scala, false in java
  new String("B").equals(new String("B"))   // true in scala and java

  new String("A") eq new String("A")        // false in scala
  new String("B") == new String("B")        // false in java

}
