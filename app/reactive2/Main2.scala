package reactive2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import async.Async._

object Main2 extends App {

  val f1: Future[Int] = Future {
    Thread.sleep(2000)
    10
  }

  val f2: Future[Int] = Future {
    Thread.sleep(2000)
    20
  }

  val f3: Future[Int] = f1.flatMap { v1 =>
    f2.map { v2 =>
      v1 + v2
    }
  }

  val f4 = for {
    v1 <- f1
    v2 <- f2
  } yield v1 + v2

  val f5 = async {
    val v1 = await(f1)
    val v2 =  await(f2)
    v1 + v2
  }

  val f6 = async {
    await(f1) + await(f2)
  }

  f3.foreach(println)
  f4.foreach(println)
  f5.foreach(println)

  Thread.sleep(3000)
}
