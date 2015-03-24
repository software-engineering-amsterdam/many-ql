package qls.typechecker

import ql.typechecker.Error
import qls.ast.StyleSheet

class DuplicatePlacementChecker {

  def check(s: StyleSheet): List[Error] = {
    val variableNames = Variables.getVariableNames(s)

    variableNames.groupBy(identity).collect({
      case (name, equalNames) if equalNames.size > 1 => Error(s"Question $name is placed ${equalNames.size} times")
    }).toList
  }
}
