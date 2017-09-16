package s4j.scala.chapter13

class Customer(val name: String, val address: String) extends Ordered[Customer] {

  private final val basket: ShoppingBasket = new ShoppingBasket

  def add(item: Item) {
    basket.add(item)
  }

  def total: Double = {
    basket.value
  }

  override def compare(that: Customer): Int = name.compare(that.name)

  override def toString: String = name + " $ " + total
}

object Customer {
  def create(name: String, address: String, yearsOfCustom: Int) = {
    if (yearsOfCustom > 2)
      new DiscountedCustomer(name, address)
    else
      new Customer(name, address)
  }
}