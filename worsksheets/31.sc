import play.api.libs.json.{JsArray, Json}

val xs = List(2, 3, 1, 6)

xs.sorted

xs.min

Json.toJson(xs).as[List[Int]]


Seq(2, 3, 1, 6).map(_ + 1)
Map(2 -> "a", 3 -> "b").map { case (k, v) => k -> "Hello $v"}
Map(2 -> "a", 3 -> "b").map { case (k, v) => v -> (k * k)}


