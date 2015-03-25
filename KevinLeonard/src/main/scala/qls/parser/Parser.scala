package qls.parser

import ql.ast._
import qls.ast.Question
import qls.ast._

import ql.parser.{Parser => QLParser}

import scala.util.parsing.combinator.JavaTokenParsers

class Parser extends JavaTokenParsers {

  var qlParser = new QLParser

  // general parsers
  override val whiteSpace = qlParser.whiteSpace
  def variable: Parser[Variable] = ident ^^ Variable
  def hexadecimalColor: Parser[HexadecimalColor] = "#" ~> """([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})""".r ^^ {
    v => new HexadecimalColor(v)
  }

  // style sheet parsers
  def styleSheet: Parser[StyleSheet] = "style" ~> ident ~ stylesheetElements ^^ {
    case label ~ sss => StyleSheet(label, sss)
  }
  def stylesheetElements: Parser[List[StyleSheetElement]] = "{" ~> rep(page | defaultWidget) <~ "}"

  // page parsers
  def page: Parser[StyleSheetElement] = "page" ~> ident ~ pageElements ^^ {
    case v ~ ps => Page(v, ps)
  }
  def pageElements: Parser[List[Section]] = "{" ~> rep(section) <~ "}"

  // section parsers
  def section: Parser[Section] = "section" ~> stringLiteral ~ sectionElements ^^ {
    case t ~ ss => Section(t.substring(1, t.length - 1).replace("\\", ""), ss)
  }
  def sectionElements: Parser[List[SectionElement]] = "{" ~> rep(question | section) <~ "}"

  // question parsers
  def question: Parser[Question] = positioned(variable ~ widget ^^ {
    case v ~ w => Question(v, w)
  })
  def questionType: Parser[Type] = ("boolean" | "number" | "string") ^^ {
    case "boolean" => BooleanType()
    case "number" => NumberType()
    case "string" => StringType()
  }

  // widget parsers
  def defaultWidget: Parser[DefaultWidget] = positioned("default" ~> questionType ~ widget ^^ {
    case t ~ w => DefaultWidget(t, w)
  })
  def widget: Parser[Widget] = widgetType ~ widgetStyle ^^ {
    case "spinbox" ~ properties => SpinBox(properties)
    case "slider" ~ properties => Slider(properties)
    case "text" ~ properties => Text(properties)
    case "textBlock" ~ properties => TextBlock(properties)
    case "radio" ~ properties => Radio(properties)
    case "checkbox" ~ properties => CheckBox(properties)
    case "dropdown" ~ properties => DropDown(properties)
  }
  def widgetType: Parser[String] = "spinbox" | "slider" | "textBlock" | "text" | "radio" | "checkbox" | "dropdown"
  def widgetStyle: Parser[List[StyleProperty]] = opt("{" ~> rep(width | font | fontSize | fontColor) <~ "}") ^^ {
    case Some(properties) => properties
    case None => List()
  }

  // style property parsers
  def width: Parser[StyleProperty] = "width:" ~> wholeNumber ^^ { v => Width(v.toInt) }
  def font: Parser[StyleProperty] = "font:" ~> stringLiteral ^^ {
    v => Font(v.substring(1, v.length - 1).replace("\\", ""))
  }
  def fontSize: Parser[StyleProperty] = "fontSize:" ~> wholeNumber ^^ { v => FontSize(v.toInt) }
  def fontColor: Parser[StyleProperty] = "color:" ~> hexadecimalColor ^^ { v => FontColor(v) }
}
