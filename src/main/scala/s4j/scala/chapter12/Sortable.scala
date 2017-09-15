
package s4j.scala.chapter12

trait Sortable[A <: Ordered[A]] extends Iterable[A] {
  def sort: Seq[A] = {
    this.toList.sorted
  }
}


object SortableExample extends App {
  val customers = new Customers()
  customers.add(new Customer("Fred Jones", "8 Tuna Lane,"))
  customers.add(new Customer("Velma Dinkley", "316 Circle Drive"))
  customers.add(new Customer("Daphne Blake", "101 Easy St"))
  customers.add(new DiscountedCustomer("Norville Rogers", "12 Maple Street"))
  println(customers.sort.mkString("\n"))
}

object CustomersUsageExample extends App {
  val customers = new CustomersSortableBySpend()

  val fred = new Customer("Fred Jones", "8 Tuna Lane,")
  val velma = new Customer("Velma Dinkley", "316 Circle Drive")
  val daphne = new Customer("Daphne Blake", "101 Easy St")
  val norville = new DiscountedCustomer("Norville Rogers", "12 Maple Street")

  daphne.add(PricedItem(2.4))
  daphne.add(PricedItem(1.4))
  fred.add(PricedItem(2.75))
  fred.add(PricedItem(2.75))
  norville.add(PricedItem(6.99))
  norville.add(PricedItem(1.50))

  customers.add(fred)
  customers.add(velma)
  customers.add(daphne)
  customers.add(norville)

  println(customers.sort.mkString("\n"))

}