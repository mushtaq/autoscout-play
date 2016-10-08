import data.Data.books

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
books
  .groupBy(_.author)
  .mapValues(_.foldLeft(0.0)((total, book) => total + book.basePrice))
  .toSeq
  .sortBy(-_._2)
  .slice(0, 2)

books
  .groupBy(_.author)
  .mapValues(_.map(_.basePrice).sum)
  .toSeq
  .sortBy(-_._2)
  .take(2)
