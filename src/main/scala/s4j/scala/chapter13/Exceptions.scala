
/*
 * Copyright (c) 2015-2017 Toby Weston
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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