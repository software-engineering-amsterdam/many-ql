package qls.typechecker

import ql.typechecker.{Error, TypeEnvironment}
import qls.ast.{Question, Section}

class ReferenceChecker {

  def check(s: Section, env: TypeEnvironment): List[Error] = {
    s.questions.flatMap(q => check(q, env))
  }

  def check(q: Question, env: TypeEnvironment): Option[Error] = {
    // TODO: refactor? (Either -> Option) and Error message
    env.tryGetVariable(q.variable) match {
      case Right(_) => None
      case Left(e) => Some(e)
    }
  }
}
