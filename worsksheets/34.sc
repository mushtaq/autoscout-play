

List(1).filter(_ > 1)
List.empty[Int].map(_ + 1)
Option(1).filter(_ > 1)
Option.empty[Int].map(_ + 1)

val xs = Option(1)
val ys = Option.empty[String]

val ddd: Option[(Int, String)] = xs.flatMap(x => ys.map(y => (x, y)))

for {
  x <- xs
  y <- ys
} yield (x, y)

