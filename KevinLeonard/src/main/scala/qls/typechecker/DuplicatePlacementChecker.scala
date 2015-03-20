package qls.typechecker

import ql.typechecker.Error
import qls.ast.{Question, Section}

class DuplicatePlacementChecker {

  def check(s: Section): List[Error] = {
    val names = s.elements.map({
      case q: Question => q.variable.name
    })
    names.groupBy(identity).collect({
      case (name, equalNames) if equalNames.size > 1 => Error(s"Question $name is placed ${equalNames.size} times")
    }).toList
  }
}
