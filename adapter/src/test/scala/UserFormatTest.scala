import org.scalatest.funsuite.AnyFunSuite

import domain._
import domain.User._
import adapter.UserFormat.given

import play.api.libs.json._

class UserFormatTest extends AnyFunSuite {
    test("UserFormat serialize & deserialize is working") {
      val user = User(Id(1), Name("my-name"))
      assert(Json.toJson(user).as[User] == user)
    }
  
}
