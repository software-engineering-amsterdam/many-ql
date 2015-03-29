package qls.typechecker

import qls.ast._
import types.VariableName

object Variables {

  def getVariableNames(s: StyleSheet): List[VariableName] = {
    s.elements.flatMap {
      case _: DefaultWidget => List()
      case Page(_, sections) => sections.flatMap(getVariableNames)
    }
  }

  def getVariableNames(s: Section): List[VariableName] = {
    s.elements.flatMap {
      case s: Section => getVariableNames(s)
      case q: Question => List(q.variable.name)
    }
  }
}
