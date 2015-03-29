package qls.typechecker

import qls.ast.{DefaultWidget, Page, Question, Section, StyleSheet}

object Questions {

  def extract(s: StyleSheet): List[Question] = {
    s.elements.flatMap {
      case _: DefaultWidget => List()
      case Page(_, sections) => sections.flatMap(extract)
    }
  }

  def extract(s: Section): List[Question] = {
    s.elements.flatMap {
      case s: Section => extract(s)
      case q: Question => List(q)
    }
  }

}
