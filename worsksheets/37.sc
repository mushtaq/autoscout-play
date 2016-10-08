
class A(a: Int, b: Int = 90) {
  def this(a: Int) = this(a, 90)
}

object A {
  def makeFrom(a: Int) = new A(a, 90)
}

val aaa = """([0-9]{2})-([0-9]{2})-([0-9]{4})""".r

val jan = "01"

def process(date: String) = date match {
  case aaa(day, `jan`, year) => s"Hello $day and $year"
  case aaa(day, month, year) => s"Hello $day, $month and $year"
  case _                     => "error"
}


process("15-01-2016")

def `@ asdasd "asdasd asdasd` = 10

val y = `@ asdasd "asdasd asdasd`
