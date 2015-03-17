package qls.typechecker

import ql.typechecker.Error
import qls.ast.{Question, Section}
import types.{TypeEnvironment, VariableName}

class QuestionPlacementChecker {

  def check(s: Section, env: TypeEnvironment): Option[Error] = {
    val qlVariables = env.keySet
    val qlsVariables = s.elements.map({
      case q: Question => getVariableName(q)
    })
    val notPlacedQuestion = qlVariables -- qlsVariables

    if (notPlacedQuestion.nonEmpty) {
      Some(Error(s"The question(s) ${notPlacedQuestion.mkString(", ")} are not placed"))
    } else {
      None
    }
  }

  private def getVariableName(q: Question): VariableName = {
    q.variable.name
  }
}
