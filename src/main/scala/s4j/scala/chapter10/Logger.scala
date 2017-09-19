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

package s4j.scala.chapter10

import java.util.logging.Level

object Logger {
  def log(level: Level, string: String) {
    printf("%s %s%n", level, string)
  }
}

/* decompiler output

java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter10/Logger.class

package s4j.scala.chapter10;

import java.util.logging.Level;
import s4j.scala.chapter10.Logger$;
import scala.reflect.ScalaSignature;


public final class Logger {
    public static void log(Level level, String string) {
        Logger$.MODULE$.log(level, string);
    }
}

java -jar cfr_0_122.jar target/scala-2.12/classes/s4j/scala/chapter10/Logger\$.class

package s4j.scala.chapter10;

import java.util.logging.Level;
import scala.Predef$;
import scala.collection.Seq;
import scala.collection.mutable.WrappedArray;

public final class Logger$ {
    public static Logger$ MODULE$;

    public static {
        new s4j.scala.chapter10.Logger$();
    }

    public void log(Level level, String string) {
        Predef$.MODULE$.printf("%s %s%n", (Seq)Predef$.MODULE$.genericWrapArray((Object)new Object[]{level, string}));
    }

    private Logger$() {
        MODULE$ = this;
    }
}

*/