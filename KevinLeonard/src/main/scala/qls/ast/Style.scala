package qls.ast

sealed trait Style
case class Width(value: Int) extends Style
case class Font(value: String) extends Style
case class FontSize(value: Int) extends Style
case class FontColor(value: HexadecimalColor) extends Style
