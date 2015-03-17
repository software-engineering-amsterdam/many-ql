package ql.gui.widgets

import ql.ast.{Expression, NumberValue, Question}
import types._

import scalafx.collections.ObservableMap.{Add, Replace}
import scalafx.scene.control.TextField

class NumberQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  // Initialize TextField
  val value = eval
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

  // Observer for environment
  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(textField, addedName)
    case Replace(replacedName, _, _) => updateProperties(textField, replacedName)
  })

  // Methods
  def isValidInput(input: String): Boolean = input.matches("^-?\\d+$")

  def updateProperties(field: TextField, name: VariableName): Unit = {
    updateVisibility(name)
    if (isVisible) {
      updateValue(field, name, eval)
    }
  }

  def updateValue(field: TextField, name: VariableName, value: Int): Unit = {
    if (valueDependencies contains name) {
      field.text = value.toString
    }
  }

  def eval: Int = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case NumberValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Number.")
    }
    case None => 0
  }
}
