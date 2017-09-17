package s4j.scala.chapter21

case class Customer(name: String, address: Option[Address]) extends Ordered[Customer] {
  private final val basket: ShoppingBasket = new ShoppingBasket

  def add(item: Item) {
    basket.add(item)
  }

  def total: Double = {
    basket.value
  }

  override def compare(that: Customer): Int = name.compare(that.name)
  override def toString: String = name + " $ " + total
}

//object Customer {
//  def unapply(customer: Customer): Option[(String, Option[Address])] = {
//    if (customer == null) None else Some(customer.name, customer.address)
//  }
//}