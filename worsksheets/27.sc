

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case Nil                      => List(x)
  case head :: tail if x < head => x :: xs
  case head :: tail             => head :: insert(x, tail)
}

def sort(xs: List[Int]): List[Int] = xs match {
  case Nil          => Nil
  case head :: tail => insert(head, sort(tail))
}

sort(List(1, 2, 3, 4, 5, 4))


