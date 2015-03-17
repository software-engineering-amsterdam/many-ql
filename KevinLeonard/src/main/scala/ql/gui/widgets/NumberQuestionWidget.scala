package ql.gui.widgets

import ql.ast.{Expression, NumberValue, Question}
import types._

import scalafx.scene.control.TextField

class NumberQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  // Initialize TextField
  val value = eval()
  val textField = new TextField {
    text = value.toString
    text.onChange((_, _, newValue) => {
      if (isValidInput(newValue)) {
        style = ValidStyle
        updateEnvironment(NumberValue(newValue.toInt))
      } else {
        style = InvalidStyle
      }
    })
  }
  updateEnvironment(NumberValue(value))
  children.add(textField)

  // Methods
  override def updateValue(updatedVariable: VariableName): Unit = {
    if (valueDependencies contains updatedVariable) {
      textField.text = eval().toString
    }
  }

  def isValidInput(input: String): Boolean = input.matches("^-?\\d+$")

  def eval(): Int = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case NumberValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Number.")
    }
    case None => 0
  }
}
