package qls.typechecker

import ql.typechecker.Error
import qls.ast.{DefaultWidget, Page, Question, Section, StyleSheet}
import types.{TypeEnvironment, VariableName}

class QuestionPlacementChecker {

  def check(s: StyleSheet, env: TypeEnvironment): Option[Error] = {
    val qlVariables = env.keySet
    val qlsVariables = getVariables(s)
    val notPlacedQuestion = qlVariables -- qlsVariables

    if (notPlacedQuestion.nonEmpty) {
      Some(Error(s"The question(s) ${notPlacedQuestion.mkString(", ")} are not placed"))
    } else {
      None
    }
  }

  def getVariables(s: StyleSheet): List[VariableName] = {
    s.elements.flatMap {
      case _: DefaultWidget => List()
      case Page(_, sections) => sections.flatMap(getVariables)
    }
  }

  def getVariables(e: Section): List[VariableName] = {
    e.elements.flatMap {
      case s: Section => getVariables(s)
      case Question(v, _) => List(v.name)
    }
  }
}
