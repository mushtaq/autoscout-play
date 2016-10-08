package reactive

import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Two extends App {

  val numbers = List(1, 2, 3, 4)


  val listOfFutures: List[Future[Int]] = numbers.map { n =>
    Future(n)
  }

  val futureOfList: Future[List[Int]] = Future.sequence(listOfFutures)

  val squareF: Future[Int] = async {
    val list = await(futureOfList)
    list.sum
  }



  squareF.onComplete(println)

  Thread.sleep(10000)
}
