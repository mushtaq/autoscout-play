package controllers

import javax.inject.{Singleton, Inject}

import data.{Book, Person, Data}
import org.joda.time.DateTime
import play.api._
import play.api.libs.json.{JsValue, Writes, JsString, Json}
import play.api.mvc._
import async.Async._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class Application @Inject()(implicit ec: ExecutionContext) extends Controller {

  def saveBook() = Action(parse.json) { request =>
    val book = request.body.as[Book]
    println(book)
    Created("saved")
  }

  def index = Action {
    Ok(Json.arr(1, 2, 3, 4))
  }

  def books(name: String) = Action.async {
    val dd: Future[Result] = async {
      val future = Data.bookSet.findByAuthor(name)
      val books = await(future)
      Ok(Json.toJson(books))
    }

    dd

  }

  def books2(names: List[String], title: String) = Action.async {
    async {
      println(names, title)
      Ok(Json.toJson(await(Data.bookSet.findByAuthors(names))))
    }

  }

  def dates() = Action {
    Ok(Json.toJson(new Person("abc", DateTime.now())))
  }

}
