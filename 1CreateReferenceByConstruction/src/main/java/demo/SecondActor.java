package demo;

import akka.actor.Props;
import akka.actor.AbstractActor;

public class SecondActor extends AbstractActor {

	// Empty Constructor
	public SecondActor() {}

	// Static function that creates an actor Props
	public static Props createActor() {
		return Props.create(SecondActor.class, () -> {
			return new SecondActor();
		});
	}
	
	// Empty createReceive function
	// We have to override this function because this
	// class extends AbstractActor
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.build();
	}
}
