
class Person(var name: String, age: Int = 22, f1: Int => Int) {

  val time = System.nanoTime()

  val f = { day: String =>
    s"Hello $day"
  }

  def g(day: String) = s"Hello $day"

  var address = s"$name and $age"

}

val p = new Person("abc", f1 = identity)
p.address = "asdasd"

p.name
p.name = "asdasd"
p.time
p.time
p.time
p.time

p.f("asdasds")
p.g("asdasds")
