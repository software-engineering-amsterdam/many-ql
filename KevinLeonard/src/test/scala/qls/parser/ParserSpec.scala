package qls.parser

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import ql.ast.Variable
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

  "property parser" should {
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
        .withResult(FontColor(new HexadecimalColor("00ff00")))
    }
  }
  
  "widget style" should {
    "parse style block" in {
      widgetStyle must succeedOn("{" +
          "width: 400" +
          "font: \"Arial\"" +
          "fontSize: 14" +
          "color: #99FF66" +
        "}")
        .withResult(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))
    }
    
  }
  
  "widget parser" should {
    "parse spinbox" in {
      widget must succeedOn("var1 spinbox")
        .withResult(SpinBox(Variable("var1"), None))
    }
    "parse slider" in {
      widget must succeedOn("var1 slider")
        .withResult(Slider(Variable("var1"), None))
    }
    "parse text" in {
      widget must succeedOn("var1 text")
        .withResult(Text(Variable("var1"), None))
    }
    "parse textBlock" in {
      widget must succeedOn("var1 textBlock")
        .withResult(TextBlock(Variable("var1"), None))
    }
    "parse radio" in {
      widget must succeedOn("var1 radio")
        .withResult(Radio(Variable("var1"), None))
    }
    "parse dropdown" in {
      widget must succeedOn("var1 dropdown")
        .withResult(DropDown(Variable("var1"), None))
    }
    "parse spinbox with style" in {
      widget must succeedOn("var1 spinbox {" +
          "width: 400" +
          "font: \"Arial\"" +
          "fontSize: 14" +
          "color: #99FF66" +
        "}")
        .withResult(SpinBox(Variable("var1"),Some(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))))
    }
    "parse slider with style" in {
      widget must succeedOn("var1 slider {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Slider(Variable("var1"),Some(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))))
    }
    "parse text with style" in {
      widget must succeedOn("var1 text {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Text(Variable("var1"),Some(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))))
    }
    "parse textBlock with style" in {
      widget must succeedOn("var1 textBlock {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(TextBlock(Variable("var1"),Some(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))))
    }
    "parse radio with style" in {
      widget must succeedOn("var1 radio {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(Radio(Variable("var1"),Some(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))))
    }
    "parse dropdown with style" in {
      widget must succeedOn("var1 dropdown {" +
        "width: 400" +
        "font: \"Arial\"" +
        "fontSize: 14" +
        "color: #99FF66" +
        "}")
        .withResult(DropDown(Variable("var1"),Some(List(Width(400), Font("Arial"), FontSize(14), FontColor(new HexadecimalColor("99FF66"))))))
    }
  }
}
