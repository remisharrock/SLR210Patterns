
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import demo.*;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

public class PatternTest {
    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void testSendReferenceByMessage() {
        final TestKit testProbe = new TestKit(system);
        final ActorRef a2 = system.actorOf(SecondActor.createActor(), "a2");
        testProbe.getRef().tell(a2, ActorRef.noSender());
        ActorRef ref = testProbe.expectMsgClass(ActorRef.class);
        assertEquals(a2, ref);
    }
}
