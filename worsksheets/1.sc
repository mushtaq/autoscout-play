val turkeyCanDrink: Int => Boolean = new (Int => Boolean) {
  def apply(age: Int) = age > 20
}

val indiaCanDrink: Int => Boolean = { age =>
  age > 30
}

val indiaCanDrink1 = { age: Int =>
  age > 30
}

def indiaCanDrink2(age: Int) = age > 30

indiaCanDrink1.apply(33)
indiaCanDrink2(33)

val dd = indiaCanDrink1
val ee = indiaCanDrink2 _
val ff: (Int) => Boolean = indiaCanDrink2


class Person(age: Int, isFemale: Boolean) {
  def isAllowedToDrink(canDrink: Int => Boolean) =
    canDrink(age)
}
val p = new Person(28, true)
p.isAllowedToDrink(turkeyCanDrink)
p.isAllowedToDrink(indiaCanDrink1)
p.isAllowedToDrink(indiaCanDrink2)


p.isAllowedToDrink { age =>
  age > 30
}

p.isAllowedToDrink(age => age > 30)
p.isAllowedToDrink(_ > 30)









