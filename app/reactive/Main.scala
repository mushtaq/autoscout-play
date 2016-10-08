package reactive

import akka.actor.{ActorRef, Props, ActorSystem}
import org.joda.time.DateTime
import reactive.ClientActor.AskCounter

object Main extends App {

  val xs: DateTime = DateTime.now()

  xs.toString

  val system = ActorSystem("Sony")

  system.dispatcher
  system.scheduler

//  val dd: CounterActor = new CounterActor

//  dd.update(100)

  val counterActor: ActorRef = system.actorOf(Props(new CounterActor), "counter")

  val clientActor: ActorRef = system.actorOf(Props(new ClientActor(counterActor)))

  (1 to 100).foreach(_ => clientActor ! AskCounter)

}
