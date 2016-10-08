

def While(p: => Boolean)(body: => Unit): Unit =
  if(p) {
    body
    While(p)(body)
  }


var a = 0

While (a < 10) {
  println(a)
  a = a + 1
}
