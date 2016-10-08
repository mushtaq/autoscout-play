import scala.annotation.tailrec
import scala.collection.mutable

def map[A, B](xs: List[A])(f: A => B): List[B] = {
  val it = xs.iterator
  var result = List.empty[B]
  while (it.hasNext) {
    result = f(it.next()) :: result
  }
  result.reverse
}

def map2[A, B](xs: List[A])(f: A => B): List[B] = {
  val it = xs.iterator
  val result = mutable.Buffer.empty[B]
  while (it.hasNext) {
    result += f(it.next())
  }
  result.toList
}

def map3[A, B](xs: List[A])(f: A => B): List[B] = {
  if(xs.isEmpty) Nil
  else f(xs.head) :: map3(xs.tail)(f)
}

def map4[A, B](xs: List[A])(f: A => B): List[B] = {
  @tailrec
  def loop(remaining: List[A], result: List[B]): List[B] = {
    if(remaining.isEmpty) result
    else loop(remaining.tail, f(remaining.head) :: result)
  }
  loop(xs, Nil).reverse
}


def square(x: Int) = x * x
map3(List(1, 2, 3, 4))(x => x * x)
map4((1 to 40000).toList)(square)

