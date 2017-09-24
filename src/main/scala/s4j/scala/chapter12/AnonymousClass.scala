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

object AnonymousClass extends App {

  val joe = new DiscountedCustomer("Joe", "128 Bullpen Street")

  // example of anonymous class
  joe.add(new Item {
    def price = 2.5
  })
  joe.add(new Item {
    def price = 3.5
  })
  println("Joe's basket will cost $ " + joe.total)

}







