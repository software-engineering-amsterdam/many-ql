package qls.gui

import org.specs2.mutable.Specification
import ql.ast.Variable
import qls.ast._

class FieldStyleSpec extends Specification {

  val fieldStyle = new FieldStyle

  "extractions" should {
//    "updateStyleProperties" in {
//      val env = List(
//        Width(100),
//        FontSize(14)
//      )
//      val style = List(
//        Width(101)
//      )
//      val result = List(
//        Width(101),
//        FontSize(14)
//      )
//
//      fieldStyle.updateStyleProperties(env, style) must beEqualTo(result)
//    }

    "extract Widget" in {
      val env = List(
        Width(100)
      )
      val widget = Radio(List(
        Width(100)
      ))
      val result = Radio(List(
        Width(100),
        Width(100)
      ))

      fieldStyle.extract(widget, env) must beEqualTo(result)
    }

    "extract Section" in {
      val env = List(
        Width(101)
      )
      val section = Section("section1", List(
        Question(Variable("var"), Radio(List(Width(100))))
      ))
      val result = Section("section1", List(
        Question(Variable("var"), Radio(List(Width(101), Width(100))))
      ))

      fieldStyle.extract(section, env) must beEqualTo(result)
    }

    "extract Page" in {
      val env = List(
        Width(101)
      )
      val page = Page("var", List(
        Section("section1", List(
          Question(Variable("var"), Radio(List(Width(100))))
        ))
      ))
      val result = Page("var", List(
        Section("section1", List(
          Question(Variable("var"), Radio(List(Width(101), Width(100))))
        ))
      ))

      fieldStyle.extract(page, env) must beEqualTo(result)
    }

    "extract Style" in {
      val env = List(
        Width(101)
      )
      val style = StyleSheet("style", List(
        Page("var", List(
          Section("section1", List(
            Question(Variable("var"), Radio(List(Width(100))))
          ))
        ))
      ))
      val result = StyleSheet("style", List(
        Page("var", List(
          Section("section1", List(
            Question(Variable("var"), Radio(List(Width(101), Width(100))))
          ))
        ))
      ))

      fieldStyle.extract(style, env) must beEqualTo(result)
    }

  }

}
