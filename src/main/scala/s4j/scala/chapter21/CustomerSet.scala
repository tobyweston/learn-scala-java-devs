package s4j.scala.chapter21

import scala.collection.mutable

class CustomerSet extends Customers {

  private val customers = mutable.Set[Customer]()

  def add(customer: Customer) = customers.add(customer)

  def find(name: String): Option[Customer] = {
    for (customer <- customers) {
      if (customer.name == name)
        return Some(customer)
    }
    None
  }

  def findOrNull(name: String): Customer = {
    for (customer <- customers) {
      if (customer.name == name)
        return customer
    }
    null
  }

  def findOrThrow(name: String): Customer = {
    for (customer <- customers) {
      if (customer.name == name)
        return customer
    }
    throw new NotFoundException(name)
  }

  def iterator: Iterator[Customer] = customers.iterator
}

class NotFoundException(name: String) extends Exception(name)