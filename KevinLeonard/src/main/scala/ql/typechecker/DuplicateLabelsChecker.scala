package ql.typechecker

import ql.ast.{Form, IfStatement, Question, Sequence, Statement}
import types.Label

class DuplicateLabelsChecker {

  def check(f: Form): List[Warning] = {
    val labels = getLabels(f.statements)
    labels.groupBy(identity).collect({
      case (label, equalLabels) if equalLabels.size > 1 => Warning(s"Label \'$label\' is used ${equalLabels.size} times")
    }).toList
  }

  private def getLabels(s: Statement, ls: List[Label] = List()): List[Label] = s match {
    case Sequence(statements) => statements.flatMap(s => getLabels(s, ls))
    case Question(_, _, l, _) => l :: ls
    case IfStatement(_, ifBlock, None) => getLabels(ifBlock) ++ ls
    case IfStatement(_, ifBlock, Some(elseBlock)) => getLabels(ifBlock) ++ getLabels(elseBlock) ++ ls
  }
}
