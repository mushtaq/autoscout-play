
//def add(a: Option[String], b: Option[String]): Option[String] = {
//  if(a.isEmpty && b.isEmpty) None
//  else if(a.isEmpty) b
//  else if()
//  ???
//}

def ++(a: Option[String], b: Option[String]): Option[String] = (a, b) match {
  case _                  => None
  case (Some(x), Some(y)) => Some(x + y)
  case (None, Some(y))    => Some(y)
  case (Some(x), None)    => Some(x)
  case (None, None)       => None
}

++(Option("a"), None)


Option.empty[String]
Option("asdas")

None: Option[String]
Some("asdas"): Option[String]



