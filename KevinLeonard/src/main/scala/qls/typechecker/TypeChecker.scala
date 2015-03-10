package qls.typechecker

import ql.typechecker.{Error, TypeEnvironment}
import qls.ast.{Question, Section}

// - no references to questions that are not in the QL program
// - all questions of the QL program are placed by the QLS program.
// - (default) widget assignments are compatible with question types (e.g. no radio button for integer widgets).
// - you cannot place a single question multiple times.
class TypeChecker {

  def check(s: Section, env: TypeEnvironment): List[Error] = {
    s.questions.flatMap(q => check(q, env))
  }

  def check(q: Question, env: TypeEnvironment): Option[Error] = {
    env.tryGetVariable(q.variable) match {
      case Right(_) => None
      case Left(e) => Some(e)
    }
  }

}
