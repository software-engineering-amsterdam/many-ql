package qls.typechecker

import ql.typechecker.Error
import qls.ast.Section

class DuplicatePlacementChecker {

  def check(s: Section): List[Error] = {
    val names = s.questions.map(_.variable.name)
    names.groupBy(identity).collect({
      case (name, equalNames) if equalNames.size > 1 => new Error(s"Question $name is placed ${equalNames.size} times")
    }).toList
  }
}
