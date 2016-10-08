
class Person(val name: String, val age: Int)

object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)

  def unapply(person: Person): Option[(String, Int)] =
    Some(person.name, person.age)
}

val p = Person("abc", 33)

val Person(n, a) = p

object A {
  def apply(x: Int) = x * x
}

A(20)
