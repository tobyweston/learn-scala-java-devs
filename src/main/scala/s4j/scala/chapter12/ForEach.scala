
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

package s4j.scala.chapter12

import scala.collection._


trait Enumerable[A] extends Iterable[A] {

  def enumerate(function: A => Unit) = {
    for (e <- this)
      function.apply(e)
  }

}

class EnumerableCustomers extends Enumerable[Customer] {
  private val customers = mutable.Set[Customer]()
  def add(customer: Customer) = customers.add(customer)
  def iterator: Iterator[Customer] = customers.iterator
}

class ThreadSafeCustomers extends EnumerableCustomers {

  override def add(customer: Customer): Boolean = {
    this.synchronized {
      super.add(customer)
    }
  }

  override def enumerate(function: Customer => Unit): Unit = {
    this.synchronized {
      super.enumerate(function)
    }
  }
}



object ExampleCustomers extends App {
  val customers = new ThreadSafeCustomers()
  val daphne: Customer = new Customer("Daphne Blake", "101 Easy St")
  val fred: Customer = new Customer("Fred Jones", "8 Tuna Lane,")
  val norville: Customer = new DiscountedCustomer("Norville Rogers", "12 Maple Street")
  val velma: Customer = new Customer("Velma Dinkley", "316 Circle Drive")

  daphne.add(PricedItem(2.4))
  daphne.add(PricedItem(1.4))
  fred.add(PricedItem(2.75))
  fred.add(PricedItem(2.75))
  norville.add(PricedItem(6.99))
  norville.add(PricedItem(1.50))

  customers.add(daphne)
  customers.add(fred)
  customers.add(norville)
  customers.add(velma)
  customers.enumerate(customer => println(customer.name + " total $ " + customer.total))

  class Customers extends Sortable[Customer] {
    private val customers = mutable.Set[Customer]()
    def add(customer: Customer) = customers.add(customer)
    def iterator: Iterator[Customer] = customers.iterator
  }
}


