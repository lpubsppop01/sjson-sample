package jp.lpubsppop01.sample

object Sample {

  def main(args: Array[String]) {
    import ItemProtocol._
    val testJs = dispatch.json.Js("""
        {
            "name": "Hoge",
            "title": "Piyo",
            "inner": {
                "name": "Fuga",
                "title": "Hogera"
             }
        }"""
    )
    val testObject = sjson.json.JsonSerialization.fromjson[Item](testJs)
    println(sjson.json.JsonSerialization.tojson(testObject))
  }

}

case class InnerItem(name: String = "", title: String = "")
case class Item(name: String = "", title: String = "", inner: InnerItem)

object ItemProtocol extends sjson.json.DefaultProtocol {

  implicit val innerItemFormat: sjson.json.Format[InnerItem] = asProduct2("name", "title")(InnerItem)(InnerItem.unapply(_).get)
  implicit val itemFormat: sjson.json.Format[Item] = asProduct3("name", "title", "inner")(Item)(Item.unapply(_).get)

}
