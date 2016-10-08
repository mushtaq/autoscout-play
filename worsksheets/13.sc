
def value = {
  println("hi")
  10
}

def square(x:  => Int) = x * x
square(value)
val m = Map(1 -> "a")
m.getOrElse(11, "z")