package reactive

import akka.actor.{SupervisorStrategy, Actor}
import akka.actor.Actor.Receive
import reactive.CounterActor.{Count, NextCount}

object CounterActor {

  case object NextCount
  case class Count(value: Int)
}

class CounterActor extends Actor {

  private var counter = 0

  def update(v: Int) = counter += v

  def receive: Receive = {
    case NextCount =>
      counter = counter + 1
      sender() ! Count(counter)
  }
}

