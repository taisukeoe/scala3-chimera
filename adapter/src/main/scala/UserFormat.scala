package adapter

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.json.Writes._
import play.api.libs.functional.syntax._
import domain._

object UserFormat {

    // Json.format, which was macro in Scala 2.13, is now implemented by `Mirror.Of`.
    // For now it is failed to get value class or opaque type format by `Json.format`.
    // ref: https://github.com/playframework/play-json/blob/e4ffe8924798d0149204ba00adb41f7738a8ef3f/play-json/shared/src/main/scala-3/play/api/libs/json/JsMacroImpl.scala
    //
    // So that Json.format is not working as expected without explicit value classes or opaque types explicit format.
    // given Format[User] = Json.format[User]
    // given Format[User.Name] = Format[User.Name](summon[Reads[String]].map(User.Name.apply), summon[Writes[String]].contramap(_.value))
    // given Format[User.Id] = Format[User.Id](summon[Reads[Int]].map(User.Id.apply), summon[Writes[Int]].contramap(_.value))    
    
    // Format.of[User] just works great.
    given Format[User] = Format.of[User]
}