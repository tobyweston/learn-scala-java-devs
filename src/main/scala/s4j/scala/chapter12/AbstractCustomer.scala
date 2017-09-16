package s4j.scala.chapter12

abstract class AbstractCustomer {
  def total: Double        // no implementation means it's abstract
}

class HeavilyDiscountedCustomer extends AbstractCustomer {
  private final val basket = new ShoppingBasket

  def total: Double = {
    basket.value * 0.90
  }
}