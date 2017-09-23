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

package s4j.scala.chapter20

import s4j.scala.chapter20.CustomerDatabase.database

object CustomerDatabase {
  val database = new CustomerSet()

  val customerA = Customer("Albert", Some(Address("1a Bridge St", None)))
  val customerB = Customer("Beatriz", None)
  val customerC = Customer("Carol", Some(Address("2a Finsbury Circus", Some("AL1 2PY"))))
  val customerD = Customer("Sherlock", Some(Address("21b Baker Street", Some("NW1 6XE"))))

  customerA.add(PricedItem(10))
  customerA.add(PricedItem(5))
  customerC.add(PricedItem(10))

  database.add(customerA)
  database.add(customerB)
  database.add(customerC)
  database.add(customerD)
}

object Example extends App {

  // null case
  val albert = database.findOrNull("Albert")
  val basket = if (albert != null) albert.total else 0D

  // map over option
  val exists = database.find("Albert").map(customer => "customer exists")
  val basketValue = database.find("Albert").map(customer => customer.total).getOrElse(0D) // forced to handle the else? get would throw


  val customers = Set("Albert", "Beatriz", "Carol", "Dave", "Erin", "Sherlock")

  def sumCustomerBaskets_NulLCheckVersion() = {
    // all.map(customers.findOrNull).map(_.total).sum // throws NPE
    // or
    customers.map(database.findOrNull).map(customer => if (customer != null) customer.total else 0D).sum
  }

  def sumCustomerBaskets_NulLAvoidingPatternMatch() = {
    customers.map(database.findOrNull(_) match {
      case customer@Customer(_, _) => customer.total // why no if customer != null clause? it matches on null below
      case a @ _                   => println(a); 0D
    }).sum
  }

  def sumCustomerBaskets_MapCouldThrowAnException() = {
    // all.map(customers.find(_)).map(customer => customer.get.total) // could throw an exception
    // customers.find("Missing").map(customer => customer.total).get  // throws an exception
    database.find("Missing") match {
      case Some(customer) => customer.total
      case None           => 0D
    }
  }

  def sumCustomerBaskets_MapThenFlattenVersion() = {
    customers.map(database.find(_).map(_.total)).flatten.sum
  }

  def sumCustomerBaskets_FlatMapVersion() = {
    customers.flatMap(name => database.find(name)).map(customer => customer.total).sum
  }


  val partial: Set[Option[Customer]] = customers.map(database.find)

  println("1. " + sumCustomerBaskets_NulLCheckVersion())
  println("2. " + sumCustomerBaskets_NulLAvoidingPatternMatch()) // yuk!
  println("3. " + sumCustomerBaskets_MapCouldThrowAnException())
  println("4. " + sumCustomerBaskets_MapThenFlattenVersion())
  println("5. " + sumCustomerBaskets_FlatMapVersion())

}