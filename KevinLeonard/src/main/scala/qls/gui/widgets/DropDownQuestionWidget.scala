package qls.gui.widgets

import ql.ast.{Value, BooleanValue, Expression, Question}
import ql.gui.widgets.QuestionWidget
import types._

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.ChoiceBox

class DropDownQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  val Yes = "Yes"
  val No = "No"

  val options = ObservableBuffer(Yes, No)
  val _value = eval()
  val choiceBox = new ChoiceBox[String]() {
    items = options
    value = _value match {
      case true => Yes
      case false => No
    }
    value.onChange((_, _, newValue) => newValue match {
      case Yes => updateEnvironment(BooleanValue(true))
      case No => updateEnvironment(BooleanValue(false))
    })
  }
  updateEnvironment(BooleanValue(_value))
  children.add(choiceBox)

  // Methods
  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      choiceBox.value = eval() match {
        case true => Yes
        case false => No
      }
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, BooleanValue())
      choiceBox.value = extract(value) match {
        case true => Yes
        case false => No
      }
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
