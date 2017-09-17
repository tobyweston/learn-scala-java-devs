package s4j.scala.chapter21

trait Customers extends Iterable[Customer] {
  def add(Customer: Customer)
  def find(name: String): Option[Customer]
  def findOrNull(name: String): Customer
}

object Customers {
  def apply() = new CustomerSet()
}
