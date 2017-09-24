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

class Customer(val name: String, val address: String) extends Ordered[Customer] {

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

package customer {

  object Example extends App {
    val customer = new Customer("", "")
    customer.add(PricedItem(2.3))
    customer.add(PricedItem(3.3))
    println("customer.total = " + customer.total)

    val discounted = new DiscountedCustomer("George", "1 Apple Street")
    discounted.add(PricedItem(2.3))
    discounted.add(PricedItem(3.3))
    println("discounted.total = " + discounted.total)
  }

}