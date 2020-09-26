package adapter

import domain._
import play.api.libs.json._

case class Post(user: User, content: String)

object Post {
    import adapter.UserFormat._
    implicit val postFormat: Format[Post] = Json.format[Post]
}