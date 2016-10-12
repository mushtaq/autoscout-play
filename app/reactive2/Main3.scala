package reactive2

import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Main3 extends App {

  val ids = List(1, 2, 3, 4)

  def getPrice(id: Int): Future[Int] = Future {
    Thread.sleep(2000)
    10 * id
  }


  val f1: Future[List[Int]] = {
    val futures: List[Future[Int]] = ids.map(getPrice)
    Future.sequence(futures)
  }

  val f2: Future[List[Int]] = Future.traverse(ids)(getPrice)

  val future1: Future[Int] = f1.map { prices =>
    prices.sum
  }

  val future2 = async {
    await(f1).sum
  }

  future1.foreach(println)
  future2.foreach(println)

  Thread.sleep(3000)
}
