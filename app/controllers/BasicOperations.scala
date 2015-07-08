package controllers

import play.api.Play
import play.api.mvc._

import scala.io.Source
import play.api.libs.json._



class BasicOperations extends Controller {


  def home = Action {
    val projectRoot = Play.current.path
    val addingPath = Seq(projectRoot, "/conf/json/result.json")
    val finalPath = addingPath.mkString
    val file = Source.fromFile(finalPath)
    val mainFile = file.mkString
    val json: JsValue = Json.parse(mainFile)
    var n:Int = 1;
    var finalTotal = 0

    while (n != 5) {
      val dataArr = (json \ "menu" \ "subject" \ "physics")(n - 1).get
      val marks = (dataArr \ "marks").get
      finalTotal = finalTotal + marks.toString().toInt
      println(marks)
      n += 1
    }

    Ok(views.html.index(finalTotal))
  }
}
