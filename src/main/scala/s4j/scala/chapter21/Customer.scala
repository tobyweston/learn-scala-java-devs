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