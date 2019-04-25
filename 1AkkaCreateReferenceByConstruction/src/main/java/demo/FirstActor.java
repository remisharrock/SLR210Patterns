package demo;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class FirstActor extends AbstractActor{

	// Logger attached to actor
	private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	// Actor reference
	private ActorRef actorRef;

	public FirstActor() {}

	public FirstActor(ActorRef actorRef) {
		this.actorRef = actorRef;
		log.info("I was linked to actor reference {}", this.actorRef);
	}

	// Static function creating actor Props
	public static Props createActor(ActorRef actorRef) {
		return Props.create(FirstActor.class, () -> {
			return new FirstActor(actorRef);
		});
	}

	// We have to override this function because this
	// class extends AbstractActor
	@Override
	public Receive createReceive() {
		return receiveBuilder()
					.build();
	}

}
