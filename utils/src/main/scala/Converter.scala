package utils

import domain._
import adapter._
import User._
import UserFormat._
import play.api.libs.json._

object Converter {
    def toJson(post: Post): JsValue = Json.toJson(post)
    def toJson(user: User): JsValue = Json.toJson(user)
}