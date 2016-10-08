
try {
  1 / 0
} catch {
  case ex: ArithmeticException   => "error"
  case ex: NumberFormatException => "wrong"
}

val xs = List(1, 2, 3, 4)

xs.map {
  case x if x < 3 => x + 1
  case x          => x * x
}

val m = Map(1 -> "a", 2 -> "b")

m.map(pair => pair._1 -> s"Hello ${pair._2}")
m.map { case (key, value) => key -> s"Hello $value" }
m.map { case (key, value) => key -> s"Hello $value" }
