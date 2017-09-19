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

class Animal
trait HasWings extends Animal
trait Bird extends HasWings
trait HasFourLegs extends Animal
class FlyingHorse extends Animal with Bird with HasFourLegs


package linearization {

  import scala.reflect.runtime.universe._

  object Example extends App {
    typeOf[FlyingHorse].baseClasses.reverse foreach { s => println(s"[${s.name}]") }
  }

  /*
    [Any]
    [Object]
    [Animal]
    [HasWings]
    [Bird]
    [HasFourLegs]
    [FlyingHorse]
  */


}