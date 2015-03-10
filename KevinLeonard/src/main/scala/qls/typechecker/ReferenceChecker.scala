package qls.typechecker

import ql.typechecker.Error
import qls.ast.Section
import types.{TypeEnvironment, VariableName}

class ReferenceChecker {

  def check(s: Section, env: TypeEnvironment): List[Error] = {
    s.questions.flatMap(q => check(q.variable.name, env))
  }

  def check(name: VariableName, env: TypeEnvironment): Option[Error] = {
    env get name match {
      case Some(_) => None
      case None => Some(new Error(s"Question $name is not defined in your QL program"))
    }
  }
}
