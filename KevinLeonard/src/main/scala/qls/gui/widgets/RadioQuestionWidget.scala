package qls.gui.widgets

import ql.ast.{Value, BooleanValue, Expression, Question}
import types._

import scalafx.scene.control.RadioButton

class RadioQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  val value = eval()
  val radioButtonYes = new RadioButton() {
    selected = value
    selected.onChange((_, _, newValue) => updateEnvironment(BooleanValue(newValue)))
  }
  val radioButtonNo = new RadioButton() {
    selected = !value
    selected.onChange((_, _, newValue) => updateEnvironment(BooleanValue(!newValue)))
  }
  updateEnvironment(BooleanValue(value))
  children.add(radioButtonYes)
  children.add(radioButtonNo)

  // Methods
  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      radioButtonYes.selected = eval()
      radioButtonNo.selected = !eval()
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, BooleanValue())
      radioButtonYes.selected = extract(value)
      radioButtonNo.selected = !extract(value)
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
