package s4j.java.chapter11;

import static s4j.java.chapter11.WaitFor.waitFor;

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
