package s4j.scala.chapter12

class CustomersSortableBySpend extends Customers {

  // no longer needed since Scala 2.12
  implicit def functionToOrdering[A](f: (A, A) => Int): Ordering[A] = {
    new Ordering[A] {
      def compare(a: A, b: A) = f.apply(a, b)
    }
  }

  override def sort: List[Customer] = {
    this.toList.sorted((a: Customer, b: Customer) => b.total.compare(a.total))
  }
}
