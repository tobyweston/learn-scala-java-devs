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

import java.net.{MalformedURLException, URL}

object Extractors {

  object YearsOfCustom {
    def unapply(customer: Customer): Option[Int] = Some(customer.yearsACustomer)
  }


  object UrlExtractor {
    def unapply(string: String): Option[(String, String)] = {
      try {
        val url = new URL(string)
        Some((url.getProtocol, url.getHost))
      } catch {
        case _: MalformedURLException => None
      }
    }
  }


  object DiscountExtractor {
    def unapply(customer: Customer): Option[Discount] = {
      if (customer.yearsACustomer >= 5) Some(Discount(0.5))
      else if (customer.yearsACustomer >= 2) Some(Discount(0.2))
      else if (customer.yearsACustomer >= 1) Some(Discount(0.1))
      else None
    }
  }

}
