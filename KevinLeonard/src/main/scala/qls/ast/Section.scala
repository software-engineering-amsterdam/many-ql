package qls.ast

import ql.ast.Variable

case class Section(title: String, questions: List[Question], default: List[DefaultWidget])
case class Page(v: Variable, s: List[Section], default: List[DefaultWidget])
case class Style(label: String, pages: List[Page], default: List[DefaultWidget])
