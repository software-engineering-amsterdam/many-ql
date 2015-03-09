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

  
  
//  def section: Parser[Section] = "section" ~> stringLiteral ~ widgets ^^ {
//    title ~ widgets = new Section(title, widgets)
//  }
  
  def widgets: Parser[WidgetSequence] = "{" ~> rep(widget) <~ "}" ^^ WidgetSequence
  
  // question widget parsers
  def widget: Parser[Widget] = variable ~ widgetType ~ opt(widgetStyle) ^^ {
    case v ~ "spinbox" ~ properties => Spinbox(v, properties)
    case v ~ "slider" ~ properties => Slider(v, properties)
    case v ~ "text" ~ properties => Text(v, properties)
    case v ~ "textBlock" ~ properties => TextBlock(v, properties)
    case v ~ "radio" ~ properties => Radio(v, properties)
    case v ~ "dropdown" ~ properties => Dropdown(v, properties)
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
