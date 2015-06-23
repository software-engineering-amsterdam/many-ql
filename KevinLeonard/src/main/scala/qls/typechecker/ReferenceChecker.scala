package qls.typechecker

import ql.typechecker.Error
import qls.ast.{DefaultWidget, Page, Question, Section, StyleSheet}
import types.TypeEnvironment

class ReferenceChecker {

  def check(s: StyleSheet, env: TypeEnvironment): List[Error] = {
    s.elements.flatMap {
      case _: DefaultWidget => List()
      case Page(_, sections) => sections.flatMap(check(_, env))
    }
  }

  def check(s: Section, env: TypeEnvironment): List[Error] = {
    s.elements.flatMap {
      case s: Section => check(s, env)
      case q: Question => check(q, env)
    }
  }

  def check(q: Question, env: TypeEnvironment): Option[Error] = {
    val name = q.variable.name
    env get name match {
      case Some(_) => None
      case None => Some(Error(s"Question $name is not defined in your QL program", Some(q.pos)))
    }
  }
}
