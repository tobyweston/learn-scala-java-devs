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

package s4j.scala.chapter14

class GrandParent
class Parent extends GrandParent
class Child extends Parent

/*
 * contravariant parameter p
 * covariant result r
 */
trait Foo[-P, +R] {
  def f(p: P): R
}

object Bar {
  def g(foo: Foo[Parent, Parent]) = ???
}

class LiskovSubclass extends Foo[GrandParent, Child] {
  override def f(p: GrandParent): Child = ???
}

class OtherSubclass extends Foo[Child, GrandParent] {
  override def f(p: Child): GrandParent = ???
}

object Main {
  def main(args: Array[String]) {
    Bar.g(new LiskovSubclass())
//    Bar.g(new OtherSubclass()) // does not compile
  }
}