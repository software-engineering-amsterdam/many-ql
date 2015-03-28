package ql.gui

import ql.ast._
import ql.evaluator.Evaluator
import ql.gui.widgets.{NumberQuestionWidget, BooleanQuestionWidget, StringQuestionWidget}
import types.EvalEnvironment

import scalafx.collections.ObservableMap
import scalafx.scene.layout.VBox

class FormBuilder(env: EvalEnvironment = ObservableMap.empty) {

  // TODO: Can't find any usages of evaluator? Remove this line?
  val evaluator = new Evaluator()

  def build(f: Form): FormGUI = {
    new FormGUI(f.label, build(f.statements))
  }

  def build(s: Statement, visibilityExpressions: List[Expression] = List()): List[VBox] = s match {
    case Sequence(statements) => statements.flatMap(s => build(s, visibilityExpressions))
    case i: IfStatement => buildIfStatement(i, visibilityExpressions)
    case q: Question => List(buildQuestion(q, visibilityExpressions))
  }

  def buildIfStatement(i: IfStatement, visibilityExpressions: List[Expression]): List[VBox] = {
    val ifBlock = build(i.ifBlock, i.expression :: visibilityExpressions)
    val elseBlock = i.elseBlock match {
      case Some(s) => build(s, Not(i.expression) :: visibilityExpressions)
      case None => List()
    }
    ifBlock ++ elseBlock
  }

  def buildQuestion(q: Question, visibilityExpressions: List[Expression]): VBox = {
    q._type match {
      case BooleanType() => new BooleanQuestionWidget(q, visibilityExpressions, env)
      case NumberType() => new NumberQuestionWidget(q, visibilityExpressions, env)
      case StringType() => new StringQuestionWidget(q, visibilityExpressions, env)
    }
  }
}
