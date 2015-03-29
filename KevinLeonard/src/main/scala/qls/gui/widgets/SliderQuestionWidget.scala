package qls.gui.widgets

import ql.ast.{Expression, NumberValue, Question, Value}
import qls.ast.Style
import types.{EvalEnvironment, VariableName}

import scalafx.scene.control.Slider

class SliderQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style])
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style]) {

  val DefaultMin = 0
  val DefaultMax = 100

  val value = eval()
  val sliderField = new Slider {
    min = DefaultMin
    max = DefaultMax
    value = DefaultMin
    value.onChange((_, _, newValue) => {
      updateEnvironment(NumberValue(newValue.intValue()))
    })
    showTickLabels = true
    snapToTicks = true
    maxWidth = MaxWidth
  }
  updateEnvironment(NumberValue(value))
  children.add(sliderField)

  override def updateValue(updatedVariable: VariableName, becameVisible: Boolean): Unit = {
    if (valueDependencies contains updatedVariable) {
      sliderField.value = eval().toDouble
    }

    // Needed in order to keep multiple questions with the same key in sync
    if (isQuestionWithSameKey(updatedVariable) || becameVisible) {
      val value = env.getOrElse(q.variable.name, NumberValue())
      sliderField.value = extract(value).toDouble
    }
  }

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
