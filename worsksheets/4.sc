val xs = List(1, 2, 3, 4)


def fold[A, B](xs: List[A], seed: B)(f: (B, A) => B): B = {
  if(xs.isEmpty) seed
  else fold(xs.tail, f(seed, xs.head))(f)
}

fold(xs, List.empty[Int]) { (acc, elm) =>
  println(
    s"accumulator: $acc, elm: $elm, op: $elm :: $acc"
  )
  elm :: acc
}
