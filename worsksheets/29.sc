import mushtaq.{Ord, Sorter}

Sorter.sort(List(1, 2, 3, 4, 5, 4))(Ord.intOrd)
Sorter.sort(List("xyz", "abc", "pqr", "abd"))(Ord.strOrd)

Sorter.sort(List(Option(2), Option(1), Option.empty[Int], Option(5)))(
  Ord.optOrd(Ord.intOrd)
)

Sorter.sort(List(Option("xyz"), Option("abc"), Option.empty[String]))(
  Ord.optOrd(Ord.strOrd)
)

Sorter.sort(List((1, "x"), (0, "b"), (1, "a")))(
  Ord.tupleOrd(Ord.intOrd, Ord.strOrd)
)

Sorter.sort(
  List(
    (Option(11), Option("a")),
    (Option(11), Option("b")),
    (Option(1), Option("z")),
    (Option(1), Option.empty[String]),
    (Option.empty[Int], Option("x"))
  )
)(Ord.tupleOrd(Ord.optOrd(Ord.intOrd), Ord.optOrd(Ord.strOrd)))


