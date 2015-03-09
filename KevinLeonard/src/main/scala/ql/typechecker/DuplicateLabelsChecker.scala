package ql.typechecker

import ql.ast._

class DuplicateLabelsChecker {

  type Warning = String

  def check(form: Form): List[Warning] = {
    val labels = check(form.s)
    labels.groupBy(identity).collect({
      case (label, equalLabels) if equalLabels.size > 1 => s"Label \'$label\' is used ${equalLabels.size} times"
    }).toList
  }

  private def check(s: Statement, labels: List[String] = List()): List[String] = s match {
    case Sequence(statements) => statements.flatMap(s => check(s, labels))
    case Question(_, _, label, _) => label :: labels
    case _: IfStatement => labels
  }
}
