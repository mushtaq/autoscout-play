
val square: Function1[Int, Int] = {
  case x: Int => x * x
}

square(10)

val divide100: PartialFunction[Int, Int] = {
  case x: Int if x != 0 => 100 / x
}

divide100.isDefinedAt(0)

val pf1: PartialFunction[Int, String] = {
  case 0 => "Hello 0"
}

val pf2: PartialFunction[Int, String] = {
  case x if x > 0 => "Hello positive"
}

val pf3: PartialFunction[Int, String] = {
  case x if x < 0 => "Hello negative"
}

val pf: PartialFunction[Int, String] = pf1.orElse(pf2)
val f: Int => Option[String] = pf.lift

def lift(pf: PartialFunction[Int, String]) = { x: Int =>
  if(pf.isDefinedAt(x)) Some(pf(x))
  else None
}

f(100)
f(-100)
f(0)





