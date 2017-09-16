
package s4j.scala.chapter13

import java.io._
import java.net.{MalformedURLException, URL}


object Exceptions extends App {

  autocloseExample()

  def example2() = try {
    val url = new URL("http://baddotrobot.com")
    val reader = new BufferedReader(new InputStreamReader(url.openStream))
    try {
      var line = reader.readLine
      while (line != null) {
        line = reader.readLine
        println(line)
      }
    } finally {
      reader.close()
    }
  } catch {
    case _: MalformedURLException => System.out.println("Bad URL")
    case e: IOException => System.out.println("Problem reading data from the web: " + e.getMessage)
  }

  def autoclose[A, B <: Closeable](resource: B)(f: => A): A =
    try {
      f
    } finally {
      resource.close()
    }

  def autocloseExample() = {
    try {
      val url = new URL("http://baddotrobot.com")
      val reader = new BufferedReader(new InputStreamReader(url.openStream))
      autoclose(reader) {
        var line = reader.readLine
        while (line != null) {
          line = reader.readLine
          println(line)
        }
      }
    } catch {
      case _: MalformedURLException => System.out.println("Bad URL")
      case e: IOException => System.out.println("Problem reading data from the web: " + e.getMessage)
    }
  }

  def try_[A, B <: Closeable](resource: B)(f: B => A): A =
    try {
      f(resource)
    } finally {
      resource.close()
    }

  def autocloseExample2() = {
    try {
      val url = new URL("http://baddotrobot.com")
      try_(new BufferedReader(new InputStreamReader(url.openStream))) {
        reader => {
          var line = reader.readLine
          while (line != null) {
            line = reader.readLine
            println(line)
          }
        }
      }
    } catch {
      case _: MalformedURLException => System.out.println("Bad URL")
      case e: IOException => System.out.println("Problem reading data from the web: " + e.getMessage)
    }
  }

}