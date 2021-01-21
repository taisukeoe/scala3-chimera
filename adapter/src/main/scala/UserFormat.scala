package adapter

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.json.Writes._
import play.api.libs.functional.syntax._
import domain._

object UserFormat {
    /*
     * Failed to expand User by macro due to the absense of unapply
     * Unapply of domain.User has no parameters. Are you using an empty case class?
     * [error]     implicit val userFormat: Format[User] = Json.format[User]
     * [error]                                                        ^
     */ 
    
     // implicit val userFormat: Format[User] = Json.format[User]

    // Explicit read codec works fine. 
    
    implicit val userReads: Reads[User] = (
        (JsPath \ "id").read[Int].map(User.Id.apply) and 
          (JsPath \ "name").read[String].map(User.Name.apply)
    )(User.apply _)
    
    /*
      Since unapply signature in Scala 3 has been changed, you can't use unapply here as you did in Scala 2.13.

    implicit val userWrites: Writes[User] = (
      (JsPath \ "id").write[Int] and    
      (JsPath \ "name").write[String]
    )(unlift(User.unapply))
     */

    implicit val userWrites: Writes[User] = (
      (JsPath \ "id").write[Int] and    
      (JsPath \ "name").write[String]
    )(u => (u.id.asInstanceOf[Int], u.name.asInstanceOf[String]))
}