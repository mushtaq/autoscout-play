import data.Data
import mushtaq.{Ord, Sorter}
import data.Data.books
Sorter.sort(books)
Sorter.sort(List(1, 2, 3, 4, 5, 4))
Sorter.sort(List("xyz", "abc", "pqr", "abd"))

Sorter.sort(List(Option(2), Option(1), Option.empty[Int], Option(5)))

Sorter.sort(List(Option("xyz"), Option("abc"), Option.empty[String]))

Sorter.sort(List((1, "x"), (0, "b"), (1, "a")))

{

  implicit val intOrd: Ord[Int] = new Ord[Int] {
    def lt(a: Int, b: Int) = a > b
  }

  Sorter.sort(
    List(
      (Option(11), Option("a")),
      (Option(11), Option("b")),
      (Option(1), Option("z")),
      (Option(1), Option.empty[String]),
      (Option.empty[Int], Option("x"))
    )
  )

}
