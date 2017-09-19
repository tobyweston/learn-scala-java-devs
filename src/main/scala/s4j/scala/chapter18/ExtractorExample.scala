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

package s4j.scala.chapter18

import s4j.scala.chapter18.Extractors.{DiscountExtractor, UrlExtractor, YearsOfCustom}

object ExtractorExample extends App {
  val today = ""

  val customer = new Customer("Bob", "1 Church street")
  customer match {
    case Customer(name, address) => println(name + " " + address)
  }

  customer.yearsACustomer = 3
  val discount = customer match {
    case YearsOfCustom(years) if years >= 5 => Discount(0.5)
    case YearsOfCustom(years) if years >= 2 => Discount(0.2)
    case YearsOfCustom(years) if years >= 1 => Discount(0.1)
    case _ if blackFriday(today)            => Discount(0)
    case _                                  => Discount(0)
  }
  println(discount)

  val discount2 = customer match {
    case DiscountExtractor(discount) => discount
  }
  println(discount2)

  val url = "http://baddotrobot.com" match {
    case UrlExtractor(protocol, host) => println(protocol + " " + host)
  }

  def blackFriday(x: String): Boolean = true
}
