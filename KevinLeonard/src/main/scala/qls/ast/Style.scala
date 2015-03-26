package qls.ast

sealed trait Style
case class Width(v: Int) extends Style
case class Font(v: String) extends Style
case class FontSize(v: Int) extends Style
case class FontColor(v: HexadecimalColor) extends Style

case class HexadecimalColor(v: String)
