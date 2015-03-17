package qls.ast

import ql.ast.{Type, Variable}

import scala.util.parsing.input.Positional

sealed trait StyleSheetElement
sealed trait SectionElement

case class StyleSheet(label: String, elements: List[StyleSheetElement])
case class DefaultWidget(_type: Type, widget: Widget) extends StyleSheetElement
case class Page(variable: Variable, sections: List[Section]) extends StyleSheetElement
case class Section(title: String, elements: List[SectionElement]) extends SectionElement
case class Question(variable: Variable, widget: Widget) extends SectionElement with Positional
