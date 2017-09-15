package s4j.scala.chapter03

object Variables {

  val immutable: String = "Scala"     // immutable can not be reassigned

  var language: String = "Java"
  language = "Scala"                  // var can be reassigned

  val age = 35
  var maxHeartRate = 210 - age * .5   // maxHeartRate: Double = 191.5

}
