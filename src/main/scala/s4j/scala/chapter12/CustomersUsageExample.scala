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
