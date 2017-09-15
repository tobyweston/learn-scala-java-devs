package s4j.scala.chapter10

package example1 {

  class Customer(forename: String, initial: String, surname: String) {

    // primary constructor
    val fullname = String.format("%s %s. %s", forename, initial, surname)

    // auxiliary constructor
    def this(forename: String, surname: String) {
      this(forename, "", surname)
    }
  }

}

package example2 {

  class Customer(forename: String, initial: String = "", surname: String) {

    // primary constructor
    val fullname = if (initial != null && !initial.isEmpty)
      forename + " " + initial + ". " + surname
    else
      forename + " " + surname
  }

}