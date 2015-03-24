package ql.gui.widgets

import ql.ast.{BooleanValue, Expression, Question, Value}
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
  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      checkBox.selected = eval()
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, BooleanValue())
      checkBox.selected = extract(value)
    }
  }

  def eval(): Boolean = {
    val value = q.expression match {
      case Some(e) => evaluator.eval(e, env)
      case None => BooleanValue()
    }
    extract(value)
  }

  def extract(value: Value): Boolean = {
    value match {
      case BooleanValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Boolean.")
    }
  }
}
