package reactive

import scala.RuntimeException
import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

object Four extends App {

  def x = {Thread.sleep(5000); 100}

  val f: Future[Int] = Future {
    x
  }

  val successful: Future[Int] = Future.successful(100)
  val failed: Future[Int] = Future.failed(new RuntimeException)

  Thread.sleep(10000)

  f.onComplete {
    case Success(x) =>
    case Failure(ex) =>
  }

  f.onFailure {
    case ex: NumberFormatException =>
    case ex: ArithmeticException =>
  }

  f.onSuccess {
    case value =>
  }



  val dd = f.recover {
    case ex: RuntimeException => 100
  }

  val ee = f.recoverWith {
    case ex: RuntimeException => Future.successful(100)
  }




}
