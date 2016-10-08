import play.api.libs.json._

def m(obj: Any) = obj match {
  case 1  => 123123
  case "asdasd" => "www"
}

object :: {
  def unapply(s: String): Option[(String, String)] = s.split(":") match {
    case Array(user, domain) => Some(user, domain)
    case _                   => None
  }
}

def transform(json: JsValue): JsValue = json match {
  case JsNull                       => JsString("null")
  case JsNumber(value)              => JsNumber(value * value)
  case JsBoolean(value)             => JsBoolean(!value)
  case JsString("")                 => JsString("empty")
  case JsString("urn" :: rest) => JsString(s"Hello $rest")

  case JsArray(values) => JsArray(values.map(transform))
  case JsObject(pairs) => JsObject(pairs.map(transformPair))
}


def transformPair(pair: (String, JsValue)) = pair match {
  case (key@("m" | "n"), jsValue) => key -> jsValue
  case (key, jsValue)             => key -> transform(jsValue)
}

def transformPair1(pair: (String, JsValue)) = {
  if (pair._1 == "m" || pair._1 == "n") {
    pair
  } else {
    pair._1 -> transform(pair._2)
  }
}
