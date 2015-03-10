package qls.ast

import ql.ast.Variable

case class Section(title: String, questions: List[Question])
case class Page(v: Variable, s: List[Section])
case class Style(label: String, pages: List[Page])
