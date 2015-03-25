package qls.gui

import org.specs2.mutable.Specification
import ql.ast.{Variable, BooleanType, StringType, NumberType}

import qls.ast._
import qlsTypes.StyleEnvironment

class FieldStyleSpec extends Specification {

  val fieldStyle = new FieldStyle

  val DefaultStyleEnvironment: StyleEnvironment = Map(
    NumberType() -> Map(
      "slider" -> List(Width(100), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(13)),
      "spin box" -> List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("00ff00")), FontSize(14)),
      "text" -> List(Width(200), Font("Sans-Serif"), FontColor(HexadecimalColor("0000ff")), FontSize(15))
    ),
    StringType() -> Map(
      "text" -> List(Width(250), Font("Arial"), FontColor(HexadecimalColor("cc0000")), FontSize(16)),
      "text block" -> List(Width(300), Font("Verdana"), FontColor(HexadecimalColor("00cc00")), FontSize(17))
    ),
    BooleanType() -> Map(
      "radio" -> List(Width(350), Font("Arial"), FontColor(HexadecimalColor("0000cc")), FontSize(18)),
      "check box" -> List(Width(400), Font("Verdana"), FontColor(HexadecimalColor("ff00cc")), FontSize(19)),
      "drop down" -> List(Width(450), Font("Sans-Serif"), FontColor(HexadecimalColor("ffcc00")), FontSize(20))
    )
  )
  val EmptyStyleEnvironment: StyleEnvironment = Map()

  "getWidth" should {
    "return Width from defaultProperties" in {
      val defaultProperties = List(Width(100))
      val widgetProperties = List()
      val result = Width(100)

      fieldStyle.getWidth(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return Width from widgetProperties" in {
      val defaultProperties = List(Width(100))
      val widgetProperties = List(Width(150))
      val result = Width(150)

      fieldStyle.getWidth(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return default Width when property is not defined" in {
      val defaultProperties = List()
      val widgetProperties = List()
      val result = fieldStyle.DEFAULT_PROPERTY_WIDTH

      fieldStyle.getWidth(defaultProperties, widgetProperties) must beEqualTo(result)
    }
  }

  "getFont" should {
    "return Font from defaultProperties" in {
      val defaultProperties = List(Font("Arial"))
      val widgetProperties = List()
      val result = Font("Arial")

      fieldStyle.getFont(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return Font from widgetProperties" in {
      val defaultProperties = List(Font("Arial"))
      val widgetProperties = List(Font("Verdana"))
      val result = Font("Verdana")

      fieldStyle.getFont(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return default Font when property is not defined" in {
      val defaultProperties = List()
      val widgetProperties = List()
      val result = fieldStyle.DEFAULT_PROPERTY_FONT

      fieldStyle.getFont(defaultProperties, widgetProperties) must beEqualTo(result)
    }
  }

  "getFontColor" should {
    "return FontColor from defaultProperties" in {
      val defaultProperties = List(FontColor(HexadecimalColor("000000")))
      val widgetProperties = List()
      val result = FontColor(HexadecimalColor("000000"))

      fieldStyle.getFontColor(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return FontColor from widgetProperties" in {
      val defaultProperties = List(FontColor(HexadecimalColor("000000")))
      val widgetProperties = List(FontColor(HexadecimalColor("ff0000")))
      val result = FontColor(HexadecimalColor("ff0000"))

      fieldStyle.getFontColor(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return default FontColor when property is not defined" in {
      val defaultProperties = List()
      val widgetProperties = List()
      val result = fieldStyle.DEFAULT_PROPERTY_FONT_COLOR

      fieldStyle.getFontColor(defaultProperties, widgetProperties) must beEqualTo(result)
    }
  }

  "getFontSize" should {
    "return FontSize from defaultProperties" in {
      val defaultProperties = List(FontSize(14))
      val widgetProperties = List()
      val result = FontSize(14)

      fieldStyle.getFontSize(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return FontSize from widgetProperties" in {
      val defaultProperties = List(FontSize(14))
      val widgetProperties = List(FontSize(13))
      val result = FontSize(13)

      fieldStyle.getFontSize(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return default FontSize when property is not defined" in {
      val defaultProperties = List()
      val widgetProperties = List()
      val result = fieldStyle.DEFAULT_PROPERTY_FONT_SIZE

      fieldStyle.getFontSize(defaultProperties, widgetProperties) must beEqualTo(result)
    }
  }

  "getStyleProperties" should {
    "return the style properties from defaultProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widgetProperties = List()
      val result = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))

      fieldStyle.getStyleProperties(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return the style properties from widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widgetProperties = List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13))
      val result = List(Width(150), Font("Verdana"), FontColor(HexadecimalColor("ff0000")), FontSize(13))

      fieldStyle.getStyleProperties(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return the mixed style properties from defaultProperties and widgetProperties with preference to widgetProperties" in {
      val defaultProperties = List(Width(100), Font("Arial"), FontColor(HexadecimalColor("000000")), FontSize(14))
      val widgetProperties = List(Width(150), FontColor(HexadecimalColor("ff0000")))
      val result = List(Width(150), Font("Arial"), FontColor(HexadecimalColor("ff0000")), FontSize(14))

      fieldStyle.getStyleProperties(defaultProperties, widgetProperties) must beEqualTo(result)
    }

    "return default properties when properties are not defined" in {
      val defaultProperties = List()
      val widgetProperties = List()
      val result = List(
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
      )

      fieldStyle.getStyleProperties(defaultProperties, widgetProperties) must beEqualTo(result)
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
        fieldStyle.DEFAULT_PROPERTY_WIDTH,
        fieldStyle.DEFAULT_PROPERTY_FONT,
        fieldStyle.DEFAULT_PROPERTY_FONT_COLOR,
        fieldStyle.DEFAULT_PROPERTY_FONT_SIZE
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
      val result = Question(Variable("var"), Slider(List(
        Width(100),
        Font("Arial"),
        FontColor(HexadecimalColor("ff0000")),
        FontSize(13)
      )))

      fieldStyle.extract(element, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return empty Section" in {
      val element = Section("section", List())
      val result = Section("section", List())

      fieldStyle.extract(element, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return Section with Questions with style properties from DefaultStyleEnvironment" in {
      val element = Section("section", List(
        Question(Variable("var"), Slider(List())),
        Question(Variable("var"), CheckBox(List()))
      ))
      val result = Section("section", List(
        Question(Variable("var"), Slider(List(
          Width(100),
          Font("Arial"),
          FontColor(HexadecimalColor("ff0000")),
          FontSize(13)
        ))),
        Question(Variable("var"), CheckBox(List(
          Width(400),
          Font("Verdana"),
          FontColor(HexadecimalColor("ff00cc")),
          FontSize(19)
        )))
      ))

      fieldStyle.extract(element, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return nested Sections" in {
      val element = Section("section", List(
        Section("section1", List())
      ))
      val result = Section("section", List(
        Section("section1", List())
      ))

      fieldStyle.extract(element, DefaultStyleEnvironment) must beEqualTo(result)
    }

    "return nested Sections with Questions" in {
      val element = Section("section", List(
        Question(Variable("var"), Slider(List())),
        Question(Variable("var"), CheckBox(List())),
        Section("section1", List(
          Question(Variable("var"), Slider(List())),
          Question(Variable("var"), CheckBox(List()))
        ))
      ))
      val result = Section("section", List(
        Question(Variable("var"), Slider(List(
          Width(100),
          Font("Arial"),
          FontColor(HexadecimalColor("ff0000")),
          FontSize(13)
        ))),
        Question(Variable("var"), CheckBox(List(
          Width(400),
          Font("Verdana"),
          FontColor(HexadecimalColor("ff00cc")),
          FontSize(19)
        ))),
        Section("section1", List(
          Question(Variable("var"), Slider(List(
            Width(100),
            Font("Arial"),
            FontColor(HexadecimalColor("ff0000")),
            FontSize(13)
          ))),
          Question(Variable("var"), CheckBox(List(
            Width(400),
            Font("Verdana"),
            FontColor(HexadecimalColor("ff00cc")),
            FontSize(19)
          )))
        ))
      ))

      fieldStyle.extract(element, DefaultStyleEnvironment) must beEqualTo(result)
    }
  }

  "update Style Environment" should {
    "return an updated StyleEnvironment" in {
      val env: StyleEnvironment = Map()
      val defaultWidget = DefaultWidget(BooleanType(), DropDown(List(
        Width(100),
        FontColor(HexadecimalColor("00dd00")),
        Font("Arial"),
        FontSize(14)
      )))
      val result = Map(
        BooleanType() -> Map(
          "drop down" -> List(
            Width(100),
            FontColor(HexadecimalColor("00dd00")),
            Font("Arial"),
            FontSize(14)
          )
        )
      )

      fieldStyle.updateStyleEnvironment(defaultWidget, env) must beEqualTo(result)
    }
  }

  "extract StyleSheet/StyleSheetElement" should {
    "return empty Page with EmptyStyleEnvironment " in {
      val element = Page("page", List())
      val result = (Page("page", List()), EmptyStyleEnvironment)

      fieldStyle.extract(element, EmptyStyleEnvironment) must beEqualTo(result)
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
        Map(
          NumberType() -> Map(
            "slider" -> List(
              Width(100),
              Font("Arial"),
              FontColor(HexadecimalColor("ff0000")),
              FontSize(13)
            )
          )
        )
      )


      fieldStyle.extract(element, EmptyStyleEnvironment) must beEqualTo(result)
    }

    "return empty StyleSheet" in {
      val stylesheet = StyleSheet("stylesheet", List())
      val result = StyleSheet("stylesheet", List())

      fieldStyle.extract(stylesheet, EmptyStyleEnvironment) must beEqualTo(result)
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

      fieldStyle.extract(stylesheet, EmptyStyleEnvironment) must beEqualTo(result)
    }

    "return StyleSheet with default checkbox widget and a question checkbox widget" in {
      val stylesheet = StyleSheet("stylesheet", List(
        DefaultWidget(StringType(), CheckBox(List(
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
      val result = StyleSheet("stylesheet", List(
        DefaultWidget(StringType(), CheckBox(List(
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

      fieldStyle.extract(stylesheet, EmptyStyleEnvironment) must beEqualTo(result)
    }
  }


  // TODO: Extract StylesheetElement
  // TODO: Extract Stylesheet

}
