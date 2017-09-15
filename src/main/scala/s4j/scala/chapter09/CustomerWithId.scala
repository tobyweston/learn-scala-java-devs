package s4j.scala.chapter09.example02

class Customer(val name: String, val address: String) {
  var id = ""
}

/* decompiler output

java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter09/example02/Customer.class

package s4j.scala.chapter09.example02;

public class Customer {
    private final String name;
    private final String address;
    private String id;

    public String name() {
        return this.name;
    }

    public String address() {
        return this.address;
    }

    public String id() {
        return this.id;
    }

    public void id_$eq(String x$1) {
        this.id = x$1;
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.id = "";
    }
}
 */

object Example {

  new Customer("Bob", "10 Downing Street").id_=("000001")

  // is the same as

  new Customer("Bob", "10 Downing Street").id = "000001"

}