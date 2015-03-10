package qls.parser

import qls.ast._

import ql.ast.Variable
import ql.parser.{Parser => QLParser}

import scala.util.parsing.combinator.JavaTokenParsers


class Parser extends JavaTokenParsers {

  val qlParsers = new QLParser

  // general parsers
  override val whiteSpace = qlParsers.whiteSpace
  def variable: Parser[Variable] = ident ^^ Variable

  
  
  def section: Parser[Section] = "section" ~> stringLiteral ~ questions ^^ {
    case t ~ w => Section(t.substring(1, t.length - 1).replace("\\", ""), w)
  }
  
  def questions: Parser[QuestionSequence] = "{" ~> rep(question) <~ "}" ^^ QuestionSequence
  
  // question widget parsers
  def question: Parser[Question] = variable ~ widget ^^ {
    case v ~ w => Question(v, w)
  }
  
  def widget: Parser[Widget] = widgetType ~ opt(widgetStyle) ^^ {
    case "spinbox" ~ properties => Spinbox(properties)
    case "slider" ~ properties => Slider(properties)
    case "text" ~ properties => Text(properties)
    case "textBlock" ~ properties => TextBlock(properties)
    case "radio" ~ properties => Radio(properties)
    case "dropdown" ~ properties => Dropdown(properties)
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

  def hexadecimalColor: Parser[HexadecimalColor] = "#" ~> """([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})""".r ^^ { v => HexadecimalColor(v) }

}
