import play.api.libs.json.Json

case object B

val a = 10

s"asdasdasd $a and $B"

"asdasdasd " + a + " and " + B

"""
  |I am in Pune
  |My name is asdasd
  |asdasd
  |
""".stripMargin

val str = """
  |{
  | "a": 1,
  | "b": [1, 2, 3]
  |}
""".stripMargin

Json.obj(
  "a" -> 1,
  "b" -> Json.arr(1, 2, 3)
)

Json.parse(str)
