package qls.ast

import ql.ast.Variable

case class Section(title: String, questions: List[Question], default: Option[List[DefaultWidget]])
case class Page(v: Variable, s: List[Section], default: Option[List[DefaultWidget]])
case class Style(label: String, pages: List[Page], default: Option[List[DefaultWidget]])
