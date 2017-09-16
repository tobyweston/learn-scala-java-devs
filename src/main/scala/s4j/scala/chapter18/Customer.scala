package s4j.scala.chapter18

class Customer(val name: String, val address: String) {
  var yearsACustomer: Int = 0
}

object Customer {
  def unapply(customer: Customer): Option[(String, String)] = Some((customer.name, customer.address))
}