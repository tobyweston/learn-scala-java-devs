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