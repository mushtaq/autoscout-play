package reactive

import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Promise, Future}
import scala.util.{Failure, Success}

object Three extends App {

  def map[A, B](future: Future[A])(f: A => B): Future[B] = {
    val promise = Promise[B]()

    future.onComplete {
      case Success(value) => promise.success(f(value))
      case Failure(ex)    => promise.failure(ex)
    }

    promise.future
  }

  def sequence[T](xs: List[Future[T]]): Future[List[T]] = {
    xs.foldLeft(Future.successful(List.empty[T])) { (futureOfList, future) =>
      for {
        list <- futureOfList
        value <- future
      } yield value :: list
    }.map(_.reverse)
  }

  def sequence1[T](xs: List[Future[T]]): Future[List[T]] = async {
    val it = xs.iterator
    var result = List.empty[T]

    while (it.hasNext) {
      val value = await(it.next())
      result = value :: result
    }

    result.reverse
  }

  sequence(List(Future(1), Future(2), Future(3))).onComplete(println)

  Thread.sleep(10000)
}
