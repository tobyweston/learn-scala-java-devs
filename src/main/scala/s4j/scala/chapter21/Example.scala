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

import s4j.scala.chapter21.CustomerDatabase.database

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

  val customers = Set("Albert", "Beatriz", "Carol", "Dave", "Erin", "Sherlock")

  implicit def optionToCustomer(option: Option[Customer]): Customer = {
    option.orNull
  }

  implicit def optionToAddress(option: Option[Address]): Address = {
    option.orNull
  }

  implicit def optionToPostcode(option: Option[String]): String = {
    option.orNull
  }

  def generateShippingLabel_Imperatively() = {
    var label: String = null
    customers.foreach { name =>
      val customer: Customer = database.find(name)
      if (customer != null) {
        val address: Address = customer.address
        if (address != null) {
          val postcode: String = address.postcode
          if (postcode != null) {
            label = shippingLabel(customer.name, address.street, address.postcode)
          }
        }
      }
    }
    label
  }

  def generateShippingLabel_FlatMapNotClosingOverVariables(): Set[String] = {
    customers.map(name => { // map? really?
      database.find(name)
        .flatMap(customer => customer.address)
        .flatMap(address => address.postcode)
        .map(postcode => "can't ship to " + name + " as I don't know the postcode") // postcode only
    }).flatten
  }

  def generateShippingLabel_FlatMapClosingOverVariables(): Set[String] = {
    customers.flatMap {
      name =>
        database.find(name).flatMap {
          customer =>
            customer.address.flatMap {
              address =>
                address.postcode.map {
                  postcode => shippingLabel(name, address.street, postcode)
                }
            }
        }
    }
  }

  def generateShippingLabel_ForComprehension(): Set[String] = {
    for {
      name     <- customers
      customer <- database.find(name) // implicitly coverts None to empty set
      address  <- customer.address
      postcode <- address.postcode
    } yield {
      shippingLabel(name, address.street, postcode)
    }
    // what if it couldn't do a label
  }

  println("-------")
  println("1. " + generateShippingLabel_Imperatively())
  println("2. " + generateShippingLabel_FlatMapNotClosingOverVariables())
  println("3. " + generateShippingLabel_FlatMapClosingOverVariables())
  println("4. " + generateShippingLabel_ForComprehension())


  def shippingLabel(name: String, street: String, postcode: String) = {
    "\n\tShip to:\n\t" + "========\n\t" + name + "\n\t" + street + "\n\t" + postcode + "\n"
  }
}