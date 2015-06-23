package qls.typechecker

import ql.typechecker.Error
import qls.ast.StyleSheet
import types.TypeEnvironment

class QuestionPlacementChecker {

  def check(s: StyleSheet, env: TypeEnvironment): Option[Error] = {
    val qlVariableNames = env.keySet
    val qlsVariableNames = Variables.getVariableNames(s)
    val notPlacedQuestion = qlVariableNames -- qlsVariableNames

    if (notPlacedQuestion.nonEmpty) {
      Some(Error(s"The question(s) ${notPlacedQuestion.mkString(", ")} are not placed"))
    } else {
      None
    }
  }
}
