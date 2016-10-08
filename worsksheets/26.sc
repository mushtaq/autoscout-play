

object Sep {
  def unapply(s: String): Option[(String, String)] = s.split("@") match {
    case Array(user, domain) => Some(user, domain)
    case _                   => None
  }
}

def process(email: String) = email match {
  case Sep(user, domain) => s"Hello $user from $domain"
  case _                 => "error"
}

process("mushtaq@thoughtworks.com")
process("mushtaq@thoug@htworks.com")
process("asdasdasd")

//
//val x: Either[Int, String] = ???
//val y: Int Either String = ???
//
//val x1: Function1[Int, String] = ???
//val y1: Int => String = ???


1 -> "a"

1 :: 2 :: Nil

11 +: 10 +:  Seq(1, 2, 3) :+ 34 :+ 23








