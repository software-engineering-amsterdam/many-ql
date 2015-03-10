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
  def question: Parser[Question] = variable ~ widget ^^ {
    case v ~ w => Question(v, w)
  }
  
  def questionType: Parser[Type] = ("boolean" | "number" | "string") ^^ {
    case "boolean" => BooleanType()
    case "number" => NumberType()
    case "string" => StringType()
  }
  
  def widget: Parser[Widget] = widgetType ~ opt(widgetStyle) ^^ {
    case "spinbox" ~ Some(properties) => SpinBox(properties)
    case "spinbox" ~ None => SpinBox(List())
    case "slider" ~ Some(properties) => Slider(properties)
    case "slider" ~ None => Slider(List())
    case "text" ~ Some(properties) => Text(properties)
    case "text" ~ None => Text(List())
    case "textBlock" ~ Some(properties) => TextBlock(properties)
    case "textBlock" ~ None => TextBlock(List())
    case "radio" ~ Some(properties) => Radio(properties)
    case "radio" ~ None => Radio(List())
    case "dropdown" ~ Some(properties) => DropDown(properties)
    case "dropdown" ~ None => DropDown(List())
  }
  
  def defaultWidget: Parser[DefaultWidget] = "default" ~> questionType ~ widget ^^ {
    case t ~ w => DefaultWidget(t, w)
  }
  
  def widgetType: Parser[String] = ("spinbox" | "slider" | "textBlock" | "text" | "radio" | "dropdown")

  // TODO: Repetition of the same property is not allowed.
  def widgetStyle: Parser[List[StyleProperty]] = "{" ~> rep(width | font | fontSize | fontColor) <~ "}"
  
  def width: Parser[StyleProperty] = "width:" ~> wholeNumber ^^ { v => Width(v.toInt) }
  def font: Parser[StyleProperty] = "font:" ~> stringLiteral ^^ { 
    v => Font(v.substring(1, v.length - 1).replace("\\", ""))
  }
  def fontSize: Parser[StyleProperty] = "fontSize:" ~> wholeNumber ^^ { v => FontSize(v.toInt) }
  def fontColor: Parser[StyleProperty] = "color:" ~> hexadecimalColor ^^ { v => FontColor(v) }

  def hexadecimalColor: Parser[HexadecimalColor] = "#" ~> """([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})""".r ^^ { v => new HexadecimalColor(v) }

}
