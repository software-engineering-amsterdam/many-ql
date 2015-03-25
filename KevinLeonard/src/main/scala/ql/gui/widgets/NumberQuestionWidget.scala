package ql.gui.widgets

import ql.ast.{Expression, NumberValue, Question, Value}
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
  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      textField.text = eval().toString
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, NumberValue())
      textField.text = extract(value).toString
    }
  }

  def isValidInput(input: String): Boolean = input.matches("^-?\\d+$")

  def eval(): Int = {
    val value = q.expression match {
      case Some(e) => evaluator.eval(e, env)
      case None => NumberValue()
    }
    extract(value)
  }

  def extract(value: Value): Int = {
    value match {
      case NumberValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Number.")
    }
  }
}
