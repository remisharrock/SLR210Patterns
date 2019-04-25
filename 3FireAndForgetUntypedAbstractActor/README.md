Fire and forget is also called tell

https://doc.akka.io/docs/akka/current/actors.html#send-messages

to receive a message here is the first way:

### UntypedAbstractActor

uses `public void onReceive(Object m) throws Throwable {` and `if (m instanceof Message)`

![](img1.png)

```
title fire and forget

a->UntypedAbstractActor:Message:"hello"
space -4
note right of UntypedAbstractActor: public void onReceive(Object o) throws Throwable { \n if (o instanceof Message){ ... } \n }
```

https://sequencediagram.org/index.html#initialData=C4S2BsFMAIDMQE4wIYDsAmcD2CDmlgAoQ5AWgD4BVVYATwAdJ0BBAIwGdgFkBjYZvjgBcAWUjt2yfEIBEAC0jhwWGYXb1eMUgBZCqLMBgIQuOcGhZY0anUYsOXXv0EIh0egFdW4ED2gA3LBBMLFQAJUgeSBB-SAAKAHlWACtI8ywASmhgOQQsAHd2aAAVXILkbxgAb2gAHVRoECs4rEbUTjQoy2gxCSlIDJqAOhHoAF86hrGgA
