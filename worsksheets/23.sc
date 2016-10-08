

def add1(a: Int, b: Int, c: Int) = a + b + c
def add2(a: Int)(b: Int)(c: Int) = a + b + c

val f1 = add1 _

f1(10, 20, 30)

val f2 = add2 _
val a = f2(10)
val b = a(20)
val c = b(30)


