package qls.parser

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import ql.ast.{BooleanType, NumberType, Variable}
import qls.ast._

class ParserSpec extends Specification with ParserMatchers {

  val parsers = new Parser
  import parsers._

  "variable parser" should {
    "parse a valid Java identifier" in {
      variable must succeedOn("var1")
        .withResult(Variable("var1"))
    }
  }

  "widget type parser" should {
    "parse spinbox" in {
      widgetType must succeedOn("spinbox")
        .withResult("spinbox")
    }
    "parse slider" in {
      widgetType must succeedOn("slider")
        .withResult("slider")
    }
    "parse text" in {
      widgetType must succeedOn("text")
        .withResult("text")
    }
    "parse textBlock" in {
      widgetType must succeedOn("textBlock")
        .withResult("textBlock")
    }
    "parse radio" in {
      widgetType must succeedOn("radio")
        .withResult("radio")
    }
    "parse dropdown" in {
      widgetType must succeedOn("dropdown")
        .withResult("dropdown")
    }
  }

  "style parser" should {
    "parse width" in {
      width must succeedOn("width: 100")
        .withResult(Width(100))
    }
    "parse font" in {
      font must succeedOn("font: \"Arial\"")
        .withResult(Font("Arial"))
    }
    "parse fontSize" in {
      fontSize must succeedOn("fontSize: 14")
        .withResult(FontSize(14))
    }
    "parse color" in {
      fontColor must succeedOn("color: #00ff00")
        .withResult(FontColor(HexadecimalColor("00ff00")))
    }
  }

  "widget style" should {
    "parse style block" in {
      styles must succeedOn("{" +
          "width: 400" +
          "font: \"Arial\"" +
          "fontSize: 14" +
          "color: #99FF66" +
        "}")
        .withResult(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))
    }
  }

  "widget parser" should {
    "parse spinbox" in {
      question must succeedOn("var1 spinbox")
        .withResult(Question(Variable("var1"), SpinBox(List())))
    }
    "parse slider" in {
      question must succeedOn("var1 slider")
        .withResult(Question(Variable("var1"), Slider(List())))
    }
    "parse text" in {
      question must succeedOn("var1 text")
        .withResult(Question(Variable("var1"), Text(List())))
    }
    "parse textBlock" in {
      question must succeedOn("var1 textBlock")
        .withResult(Question(Variable("var1"), TextBlock(List())))
    }
    "parse radio" in {
      question must succeedOn("var1 radio")
        .withResult(Question(Variable("var1"), Radio(List())))
    }
    "parse dropdown" in {
      question must succeedOn("var1 dropdown")
        .withResult(Question(Variable("var1"), DropDown(List())))
    }
    "parse spinbox with style" in {
      question must succeedOn("var1 spinbox {" +
          "width: 400" +
          "font: \"Arial\"" +
          "fontSize: 14" +
          "color: #99FF66" +
        "}")
        .withResult(Question(Variable("var1"),SpinBox(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
    "parse slider with style" in {
      question must succeedOn("var1 slider {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Question(Variable("var1"),Slider(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
    "parse text with style" in {
      question must succeedOn("var1 text {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Question(Variable("var1"),Text(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
    "parse textBlock with style" in {
      question must succeedOn("var1 textBlock {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Question(Variable("var1"),TextBlock(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
    "parse radio with style" in {
      question must succeedOn("var1 radio {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Question(Variable("var1"),Radio(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
    "parse dropdown with style" in {
      question must succeedOn("var1 dropdown {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Question(Variable("var1"),DropDown(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
    "parse question sequence" in {
      sectionElements must succeedOn("{" +
        "var1 dropdown" +
        "var2 dropdown" +
      "}"
      )
        .withResult(List(Question(Variable("var1"),DropDown(List())), Question(Variable("var2"),DropDown(List()))))
    }
  }

  "section parser" should {
    "parse section" in {
      parsers.section must succeedOn("section \"section1\" {" +
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
        "}")
        .withResult(Section("section1", List(Question(Variable("var1"),DropDown(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))),Question(Variable("var2"),Slider(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))))
    }
    "parse section in section" in {
      parsers.section must succeedOn("section \"section1\" {" +
        "var1 slider" +
        "section \"section2\" {" +
          "var2 dropdown" +
        "}" +
      "}")
        .withResult(Section("section1",List(Question(Variable("var1"),Slider(List())), Section("section2",List(Question(Variable("var2"),DropDown(List())))))))
    }
  }

  "page parser" should {
    "parse page" in {
      page must succeedOn("page page1 {" +
          "section \"section1\" {}" +
          "section \"section2\" {}" +
        "}")
        .withResult(Page("page1",List(Section("section1",List()),Section("section2",List()))))
    }
  }

  "style parser" should {
    "parse style" in {
      styleSheet must succeedOn("style PartyForm {" +
          "default boolean slider" +
          "page page1 {}" +
          "page page2 {}" +
        "}")
        .withResult(StyleSheet("PartyForm",List(DefaultWidget(BooleanType(), Slider(List())), Page("page1", List()), Page("page2", List()))))
    }
  }

  "defaultWidget parser" should {
    "parse default number spinbox with style" in {
      defaultWidget must succeedOn("default number spinbox {" +
          "width: 400" +
          "font: \"Arial\"" +
          "fontSize: 14" +
          "color: #99FF66" +
        "}")
        .withResult(DefaultWidget(NumberType(),SpinBox(List(Width(400), Font("Arial"), FontSize(14), FontColor(HexadecimalColor("99FF66"))))))
    }
  }


}
