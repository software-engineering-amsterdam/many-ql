package qls.typechecker

import ql.ast.Type
import ql.typechecker.Error
import qls.ast.{DefaultWidget, Page, Question, Section, StyleSheet, Widget}
import types.TypeEnvironment

import scala.util.parsing.input.Position

class TypeChecker {

  def check(s: StyleSheet, env: TypeEnvironment): List[Error] = {
    s.elements.flatMap {
      case dw: DefaultWidget => check(dw.widget, dw._type, dw.pos)
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
    val widget = q.widget
    val _type = env getOrElse(name, throw new AssertionError(s"Error in type checker. Undefined variable $name."))

    check(widget, _type, q.pos)
  }

  def check(w: Widget, t: Type, p: Position): Option[Error] = {
    if (w._type.allowsType(t)) {
      None
    } else {
      Some(Error(s"${w._type.toString.capitalize} widget not allowed for type $t", Some(p)))
    }
  }
}
