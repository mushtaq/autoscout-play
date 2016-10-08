

def intToString(x: Int) = x.toString

def stringToList(s: String) = s.toList

val f1 = intToString _
val f2 = stringToList _

val a = f2 compose f1

val b = f1 andThen f2

def a1(x: Int) = stringToList(intToString(x))


