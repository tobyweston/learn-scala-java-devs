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

package s4j.scala.chapter09

class Customer(val name: String, val address: String)

package example1 {

  object Customer {
    val eric = new Customer("Eric", "29 Acacia Road")
  }
  
  /* decompiler output
  
  java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter09/example1/Customer.class
  
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
}


package example2 {
  class Customer(val name: String, val address: String) {
    var id = ""
  }

  /* decompiler output
  
  java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter09/example2/Customer.class
  
  package s4j.scala.chapter09.example2;
  
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
}

package example3 {
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
  
  java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter09/example3/Customer.class
  
  package s4j.scala.chapter09.example3;
  
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

    bob.id = "02"
    println(bob.id)               // 001
  }
}