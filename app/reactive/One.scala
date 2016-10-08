package reactive
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.async.Async._

object One extends App {
  val f3 = Future { Thread.sleep(1000); 30 }

  val f1 = Future {
    Thread.sleep(1000); 20
  }

  val f2 = Future {
    Thread.sleep(1000); 10
  }

  val ddd: Future[Int] = f2.flatMap { v1 =>
    f1.map { case v2 =>
      v1 + v2
    }
  }

  val eee: Future[Int] = for {
    v1 <- f2
    v2 <- f1
  } yield v1 + v2

  val fff: Future[Int] = async {
    val v1 = await(f1)
    val v2 = await(f2)

    if(v1 > 10) {
      v1 + v2
    }
    else {
      throw new RuntimeException
    }
  }

  fff.onComplete(println)

  Thread.sleep(10000)
}
