
name := "scala-for-java-devs"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.12.3",
  "org.scala-lang" % "scala-compiler" % "2.12.3",
  "org.scala-lang" % "scala-reflect" % "2.12.3"
)

logLevel := Level.Error