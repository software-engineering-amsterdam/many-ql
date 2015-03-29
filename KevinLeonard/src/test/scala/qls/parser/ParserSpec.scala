package qls.parser

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import ql.ast.{BooleanType, NumberType, Variable}
import qls.ast._

class ParserSpec extends Specification with ParserMatchers {
  val parsers = new Parser

  "variable parser" should {
    "parse a valid Java identifier" in {
      val input = "var1"
      val result = Variable(input)

      parsers.variable must succeedOn(input).withResult(result)
    }
  }

  "widget type parser" should {
    "parse the spinbox type" in {
      val spinBoxType = "spinbox"

      parsers.widgetType must succeedOn(spinBoxType).withResult(spinBoxType)
    }

    "parse the slider type" in {
      val sliderType = "slider"

      parsers.widgetType must succeedOn(sliderType).withResult(sliderType)
    }

    "parse the text type" in {
      val textType = "text"

      parsers.widgetType must succeedOn(textType).withResult(textType)
    }

    "parse the text block type" in {
      val textBlockType = "textBlock"

      parsers.widgetType must succeedOn(textBlockType).withResult(textBlockType)
    }

    "parse the radio type" in {
      val radioType = "radio"

      parsers.widgetType must succeedOn(radioType).withResult(radioType)
    }

    "parse the drop down type" in {
      val dropDownType = "dropdown"

      parsers.widgetType must succeedOn(dropDownType).withResult(dropDownType)
    }
  }

  "individual style parsers" should {
    "parse the width" in {
      val input = "width: 100"
      val result = Width(100)

      parsers.width must succeedOn(input).withResult(result)
    }

    "parse the font" in {
      val input = "font: \"Arial\""
      val result = Font("Arial")

      parsers.font must succeedOn(input).withResult(result)
    }

    "parse the font size" in {
      val input = "fontSize: 14"
      val result = FontSize(14)

      parsers.fontSize must succeedOn(input).withResult(result)
    }

    "parse color" in {
      val input = "color: #00ff00"
      val result = FontColor(HexadecimalColor("00ff00"))

      parsers.fontColor must succeedOn(input).withResult(result)
    }
  }

  "styles parser" should {
    "parse a style block" in {
      val styleBlock = "{" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66")))

      parsers.styles must succeedOn(styleBlock).withResult(result)
    }
  }

  "question parser" should {
    "parse spin box" in {
      val question = "var1 spinbox"
      val result = Question(Variable("var1"), SpinBox(List()))

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse slider" in {
      val question = "var1 slider"
      val result = Question(Variable("var1"), Slider(List()))

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse text" in {
      val question = "var1 text"
      val result = Question(Variable("var1"), Text(List()))

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse textBlock" in {
      val question = "var1 textBlock"
      val result = Question(Variable("var1"), TextBlock(List()))

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse radio" in {
      val question = "var1 radio"
      val result = Question(Variable("var1"), Radio(List()))

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse dropdown" in {
      val question = "var1 dropdown"
      val result = Question(Variable("var1"), DropDown(List()))

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse spinbox with style" in {
      val question = "var1 spinbox {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = Question(Variable("var1"),
        SpinBox(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
      )

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse slider with style" in {
      val question = "var1 slider {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = Question(Variable("var1"),
        Slider(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
      )

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse text with style" in {
      val question = "var1 text {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = Question(Variable("var1"),
        Text(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
      )

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse textBlock with style" in {
      val question = "var1 textBlock {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = Question(Variable("var1"),
        TextBlock(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
      )

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse radio with style" in {
      val question = "var1 radio {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = Question(Variable("var1"),
        Radio(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
      )

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse dropdown with style" in {
      val question = "var1 dropdown {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = Question(Variable("var1"),
        DropDown(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
      )

      parsers.question must succeedOn(question).withResult(result)
    }

    "parse question sequence" in {
      val questions = "{" +
        "var1 dropdown" +
        "var2 dropdown" +
        "}"
      val result = List(
        Question(Variable("var1"), DropDown(List())),
        Question(Variable("var2"), DropDown(List()))
      )

      parsers.sectionElements must succeedOn(questions).withResult(result)
    }
  }

  "section parser" should {
    "parse a section" in {
      val section = "section \"section1\" {" +
        "var1 dropdown {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}" +
        "var2 slider {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}" +
        "}"
      val result = Section("section1", List(
        Question(Variable("var1"),
          DropDown(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
        ),
        Question(Variable("var2"), Slider(
          List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
        )
      ))

      parsers.section must succeedOn(section).withResult(result)
    }

    "parse a section in a section" in {
      val nestedSections = "section \"section1\" {" +
        "var1 slider" +
        "section \"section2\" {" +
        "var2 dropdown" +
        "}" +
        "}"
      val result = Section("section1", List(
        Question(Variable("var1"), Slider(List())),
        Section("section2",
          List(Question(Variable("var2"), DropDown(List())))
        )
      ))
      parsers.section must succeedOn(nestedSections).withResult(result)
    }
  }

  "page parser" should {
    "parse a page" in {
      val page = "page page1 {" +
        "section \"section1\" {}" +
        "section \"section2\" {}" +
        "}"
      val result = Page("page1", List(Section("section1", List()), Section("section2", List())))

      parsers.page must succeedOn(page).withResult(result)
    }
  }

  "style sheet parser" should {
    "parse a style sheet" in {
      val styleSheet = "style PartyForm {" +
        "default boolean slider" +
        "page page1 {}" +
        "page page2 {}" +
        "}"
      val result = StyleSheet("PartyForm", List(
        DefaultWidget(BooleanType(), Slider(List())),
        Page("page1", List()),
        Page("page2", List()))
      )

      parsers.styleSheet must succeedOn(styleSheet).withResult(result)
    }
  }

  "default widget parser" should {
    "parse a default number spin box with style" in {
      val defaultWidgetWithStyle = "default number spinbox {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}"
      val result = DefaultWidget(NumberType(), SpinBox(
        List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66")))
      ))

      parsers.defaultWidget must succeedOn(defaultWidgetWithStyle).withResult(result)
    }
  }
}
