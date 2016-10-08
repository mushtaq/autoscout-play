import scala.collection.mutable

List(9).exists(_ > 2)
List(9).forall(_ > 2)
List.empty[Int].exists(_ > 2)
List.empty[Int].forall(_ > 2)
Option(9).exists(_ > 2)
Option(9).forall(_ > 2)
Option.empty[Int].exists(_ > 2)
Option.empty[Int].forall(_ > 2)
val xs = List(1, 2, 3, 4)

{
  import collection.JavaConverters._
  val javaC = xs.asJava
  println(javaC)
  javaC.asScala
}

{
  import collection.JavaConversions._
  val ys: java.util.List[Int] = xs
  val zs: mutable.Buffer[Int] = ys
}

