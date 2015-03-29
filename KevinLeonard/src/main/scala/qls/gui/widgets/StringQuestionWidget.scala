package qls.gui.widgets

import ql.ast.{Value, StringValue, Expression, Question}
import qls.ast.Style
import types.{EvalEnvironment, VariableName}

import scalafx.scene.control.TextField

class StringQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style])
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style]) {

  // Initialize TextField
  val value = eval()
  val textField = new TextField {
    text = value
    text.onChange((_, _, newValue) => updateEnvironment(StringValue(newValue)))
  }
  updateEnvironment(StringValue(value))
  children.add(textField)

  // Methods
  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      textField.text = eval()
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, StringValue())
      textField.text = extract(value)
    }
  }

  def eval(): String = {
    val value = q.expression match {
      case Some(e) => evaluator.eval(e, env)
      case None => StringValue()
    }
    extract(value)
  }

  def extract(value: Value): String = {
    value match {
      case StringValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type String.")
    }
  }
}
