
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
    public void testSendReferenceByConstruction() {
        final TestKit testProbe = new TestKit(system);
		final ActorRef a1 = system.actorOf(FirstActor.createActor(testProbe.getRef()), "a1");
        assertEquals(a1, a1);
    }
}
