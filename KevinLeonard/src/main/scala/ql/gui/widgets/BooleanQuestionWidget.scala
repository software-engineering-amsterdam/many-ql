package ql.gui.widgets

import ql.ast._
import types._

import scalafx.collections.ObservableMap.{Add, Replace}
import scalafx.scene.control.CheckBox

class BooleanQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  // Initialize CheckBox
  val value = eval
  val checkBox = new CheckBox {
    selected = value
    selected.onChange((_, _, newValue) => updateEnvironment(BooleanValue(newValue)))
  }
  updateEnvironment(BooleanValue(value))
  children.add(checkBox)

  // Observer for environment
  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(checkBox, addedName)
    case Replace(replacedName, _, _) => updateProperties(checkBox, replacedName)
  })

  // Methods
  def updateProperties(field: CheckBox, name: VariableName): Unit = {
    updateVisibility(name)
    if (isVisible) {
      updateValue(field, name, eval)
    }
  }

  def updateValue(field: CheckBox, name: VariableName, value: Boolean): Unit = {
    if (valueDependencies contains name) {
      field.selected = value
    }
  }

  def eval: Boolean = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case BooleanValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Boolean.")
    }
    case None => false
  }
}
