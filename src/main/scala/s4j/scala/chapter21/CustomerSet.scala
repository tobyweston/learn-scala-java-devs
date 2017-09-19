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