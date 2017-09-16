package s4j.scala.chatper18

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
