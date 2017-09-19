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

package s4j.scala.chapter17

import s4j.scala.chapter12.{Customer, ShoppingBasket}
import s4j.scala.chapter17.ThreadExample._

object ThreadExample {

  def runInThread(function: () => Unit) {
    new Thread() {
      override def run(): Unit = function() // aka function.apply()
    }.start()
  }

  def runInThread2(function: => Unit) {     // call-by-name
    new Thread() {
      override def run(): Unit = function   // not function()
    }.start()
  }

  def runInThread3(group: String, function: => Unit) {
    new Thread(new ThreadGroup(group), () => function).start()
  }

  def runInThread4(group: String)(function: => Unit) {
    new Thread(new ThreadGroup(group), () => function).start()
  }

  def main(args: Array[String]) {
    runInThread(() => {
      // some long running task
      println("Hello function")
    })

    runInThread2 {
      println("Hello Lazy val")
    }
  }
}

/*
 a class representing some kind of UI with 'update' methods
 to update itself
*/
class UI {

  def updateUiElements() {
    new Thread() {
      override def run(): Unit = updateCustomerBasket(basket)
    }.start()

    new Thread() {
      override def run(): Unit = updateOffersFor(customer)
    }.start()

    // more updates, all done in their own threads
  }

  def updateUiElements2() {
    runInThread(() => updateCustomerBasket(basket))
    runInThread(() => updateOffersFor(customer))
    // more updates, all done in their own threads
  }

  def updateUiElements3() {
    runInThread { () =>
      updateCustomerBasket(basket)
    }
    runInThread { () =>
      updateOffersFor(customer)
    }
    // more updates, all done in their own threads
  }

  def updateUiElementsX() {
    runInThread(() => {
      applyDiscountToBasket(basket)
      updateCustomerBasket(basket)
    })
    runInThread(() => updateOffersFor(customer))
    // more updates, all done in their own threads
  }

  def updateUiElements4() {
    runInThread2 {
      applyDiscountToBasket(basket)
      updateCustomerBasket(basket)
    }
    runInThread2 {
      updateOffersFor(customer)
    }
    // more updates, all done in their own threads
  }

  def updateUiElements5() {
    runInThread3("basket", {
      applyDiscountToBasket(basket)
      updateCustomerBasket(basket)
    })
    runInThread3("customer",
      updateOffersFor(customer)
    )
    // more updates, all done in their own threads
  }

  def updateUiElements6() {
    runInThread4("basket") {
      applyDiscountToBasket(basket)
      updateCustomerBasket(basket)
    }
    runInThread3("customer",
      updateOffersFor(customer)
    )
    // more updates, all done in their own threads
  }

  def applyDiscountToBasket(basket: ShoppingBasket) {}
  def updateCustomerBasket(basket: ShoppingBasket) {}
  def updateOffersFor(customer: Customer) {}

  private val basket = new ShoppingBasket()
  private val customer = new Customer("", "")
}
