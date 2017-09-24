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

import java.lang

class CustomersSortableBySpend extends Customers {

  // no longer needed since Scala 2.12
  implicit def functionToOrdering[A](f: (A, A) => Int): Ordering[A] = {
    new Ordering[A] {
      def compare(a: A, b: A) = f.apply(a, b)
    }
  }

  override def sort: List[Customer] = {
    // in Scala 2.12 the anonymous class can be converted into a single abstract method (SAM)
    this.toList.sorted(new Ordering[Customer]() {
      override def compare(a: Customer, b: Customer) = b.total.compare(a.total)
    })

    // and so, lambda syntax can be used without the implicit function above
    this.toList.sorted((a: Customer, b: Customer) => b.total.compare(a.total))
  }

  // however, not in all cases:

  def javaExample(item: s4j.java.chapter12.Item) = ???
  def scalaExample(item: s4j.scala.chapter12.Item) = ???

  // this Java example can be converted into a SAM
  javaExample(new s4j.java.chapter12.Item {
    override def price(): lang.Double = 23.4D
  })
  // and so lambda syntax can be used
  javaExample(() => 23.4D)

  // but this scala example, can not
  scalaExample(new s4j.scala.chapter12.Item {
    override def price(): Double = 23.4D
  })
  // scalaExample(() => 23.4D)    // compiler failure

}
