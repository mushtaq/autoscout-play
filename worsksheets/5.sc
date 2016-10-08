import data.Book
import data.Data.books

books
books.groupBy(book => book.author)
books.groupBy(_.author)
books.groupBy(_.basePrice)

def grouping(book: Book): String = {
  if(book.basePrice > 100) "expensive"
  else "cheap"
}

books.groupBy(grouping) foreach println

books.sortBy(-_.basePrice)


