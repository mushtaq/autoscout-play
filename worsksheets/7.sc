
val keys = List(1, 2)

123 :: keys

keys :+ 123


val map = Map(1 -> "a", 2 -> "b", 3 -> "c")

keys.map(map)

keys.map(key => map.apply(key))

map + (4 -> "d")

val set = Set(2, 3)

set + 77
