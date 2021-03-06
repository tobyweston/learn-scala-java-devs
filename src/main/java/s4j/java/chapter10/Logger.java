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

package s4j.java.chapter10;

import java.util.logging.Level;

import static java.util.logging.Level.INFO;

public final class Logger {

	private static final Logger INSTANCE = new Logger();

	private Logger() { }

	public static Logger getLogger() {
		return INSTANCE;
	}

	public void log(Level level, String string) {
		System.out.printf("%s %s%n", level, string);
	}

	public static void main(String... args) {
		Logger.getLogger().log(INFO, "Everything is fine.");
	}
}
