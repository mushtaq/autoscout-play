sealed trait List[+T] {
  def ::[U >: T](x: U): List[U] = new ::(x, this)
}
case class ::[T](head: T, tail: List[T]) extends List[T]
case object Nil extends List[Nothing]

val xs = ::(1, ::(2, ::(3, Nil)))
val ys = 1 :: 2 :: 3 :: Nil

def length[T](xs: List[T]): Int = xs match {
  case Nil            => 0
  case ::(head, tail) => 1 + length(tail)
}

def reverse[T](xs: List[T]): List[T] = {
  def inner(remaining: List[T], acc: List[T]): List[T] = remaining match {
    case Nil            => acc
    case head :: tail => inner(tail, ::(head, acc))
  }

  inner(xs, Nil)
}

length(xs)

reverse(xs)
