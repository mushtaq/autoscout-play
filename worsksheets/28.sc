
trait Ord[T] {
  def lt(other: T): Boolean
}

def insert[T <: Ord[T]](x: T, xs: List[T]): List[T] = xs match {
  case Nil                      => List(x)
  case head :: tail if x.lt(head) => x :: xs
  case head :: tail             => head :: insert(x, tail)
}

def sort[T <: Ord[T]](xs: List[T]): List[T] = xs match {
  case Nil          => Nil
  case head :: tail => insert(head, sort(tail))
}

sort(List(1, 2, 3, 4, 5, 4))


