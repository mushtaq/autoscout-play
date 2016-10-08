package reactive

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive
import akka.util.Timeout
import reactive.ClientActor.AskCounter
import reactive.CounterActor.Count
import akka.pattern._

import scala.concurrent.Future
import scala.concurrent.duration._

object ClientActor {
  case object AskCounter
}

class ClientActor(counterActor: ActorRef) extends Actor {

  implicit val timeout = Timeout(100.millis)

  def receive: Receive = {
    case AskCounter =>
      counterActor ! CounterActor.NextCount
    case Count(value) =>
      println(s"client actor received counter=$value")
  }
}
