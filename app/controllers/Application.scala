package controllers

import play.api.mvc._
import play.api.libs.json._

import scala.io.Source
import play.api.libs.json._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index(1))
  }

}
