package ql.gui.widgets

import ql.ast._
import types._

import scalafx.scene.control.CheckBox

class BooleanQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  // Initialize CheckBox
  val value = eval()
  val checkBox = new CheckBox {
    selected = value
    selected.onChange((_, _, newValue) => updateEnvironment(BooleanValue(newValue)))
  }
  updateEnvironment(BooleanValue(value))
  children.add(checkBox)

  // Methods
  override def updateValue(updatedVariable: VariableName): Unit = {
    if (valueDependencies contains updatedVariable) {
      checkBox.selected = eval()
    }
  }

  def eval(): Boolean = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case BooleanValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Boolean.")
    }
    case None => false
  }
}
