package qls.ast

import ql.ast.{Type, Variable}



sealed trait StyleSheetElement
sealed trait PageElement
sealed trait SectionElement

case class Style(label: String, pages: List[StyleSheetElement])

case class DefaultWidget(_type: Type, widget: Widget) extends StyleSheetElement
case class Page(v: Variable, s: List[PageElement]) extends StyleSheetElement
case class Section(title: String, questions: List[SectionElement]) extends SectionElement with PageElement
case class Question(v: Variable, w: Widget) extends SectionElement
