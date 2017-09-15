package s4j.scala.chapter09.example03

// how to override the getter and setter

class Customer(val name: String, val address: String) {
  private var _id: String = ""

  def id = _id

  def id_=(value: String) {
    if (_id.isEmpty)
      _id = value
  }
}

/* decompiler output

java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter09/example03/Customer.class

package s4j.scala.chapter09.example03;

public class Customer {
    private final String name;
    private final String address;
    private String _id;

    public String name() {
        return this.name;
    }

    public String address() {
        return this.address;
    }

    private String _id() {
        return this._id;
    }

    private void _id_$eq(String x$1) {
        this._id = x$1;
    }

    public String id() {
        return this._id();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void id_$eq(String value) {
        if (!this._id().isEmpty()) return;
        this._id_$eq(value);
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this._id = "";
    }
}

 */

object Example {

  new Customer("Bob", "10 Downing Street").id_=("000001")

  // is the same as

  new Customer("Bob", "10 Downing Street").id = "000001"


  val bob = new Customer("Bob", "32 Bread Street")
  bob.id = "001"

  println(bob.id)               // 001

  bob.id = "002"

  println(bob.id)               // 001

}
