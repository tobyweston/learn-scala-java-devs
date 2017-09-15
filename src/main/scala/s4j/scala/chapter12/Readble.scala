
package s4j.scala.chapter12

import java.io.File
import java.nio.CharBuffer

trait Readable {
  def read(buffer: CharBuffer): Int
}

class FileReader(file: File) extends Readable with AutoCloseable {
  def read(buffer: CharBuffer): Int = {
    val linesRead: Int = 0
    linesRead
  }

  def close(): Unit = ???

}

object FileReader extends App {
  val reader = new FileReader(new File("autoexec.bat"))
  reader.read(CharBuffer.allocate(100))
}
