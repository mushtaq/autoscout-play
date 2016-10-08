package mushtaq

trait Ord[T] {
  def lt(a: T, b: T): Boolean
}

object Ord {

  def apply[T](implicit x: Ord[T]) = x

  implicit val intOrd: Ord[Int] = new Ord[Int] {
    def lt(a: Int, b: Int) = a < b
  }

  implicit val strOrd: Ord[String] = new Ord[String] {
    def lt(a: String, b: String) = a < b
  }

  implicit def optOrd[T](implicit ord: Ord[T]): Ord[Option[T]] = new Ord[Option[T]] {
    def lt(a: Option[T], b: Option[T]) = (a, b) match {
      case (Some(x), Some(y)) => ord.lt(x, y)
      case (None, None)       => true
      case (_, None)          => false
      case (None, _)          => true
    }
  }

  implicit def tupleOrd[T1, T2](implicit ord1: Ord[T1], ord2: Ord[T2]): Ord[(T1, T2)] = new Ord[(T1, T2)] {
    def lt(a: (T1, T2), b: (T1, T2)) =
      if (ord1.lt(a._1, b._1)) true
      else if (ord1.lt(b._1, a._1)) false
      else ord2.lt(a._2, b._2)
  }



}
