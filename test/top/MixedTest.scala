package top

import org.scalatestplus.play.PlaySpec
import utils.Config.executionContext

import scala.concurrent.Await
import scala.concurrent.duration._

class MixedTest extends PlaySpec {

  val timeout = 30.seconds

  "nonBlocking with async" in {

    val resultNonBlockingF = Squares.nonBlocking(1 to 20)
    println("===============nonBlocking call returned================")
    resultNonBlockingF.onComplete(x => println("non blocking result", x))

    val resultAsyncF = Squares.async(1 to 20)
    println("===============async call returned================")
    resultAsyncF.onComplete(x => println("async result", x))

    Await.ready(resultNonBlockingF, timeout)
    Await.ready(resultAsyncF, timeout)
  }

}
