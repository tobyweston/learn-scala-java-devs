package s4j.scala.chapter12

import scala.collection.mutable

class Customers extends Sortable[Customer] {
  private val customers = mutable.Set[Customer]()
  def add(customer: Customer) = customers.add(customer)
  def iterator: Iterator[Customer] = customers.iterator
}
