
object C extends (Int => B){
  private var x = 0
  def apply(x: Int) = new B(x)
}

case class B(x: Int) {
  def m = C.x
}

List(1, 2, 3, 4).map(B)


new B(10)
B(10)

object A {
  def hello = "asdasd"
  var x = 10
}


A.hello
A.x
A.x = 1001


A: AnyRef

A: A.type

val x: String = "aaa"
val x1: String = "bbb"
val y: String = x
val z: x.type = x
val z1: x1.type = x1
