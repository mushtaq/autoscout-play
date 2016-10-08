
val xs = List(1, 2, 3)
val ys = List("a", "b", "c")

xs.flatMap(x => ys.map(y => (x, y)))

for {
  x <- xs
  if x > 1
  y <- ys
  z = 10 + x
  if y != "b"
} yield (x, y, z)









