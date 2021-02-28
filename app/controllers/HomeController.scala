package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import domain._
import adapter._
import utils._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  def hello(id: Int, name: String) = Action { implicit request: Request[AnyContent] =>
    import User._

    // Using `given` value from `Scala 2.13` seems not to work.
    //
    // [error] illegal cyclic reference involving object Json
    // [error]     Ok(Json.toJson(Post(User(Id(id), Name(name)), "Hello, world!")))
    // [error]             ^
    // [error] one error found
    //
    // So `Converter` or intermediate function helps this to compile.
    Ok(Converter.toJson(Post(User(Id(id), Name(name)), "Hello, world!")))
  }
}
