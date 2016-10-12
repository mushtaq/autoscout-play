package reactive2

import scala.concurrent.{Await, Future}
import concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationDouble

object Main1 extends App {

  val f1: Future[Int] = Future {
    Thread.sleep(2000)
    10
  }

  val f3: Future[Int] = Future {
    Thread.sleep(2000)
    throw new RuntimeException("thrown excpetion")
  }

  val f2 = f1.map(_ + 1)

  f1.foreach(println)
  f2.foreach(println)

  val f4: Future[Int] = f3.recover {
    case x: RuntimeException => 0
  }

  f4.foreach(println)


  println("**************", f4)

  Thread.sleep(6000)
}
