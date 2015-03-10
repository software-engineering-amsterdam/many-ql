package qls.ast

sealed trait StyleProperty
case class Width(v: Int) extends StyleProperty
case class Font(v: String) extends StyleProperty
case class FontSize(v: Int) extends StyleProperty
case class FontColor(v: HexadecimalColor) extends StyleProperty

case class HexadecimalColor(v: String)