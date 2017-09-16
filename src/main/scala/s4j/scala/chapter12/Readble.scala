
package s4j.scala.chapter12

import java.nio.CharBuffer

trait Readable {
  def read(buffer: CharBuffer): Int
}
