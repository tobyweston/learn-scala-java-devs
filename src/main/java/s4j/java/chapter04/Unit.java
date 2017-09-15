package s4j.java.chapter04;

import java.util.concurrent.Callable;

public class Unit {

	public class DoNothing implements Callable<Void> {
		@Override
		public Void call() throws Exception {
			return null;
		}
	}

	// similar to Scala's below
	//
	// class DoNothing extends Callable[Unit] {
	// 	  def call: Unit = ()
	//}

}
