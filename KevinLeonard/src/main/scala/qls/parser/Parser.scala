package qls.parser

import ql.ast._
import qls.ast.Question
import qls.ast._

import ql.parser.{Parser => QLParser}

import scala.util.parsing.combinator.JavaTokenParsers


class Parser extends JavaTokenParsers {

  val qlParsers = new QLParser

  // general parsers
  override val whiteSpace = qlParsers.whiteSpace
  def variable: Parser[Variable] = ident ^^ Variable

  def style: Parser[Style] = "style" ~> ident ~ pages ^^ {
    case label ~ ps => Style(label, ps, List())
  }
  
  def pages: Parser[List[Page]] = "{" ~> rep(page) <~ "}"
  
  def page: Parser[Page] = "page" ~> variable ~ sections ^^ {
    case v ~ ss => Page(v, ss, List())
  }
  
  def sections: Parser[List[Section]] = "{" ~> rep(section) <~ "}"
  
  def section: Parser[Section] = "section" ~> stringLiteral ~ questions ^^ {
    case t ~ w => Section(t.substring(1, t.length - 1).replace("\\", ""), w, List())
  }
  
  def questions: Parser[List[Question]] = "{" ~> rep(question) <~ "}"
  
  // question widget parsers
  // TODO: add positioned parser
  def question: Parser[Question] = variable ~ widget ^^ {
    case v ~ w => Question(v, w)
  }
  
  def questionType: Parser[Type] = ("boolean" | "number" | "string") ^^ {
    case "boolean" => BooleanType()
    case "number" => NumberType()
    case "string" => StringType()
  }
  
  def widget: Parser[Widget] = widgetType ~ widgetStyle ^^ {
    case "spinbox" ~ properties => SpinBox(properties)
    case "slider" ~ properties => Slider(properties)
    case "text" ~ properties => Text(properties)
    case "textBlock" ~ properties => TextBlock(properties)
    case "radio" ~ properties => Radio(properties)
    case "checkbox" ~ properties => CheckBox(properties)
    case "dropdown" ~ properties => DropDown(properties)
  }
  
  def defaultWidget: Parser[DefaultWidget] = "default" ~> questionType ~ widget ^^ {
    case t ~ w => DefaultWidget(t, w)
  }
  
  def widgetType: Parser[String] = "spinbox" | "slider" | "textBlock" | "text" | "radio" | "checkbox" | "dropdown"

  // TODO: Repetition of the same property is not allowed.
  def widgetStyle: Parser[List[StyleProperty]] = opt("{" ~> rep(width | font | fontSize | fontColor) <~ "}") ^^ {
    case Some(properties) => properties
    case None => List()
  }
  
  def width: Parser[StyleProperty] = "width:" ~> wholeNumber ^^ { v => Width(v.toInt) }
  def font: Parser[StyleProperty] = "font:" ~> stringLiteral ^^ { 
    v => Font(v.substring(1, v.length - 1).replace("\\", ""))
  }
  def fontSize: Parser[StyleProperty] = "fontSize:" ~> wholeNumber ^^ { v => FontSize(v.toInt) }
  def fontColor: Parser[StyleProperty] = "color:" ~> hexadecimalColor ^^ { v => FontColor(v) }

  def hexadecimalColor: Parser[HexadecimalColor] = "#" ~> """([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})""".r ^^ { v => new HexadecimalColor(v) }

}
