package top

import akka.NotUsed
import akka.stream.scaladsl.Source

import scala.concurrent.Future
import utils.Config.executionContext

object Squares {

  def blocking(numbers: Seq[Int]): Seq[Int] = {
    val squares = numbers.map(n => Square.blocking(n))

    squares
  }

  def async(numbers: Seq[Int]): Future[Seq[Int]] = {
    val futures = numbers.map(n => Square.async(n))

    Future.sequence(futures)
  }

  def nonBlocking(numbers: Seq[Int]): Future[Seq[Int]] = {
    val futures = numbers.map(n => Square.nonBlocking(n))

    Future.sequence(futures)
  }

  def streaming(numbers: Seq[Int]): Source[Int, NotUsed] = {
    val numberStream = Source(numbers.toList)

    numberStream.mapAsync(10)(Square.nonBlocking)
  }
}
