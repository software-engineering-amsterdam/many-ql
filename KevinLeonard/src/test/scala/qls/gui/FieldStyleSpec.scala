package qls.gui

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, NumberType, StringType, Variable}
import qls.ast._
import qlsTypes.StyleEnvironment
import types.TypeEnvironment

class FieldStyleSpec extends Specification {

  val fieldStyle = new FieldStyle

  val DefaultStyleEnvironment: StyleEnvironment = List(
    DefaultWidget(NumberType(), Slider(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))),
    DefaultWidget(NumberType(), SpinBox(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("00ff00")), FontSize(14)))),
    DefaultWidget(NumberType(), Text(List(Width(200), Font("Sans-Serif"), FontColor(HexadecimalColor("0000ff")), FontSize(15)))),
    DefaultWidget(StringType(), Text(List(Width(250), Font("Arial"), FontColor(HexadecimalColor("cc0000")), FontSize(16)))),
    DefaultWidget(StringType(), TextBlock(List(Width(300), Font("Verdana"), FontColor(HexadecimalColor("00cc00")), FontSize(17)))),
    DefaultWidget(BooleanType(), Radio(List(Width(350), Font("Arial"), FontColor(HexadecimalColor("0000cc")), FontSize(18)))),
    DefaultWidget(BooleanType(), CheckBox(List(Width(400), Font("Verdana"), FontColor(HexadecimalColor("ff00cc")), FontSize(19)))),
    DefaultWidget(BooleanType(), DropDown(List(Width(450), Font("Sans-Serif"), FontColor(HexadecimalColor("ffcc00")), FontSize(20))))
  )
  val EmptyStyleEnvironment: StyleEnvironment = List()
  val EmptyTypeEnvironment: TypeEnvironment = Map()

  "get styles" should {
    "return the defined default styles if there are no widget styles" in {
      val widgetStyles = List()
      val defaultStyles = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val result = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))

      fieldStyle.getStyles(widgetStyles, defaultStyles) must beEqualTo(result)
    }

    "return the widget styles if they are set" in {
      val widgetStyles = List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13))
      val defaultStyles = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val result = List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13))

      fieldStyle.getStyles(widgetStyles, defaultStyles) must beEqualTo(result)
    }

    "return the widget styles if they are set, otherwise the defined default styles" in {
      val widgetStyles = List(Width(150), FontColor(HexadecimalColor("ff0000")))
      val defaultStyles = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val result = List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14))

      fieldStyle.getStyles(widgetStyles, defaultStyles) must beEqualTo(result)
    }

    "return default system styles when no styles are defined" in {
      val widgetStyles = List()
      val defaultStyles = List()
      val result = List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      )

      fieldStyle.getStyles(widgetStyles, defaultStyles) must beEqualTo(result)
    }
  }

  "extract widget" should {
    "return Slider with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = Slider(List())
      val result = Slider(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Slider with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = Slider(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = Slider(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Slider with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = Slider(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = Slider(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Slider with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = Slider(List())
      val result = Slider(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return SpinBox with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = SpinBox(List())
      val result = SpinBox(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return SpinBox with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = SpinBox(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = SpinBox(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return SpinBox with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = SpinBox(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = SpinBox(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return SpinBox with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = SpinBox(List())
      val result = SpinBox(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Text with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = Text(List())
      val result = Text(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Text with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = Text(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = Text(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Text with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = Text(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = Text(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Text with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = Text(List())
      val result = Text(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return TextBlock with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = TextBlock(List())
      val result = TextBlock(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return TextBlock with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = TextBlock(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = TextBlock(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return TextBlock with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = TextBlock(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = TextBlock(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return TextBlock with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = TextBlock(List())
      val result = TextBlock(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Radio with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = Radio(List())
      val result = Radio(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Radio with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = Radio(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = Radio(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Radio with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = Radio(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = Radio(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return Radio with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = Radio(List())
      val result = Radio(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return CheckBox with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = CheckBox(List())
      val result = CheckBox(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return CheckBox with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = CheckBox(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = CheckBox(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return CheckBox with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = CheckBox(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = CheckBox(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return CheckBox with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = CheckBox(List())
      val result = CheckBox(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return DropDown with style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = DropDown(List())
      val result = DropDown(List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return DropDown with style properties from widgetProperties" in {
      val defaultProperties = List()
      val widget = DropDown(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))
      val result = DropDown(List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return DropDown with mixed properties from widgetProperties and default properties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widget = DropDown(List(Width(150), FontColor(HexadecimalColor("ff0000"))))
      val result = DropDown(List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14)))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }

    "return DropDown with default properties when properties are not defined" in {
      val defaultProperties = List()
      val widget = DropDown(List())
      val result = DropDown(List(
        fieldStyle.DefaultWidth,
        fieldStyle.DefaultFont,
        fieldStyle.DefaultFontColor,
        fieldStyle.DefaultFontSize
      ))

      fieldStyle.extract(widget, defaultProperties) must beEqualTo(result)
    }
  }

  "getDefaultStyleProperties" should {
    "return a list with default style properties for a Slider widget with question type Number" in {
      val _type = NumberType()
      val widget = Slider(List())

      val result = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(13))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Spin Box widget with question type Number" in {
      val _type = NumberType()
      val widget = SpinBox(List())

      val result = List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("00ff00")), FontSize(14))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Text widget with question type Number" in {
      val _type = NumberType()
      val widget = Text(List())

      val result = List(Width(200), Font("Sans-Serif"), FontColor(HexadecimalColor("0000ff")), FontSize(15))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Text widget with question type String" in {
      val _type = StringType()
      val widget = Text(List())

      val result = List(Width(250), Font("Arial"), FontColor(HexadecimalColor("cc0000")), FontSize(16))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Text Block widget with question type String" in {
      val _type = StringType()
      val widget = TextBlock(List())

      val result = List(Width(300), Font("Verdana"), FontColor(HexadecimalColor("00cc00")), FontSize(17))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Radio widget with question type Boolean" in {
      val _type = BooleanType()
      val widget = Radio(List())

      val result = List(Width(350), Font("Arial"), FontColor(HexadecimalColor("0000cc")), FontSize(18))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Check Box widget with question type Boolean" in {
      val _type = BooleanType()
      val widget = CheckBox(List())

      val result = List(Width(400), Font("Verdana"), FontColor(HexadecimalColor("ff00cc")), FontSize(19))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return a list with default style properties for a Drop Down widget with question type Boolean" in {
      val _type = BooleanType()
      val widget = DropDown(List())

      val result = List(Width(450), Font("Sans-Serif"), FontColor(HexadecimalColor("ffcc00")), FontSize(20))

      fieldStyle.getDefaultStyleProperties(_type, widget, DefaultStyleEnvironment) must beEqualTo(result)
    }
  }

  "extract Section/SectionElement" should {
    "return Question with style properties from DefaultStyleEnvironment" in {
      val element = Question(Variable("var"), Slider(List()))
      val typeEnvironment = Map("var" -> NumberType())
      val result = Question(Variable("var"), Slider(List(
        Width(100),
        Font("Arial"),
        FontColor(HexadecimalColor("ff0000")),
        FontSize(13)
      )))

      fieldStyle.extract(element, DefaultStyleEnvironment, typeEnvironment) must beEqualTo(result)
    }

    "return empty Section" in {
      val element = Section("section", List())
      val result = Section("section", List())

      fieldStyle.extract(element, DefaultStyleEnvironment, EmptyTypeEnvironment) must beEqualTo(result)
    }

    "return Section with Questions with style properties from DefaultStyleEnvironment" in {
      val element = Section("section", List(
        Question(Variable("var1"), Slider(List())),
        Question(Variable("var2"), CheckBox(List()))
      ))
      val typeEnvironment = Map("var1" -> NumberType(), "var2" -> BooleanType())
      val result = Section("section", List(
        Question(Variable("var1"), Slider(List(
          Width(100),
          Font("Arial"),
          FontColor(HexadecimalColor("ff0000")),
          FontSize(13)
        ))),
        Question(Variable("var2"), CheckBox(List(
          Width(400),
          Font("Verdana"),
          FontColor(HexadecimalColor("ff00cc")),
          FontSize(19)
        )))
      ))

      fieldStyle.extract(element, DefaultStyleEnvironment, typeEnvironment) must beEqualTo(result)
    }

    "return nested Sections" in {
      val element = Section("section", List(
        Section("section1", List())
      ))
      val result = Section("section", List(
        Section("section1", List())
      ))

      fieldStyle.extract(element, DefaultStyleEnvironment, EmptyTypeEnvironment) must beEqualTo(result)
    }

    "return nested Sections with Questions" in {
      val element = Section("section", List(
        Question(Variable("var1"), Slider(List())),
        Question(Variable("var2"), CheckBox(List())),
        Section("section1", List(
          Question(Variable("var3"), Slider(List())),
          Question(Variable("var4"), CheckBox(List()))
        ))
      ))
      val typeEnvironment = Map(
        "var1" -> NumberType(),
        "var2" -> BooleanType(),
        "var3" -> NumberType(),
        "var4" -> BooleanType()
      )
      val result = Section("section", List(
        Question(Variable("var1"), Slider(List(
          Width(100),
          Font("Arial"),
          FontColor(HexadecimalColor("ff0000")),
          FontSize(13)
        ))),
        Question(Variable("var2"), CheckBox(List(
          Width(400),
          Font("Verdana"),
          FontColor(HexadecimalColor("ff00cc")),
          FontSize(19)
        ))),
        Section("section1", List(
          Question(Variable("var3"), Slider(List(
            Width(100),
            Font("Arial"),
            FontColor(HexadecimalColor("ff0000")),
            FontSize(13)
          ))),
          Question(Variable("var4"), CheckBox(List(
            Width(400),
            Font("Verdana"),
            FontColor(HexadecimalColor("ff00cc")),
            FontSize(19)
          )))
        ))
      ))

      fieldStyle.extract(element, DefaultStyleEnvironment, typeEnvironment) must beEqualTo(result)
    }
  }

  "update Style Environment" should {
    "return an updated StyleEnvironment" in {
      val defaultWidget = DefaultWidget(BooleanType(), DropDown(List(
        Width(100),
        FontColor(HexadecimalColor("00dd00")),
        Font("Arial"),
        FontSize(14)
      )))
      val result = List(DefaultWidget(BooleanType(), DropDown(List(
        Width(100),
        FontColor(HexadecimalColor("00dd00")),
        Font("Arial"),
        FontSize(14)
      ))))

      fieldStyle.updateStyleEnvironment(defaultWidget, EmptyStyleEnvironment) must beEqualTo(result)
    }
  }

  "extract StyleSheet/StyleSheetElement" should {
    "return empty Page with EmptyStyleEnvironment " in {
      val element = Page("page", List())
      val result = (Page("page", List()), EmptyStyleEnvironment)

      fieldStyle.extract(element, EmptyStyleEnvironment, EmptyTypeEnvironment) must beEqualTo(result)
    }

    "return DefaultWidget with updated environment" in {
      val element = DefaultWidget(
        NumberType(),
        Slider(List(
          Width(100),
          Font("Arial"),
          FontColor(HexadecimalColor("ff0000")),
          FontSize(13))
        )
      )
      val result = (
        DefaultWidget(
          NumberType(),
          Slider(List(
            Width(100),
            Font("Arial"),
            FontColor(HexadecimalColor("ff0000")),
            FontSize(13))
          )
        ),
        List(DefaultWidget(
          NumberType(),
          Slider(List(
            Width(100),
            Font("Arial"),
            FontColor(HexadecimalColor("ff0000")),
            FontSize(13))
          )
        ))
      )

      fieldStyle.extract(element, EmptyStyleEnvironment, EmptyTypeEnvironment) must beEqualTo(result)
    }

    "return empty StyleSheet" in {
      val stylesheet = StyleSheet("stylesheet", List())
      val result = StyleSheet("stylesheet", List())

      fieldStyle.extract(stylesheet, EmptyStyleEnvironment, EmptyTypeEnvironment) must beEqualTo(result)
    }

    "return StyleSheet with default widget and empty page" in {
      val stylesheet = StyleSheet("stylesheet", List(
        DefaultWidget(StringType(), TextBlock(List(
          Width(100),
          Font("Verdana"),
          FontColor(HexadecimalColor("ffff00")),
          FontSize(13)
        ))),
        Page("page", List())
      ))
      val result = StyleSheet("stylesheet", List(
        DefaultWidget(StringType(), TextBlock(List(
          Width(100),
          Font("Verdana"),
          FontColor(HexadecimalColor("ffff00")),
          FontSize(13)
        ))),
        Page("page", List())
      ))

      fieldStyle.extract(stylesheet, EmptyStyleEnvironment, EmptyTypeEnvironment) must beEqualTo(result)
    }

    "return StyleSheet with default checkbox widget and a question checkbox widget" in {
      val stylesheet = StyleSheet("stylesheet", List(
        DefaultWidget(BooleanType(), CheckBox(List(
          Width(100),
          Font("Verdana"),
          FontColor(HexadecimalColor("ffff00")),
          FontSize(13)
        ))),
        Page("page", List(
          Section("section", List(
            Question(Variable("var"), CheckBox(List()))
          ))
        ))
      ))
      val typeEnvironment = Map("var" -> BooleanType())
      val result = StyleSheet("stylesheet", List(
        DefaultWidget(BooleanType(), CheckBox(List(
          Width(100),
          Font("Verdana"),
          FontColor(HexadecimalColor("ffff00")),
          FontSize(13)
        ))),
        Page("page", List(
          Section("section", List(
            Question(Variable("var"), CheckBox(List(
              Width(100),
              Font("Verdana"),
              FontColor(HexadecimalColor("ffff00")),
              FontSize(13)
            )))
          ))
        ))
      ))

      fieldStyle.extract(stylesheet, EmptyStyleEnvironment, typeEnvironment) must beEqualTo(result)
    }
  }

  // TODO: Extract StylesheetElement
  // TODO: Extract Stylesheet

}
