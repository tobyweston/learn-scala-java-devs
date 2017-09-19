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

package s4j.java.chapter11;

import static s4j.java.chapter11.WaitFor.waitFor;

@SuppressWarnings("all")
class Examples {

	void anonymousClass() throws InterruptedException {
		final Server server = new HttpServer();
		waitFor(new Condition() {
			@Override
			public Boolean isSatisfied() {
				return !server.isRunning();
			}
		});
	}

	void closure() throws InterruptedException {
		Server server = new HttpServer();
		waitFor(() -> !server.isRunning());
	}

	void lambda() throws InterruptedException {
		Server httpServer = new HttpServer();
		waitFor(server -> !server.isRunning(), httpServer);
	}
}

interface Condition {
	Boolean isSatisfied();
}

interface ServerCondition {
	Boolean isSatisfied(Server server);
}

interface Server {
	boolean isRunning();
}

class HttpServer implements Server {
	@Override
	public boolean isRunning() {
		return false;
	}
}

class WaitFor {
	static void waitFor(Condition condition) throws InterruptedException {
		while (!condition.isSatisfied())
			Thread.sleep(250);
	}

	static void waitFor(ServerCondition condition, Server server) throws InterruptedException {
		while (!condition.isSatisfied(server))
			Thread.sleep(250);
	}

}
