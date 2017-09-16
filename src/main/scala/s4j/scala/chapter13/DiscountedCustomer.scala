package s4j.scala.chapter13

class DiscountedCustomer(name: String, address: String) extends Customer(name, address) {

  override def total: Double = {
    super.total * 0.9
  }
}
