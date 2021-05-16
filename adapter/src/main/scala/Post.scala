package adapter

import domain._
import play.api.libs.json._

case class Post(user: User, content: String)

object Post {
    import adapter.UserFormat.given
    given Format[Post] = Format.of[Post]
}