package mushtaq

import mushtaq.StringExtension.RichString

object StringExtension {

  implicit class RichString(val str: String) extends AnyVal {
    def hello = s"hello $str"
  }

  implicit class RichString1(val str: String) extends AnyVal {
    def hello = s"hello $str"
  }

}

object A {
  "asdasd".hello
}