package s4j.scala.chapter12

import scala.collection.mutable

class ShoppingBasket {

  private val basket = mutable.HashSet[Item]()

  def add(items: Item*) {
    for (item <- items)
      basket.add(item)
  }

  def value: Double = {
    basket.map(_.price).sum
  }

}
