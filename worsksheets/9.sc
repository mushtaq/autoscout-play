
def reduceByKey[K, V](xs: List[(K, V)])(f: (V, V) => V): List[(K, V)] = {

  val it = xs.iterator
  var result = Map.empty[K, V]

  while (it.hasNext) {

    val pair = it.next()
    val key = pair._1
    val value = pair._2

    val existingValue = result.get(key)
    if(existingValue.isDefined) {
      result = result + (key -> f(existingValue.get, value))
    } else {
      result = result + pair
    }
  }

  result.toList


}


val xs = List("a" -> 1, "b" -> 1, "c" -> 1, "b" -> 1, "c" -> 1)
reduceByKey(xs)((acc, elm) => acc + 1)
