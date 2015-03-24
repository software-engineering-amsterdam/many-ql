package qls.gui

import org.specs2.mutable.Specification
import ql.ast.{Type, BooleanType, Variable}
import qls.ast._
import qlsTypes.StyleEnvironment

class FieldStyleSpec extends Specification {

  val fieldStyle = new FieldStyle

  "extractions" should {
    "updateStyleProperties" in {
      val env = List(
        Width(100),
        FontSize(14)
      )
      val style = List(
        Width(101)
      )
      val result = List(
        Width(101),
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        FontSize(14)
      )

      fieldStyle.getStyleProperties(env, style) must beEqualTo(result)
    }

    "extract Widget" in {
      val env = List(
        Width(100)
      )
      val widget = Radio(List(
        Width(100)
      ))
      val result = Radio(List(
        Width(100),
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
      ))

      fieldStyle.extract(widget, env) must beEqualTo(result)
    }

    "extract Section" in {
      val env: StyleEnvironment = Map(
        BooleanType() -> Map(
          "radio" -> List(
            Width(101)
          )
        )
      )
      val section = Section("section1", List(
        Question(Variable("var"), Radio(List()))
      ))
      val result = Section("section1", List(
        Question(Variable("var"), Radio(List(
          Width(101),
          fieldStyle.DEFAULT_PROPERTY_FONT,
          fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
          fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
        )))
      ))

      fieldStyle.extract(section, env) must beEqualTo(result)
    }

    "update style environment" in {
      val env: StyleEnvironment = Map(
        BooleanType() -> Map(
          "radio" -> List(Width(200)),
          "drop down" -> List(Width(200))
        )
      )
      val defaultWidget = DefaultWidget(
        BooleanType(),
        Radio(List(Width(100)))
      )
      val result: StyleEnvironment = Map(
        BooleanType() -> Map(
          "radio" -> List(Width(100)),
          "drop down" -> List(Width(200))
        )
      )

      fieldStyle.updateStyleEnvironment(defaultWidget, env) must beEqualTo(result)
    }

    "extract Page" in {
      val env: StyleEnvironment = Map(
        BooleanType() -> Map(
          "radio" -> List(Width(200)),
          "drop down" -> List(Width(200))
        )
      )
      val page = Page("var", List(
        Section("section1", List(
          Question(Variable("var"), Radio(List(Width(100))))
        ))
      ))
      val result = (Page("var", List(
        Section("section1", List(
          Question(Variable("var"), Radio(List(
            Width(100),
            fieldStyle.DEFAULT_PROPERTY_FONT,
            fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
            fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
          )))
        ))
      )), Map(
        BooleanType() -> Map(
          "radio" -> List(Width(200)),
          "drop down" -> List(Width(200))
        )
      ))

      fieldStyle.extract(page, env) must beEqualTo(result)
    }

    "extract Default Widget" in {
      val env: StyleEnvironment = Map()
      val defaultWidget = DefaultWidget(
        BooleanType(),
        Radio(List(Width(100)))
      )
      val result = (DefaultWidget(
        BooleanType(),
        Radio(List(Width(100)))
      ), Map(
        BooleanType() -> Map(
          "radio" -> List(Width(100))
        )
      ))

      fieldStyle.extract(defaultWidget, env) must beEqualTo(result)
    }

    "extract Style" in {
      val env: StyleEnvironment = Map()
      val style = StyleSheet("style", List(
        DefaultWidget(
          BooleanType(),
          Radio(List(Width(100)))
        ),
        Page("var", List(
          Section("section1", List(
            Question(Variable("var"), Radio(List()))
          ))
        ))
      ))
      val result = StyleSheet("style", List(
        DefaultWidget(
          BooleanType(),
          Radio(List(Width(100)))
        ),
        Page("var", List(
          Section("section1", List(
            Question(Variable("var"), Radio(List(
              Width(100),
              fieldStyle.DEFAULT_PROPERTY_FONT,
              fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
              fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
            )))
          ))
        ))
      ))

      fieldStyle.extract(style, env) must beEqualTo(result)
    }

  }

}
