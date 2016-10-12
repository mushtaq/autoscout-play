import scala.util.Try

Try {
  10
}

val dd: Try[Int] = Try {
  throw new RuntimeException("asdasd")
}

dd.failed.map(_.getMessage)
