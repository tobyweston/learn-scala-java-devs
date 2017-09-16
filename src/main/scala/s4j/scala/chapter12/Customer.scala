package s4j.scala.chapter12

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



object TestDiscount extends App {
  val joe = new DiscountedCustomer("Joe", "128 Bullpen Street")
  joe.add(new Item {
    def price = 2.5
  })
  joe.add(new Item {
    def price = 3.5
  })
  System.out.println("Joe's basket will cost $ " + joe.total)
}


package customer {

  object Example extends App {
    val customer = new Customer("", "")
    customer.add(PricedItem(2.3))
    customer.add(PricedItem(3.3))
    println("customer.total = " + customer.total)

    val discounted = new DiscountedCustomer("George", "1 Apple Street")
    discounted.add(PricedItem(2.3))
    discounted.add(PricedItem(3.3))
    println("discounted.total = " + discounted.total)
  }

}