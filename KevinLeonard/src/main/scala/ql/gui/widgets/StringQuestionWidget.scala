package ql.gui.widgets

import ql.ast.{Expression, Question, StringValue}
import types._

import scalafx.scene.control.TextField

class StringQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  // Initialize TextField
  val value = eval()
  val textField = new TextField {
    text = value
    text.onChange((_, _, newValue) => updateEnvironment(StringValue(newValue)))
  }
  updateEnvironment(StringValue(value))
  children.add(textField)

  // Methods
  override def updateValue(updatedVariable: VariableName): Unit = {
    if (valueDependencies contains updatedVariable) {
      textField.text = eval()
    }
  }

  def eval(): String = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case StringValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type String.")
    }
    case None => ""
  }
}
