package controllers

import play.api.libs.json.JsValue
import play.api.mvc._
import play.api.libs.json._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def home = Action {

    val json: JsValue = Json.parse("""
{
  "name" : "Watership Down",
  "location" : {
    "lat" : 51.235685,
    "long" : -1.309197
  },
  "residents" : [ {
    "name" : "Fiver",
    "age" : 4,
    "role" : null
  }, {
    "name" : "Bigwig",
    "age" : 6,
    "role" : "Owsla"
  } ]
}
                                   """)

    val lat=  (json  \"location"\ "lat").get
    val marks =(json \\ "name")
    var n: Int =  1
    var total=0
    var end=0
    var t=1

    while (((json \"residents")(n-1))!=null){
      n+=1
    }

    while(t!=n){
        var x=(json \ "residents")(t-1).get
      val y = (x \ "age").get
      end+= y.toString().toInt
      println(end)
      t+=1
    }
   // val nice = (json \ "residents")(1).get
    Ok(views.html.index(end.toString()))
  }

}
