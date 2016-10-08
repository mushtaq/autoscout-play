import data.Book
import data.Data.books

books
  .filter(_.author == "odersky")
  .map(_.title)

books.collect {
  case book if book.author == "odersky" => book.title
}

val pf: PartialFunction[Book, String] = {
  case book if book.author == "odersky" => book.title
}

books
  .filter(pf.isDefinedAt)
  .map(pf)


