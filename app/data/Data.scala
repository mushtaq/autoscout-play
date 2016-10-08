package data

import mushtaq.Ord
import org.joda.time.DateTime
import play.api.libs.json._

import scala.concurrent.Future

case class Person(name: String, dob: DateTime)

object Person {
//  implicit val dateWrites: Writes[DateTime] = new Writes[DateTime] {
//    def writes(o: DateTime): JsValue = JsString(o.toString)
//  }

  implicit val dateWrites: Writes[DateTime] = Writes(dt => JsString(dt.toString))

  implicit val format = Json.format[Person]
}

case class BookSet(books: Seq[Book]) {
  def findByAuthor(name: String): Future[Seq[Book]] = Future.successful(books.filter(_.author == name))
  def findByAuthors(names: List[String]): Future[Seq[Book]] = Future.successful(books.filter(b => names.contains(b.author)))
}

case class Book(
  author: String,
  title: String,
  basePrice: Double,
  isImported: Boolean
  )

object Book {
  implicit val bookOrd: Ord[Book] = new Ord[Book] {
    def lt(a: Book, b: Book) = a.basePrice < b.basePrice
  }

  implicit val format = Json.format[Book]
}

object Data {

  //find top 2 authors by max of total book prices by those authors
  //(minsky, 1088), (odersky, 600)

  val books = List(
    Book("odersky", "scala prog", 100, false),
    Book("odersky", "apple", 100, false),
    Book("odersky", "complexity", 400, false),
    Book("misky", "ocaml prog", 1000, true),
    Book("hickey", "clojure prog", 500, true)
  )

  val bookSet = BookSet(books)

}
