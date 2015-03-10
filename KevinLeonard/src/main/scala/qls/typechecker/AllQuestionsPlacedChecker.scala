package qls.typechecker

import ql.typechecker.{Error, TypeEnvironment}
import qls.ast.{Question, Section}
import types.VariableName

import scala.util.parsing.input.NoPosition

// - all questions of the QL program are placed by the QLS program.
// - (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
// - you cannot place a single question multiple times.
class AllQuestionsPlacedChecker {

  def check(s: Section, env: TypeEnvironment): Option[Error] = {
    // TODO fix env.env
    val qlVariables = env.env.keySet
    val qlsVariables = s.questions.map(getVariableName)
    val notPlacedQuestion = qlVariables -- qlsVariables

    if (!notPlacedQuestion.isEmpty) {
      // TODO: remove NoPosition
      Some(new Error(s"The question(s) ${notPlacedQuestion.mkString(", ")} are not placed", NoPosition))
    } else {
      None
    }
  }

  private def getVariableName(q: Question): VariableName = {
    q.variable.name
  }
}
