package top

import akka.stream.scaladsl.{Keep, Sink}
import org.scalatestplus.play.PlaySpec
import utils.Config.executionContext
import utils.Config.mat

import scala.concurrent.Await
import scala.concurrent.duration._

class SquaresTest extends PlaySpec {

  val timeout = 30.seconds

  "blocking" in {
    val result = Squares.blocking(1 to 10)
    println("===============call returned================")
    println(result)
  }


  "async" in {
    val resultF = Squares.async(1 to 20)
    println("===============call returned================")
    resultF.onComplete(println)

    Await.ready(resultF, timeout)
  }


  "nonBlocking" in {
    val resultF = Squares.nonBlocking(1 to 20)
    println("===============call returned================")
    resultF.onComplete(println)

    Await.ready(resultF, timeout)
  }

  "streaming" in {
    val resultF = Squares.streaming(1 to 20).runWith(Sink.seq)
    println("===============call returned================")

    resultF.onComplete(x => println(s"---------------$x"))

    Await.ready(resultF, timeout)
  }
}
