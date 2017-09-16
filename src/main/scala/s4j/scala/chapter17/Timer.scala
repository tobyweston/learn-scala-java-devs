package s4j.scala.chapter17

import java.util.Date

object TimerExample {
  
  def exampleTimer() = {
    val timer = new NaiveTimer()
    timer.start()
    someLongRunningTask()
    val time = timer.stop()
    println("process took " + time + "ms")
  }

  def anotherExampleTimer() = {
    val timer = Timer()
    timer.time {
      someLongRunningTask()
      null
    }
    println("process took " + timer + "ms")
  }

  def yetAnotherExampleTimer() = {
    val timer = Timer()
    timer.time(() => {
      someLongRunningTask()
    })
    println("process took " + timer + "ms")
  }

  def someLongRunningTask() = Thread.sleep(1000)
}

class NaiveTimer {
  private var startDate: Date = null

  def start() = startDate = new Date

  def stop(): Long = new Date().getTime - startDate.getTime
}

object Timer {
  def apply() = new Timer()
}

class Timer {

  private val start = new Date

  def time(function: () => Unit) {
    try {
      function.apply()
    } finally {
      new Date().getTime - start.getTime
    }
  }
  
}