package s4j.scala.chapter09.example01

class Customer(val name: String, val address: String)

object Customer {
  val eric = new Customer("Eric", "29 Acacia Road")
}

/* decompiler output

java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter09/example01/Customer.class

package s4j.scala.chapter09.example01;

public class Customer {
  private final String name;
  private final String address;

  public static Customer eric() {
    return Customer$.MODULE$.eric();
  }

  public String name() {
    return this.name;
  }

  public String address() {
    return this.address;
  }

  public Customer(String name, String address) {
    this.name = name;
    this.address = address;
  }
}

*/