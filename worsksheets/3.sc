
val xs = List(1, 2, 3, 4)

xs.foldLeft(List.empty[Int])((acc, elm) => elm :: acc)

xs.reduceLeft((acc, elm) => if(acc > elm) acc else elm)


def fold[A, B](xs: List[A], seed: B)(f: (B, A) => B): B = {
  if(xs.isEmpty) seed
  else fold(xs.tail, f(seed, xs.head))(f)
}

def reduce[A](xs: List[A], f: (A, A) => A): A =
  fold(xs, xs.head)(f)

def reduce1[A](xs: List[A])(f: (A, A) => A): A =
  fold(xs, xs.head)(f)

reduce(xs, {(acc: Int, elm: Int) => if(acc > elm) acc else elm})
reduce1(xs)((acc, elm) => if (acc > elm) acc else elm)

def maxInt(a: Int, b: Int) = if(a > b) a else b

reduce(xs, maxInt)


fold(xs, List.empty[Int])((acc, elm) => elm :: acc)
