package s4j.scala.chatper18

class Customer(val name: String, val address: String) {
  var yearsACustomer: Int = 0
}

object Customer {
  def unapply(customer: Customer): Option[(String, String)] = Some((customer.name, customer.address))
}