
name := "scala-for-java-devs"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

logLevel := Level.Error

scalacOptions := Seq("-Xlint", "-deprecation", "-feature", "-language:postfixOps")
