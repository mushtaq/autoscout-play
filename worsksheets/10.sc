1

case class Address(street: String, pin: Int) {

}

case class Person(name: String, address: Address) {
  def withPin(pin: Int) =
    copy(address = address.copy(pin = pin))
}

object Address

val a1 = new Address("baner", 411021)
val a2 = Address("baner", 411021)

a1.hashCode()
a2.hashCode()

a1 == a2

a1.street
a2.pin

val p1 = Person("abc", Address("baner", 333))
val p2 = Person("abc", Address("baner", 333))

p1.copy(name = "xyz")









