package ql.gui

import ql.ast.{Question, Expression, Value, BooleanValue, NumberValue, StringValue}
import ql.evaluator.Evaluator
import types.{Dependencies, EvalEnvironment, VariableName}

import scala.collection.immutable.StringOps
import scala.util.Try
import scalafx.beans.value.ObservableValue
import scalafx.collections.ObservableMap.{Add, Replace}
import scalafx.geometry.Insets
import scalafx.scene.control.{CheckBox, Label, TextField}
import scalafx.scene.layout.VBox

abstract class QuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends VBox {

  val evaluator = new Evaluator()
  val dependencyResolver = new DependencyResolver()

  val DefaultPadding: Int = 0
  val PaddingBottom: Int = 10
  val DefaultMargin: Int = 0
  val MarginBottom: Int = 10

  val valueDependencies: Dependencies = q.expression.fold[Dependencies](List())(e => dependencyResolver.resolve(e))
  val visibilityDependencies: Dependencies = visibilityExpressions.flatMap(e => dependencyResolver.resolve(e))

  visible = shouldBeVisible
  managed = isVisible
  padding = Insets(DefaultPadding, DefaultPadding, PaddingBottom, DefaultPadding)

  val label = new Label(q.label)
  label.margin = Insets(DefaultMargin, DefaultMargin, MarginBottom, DefaultMargin)
  children.add(label)

  def updateEnv(newValue: Value): Unit = env += (q.variable.name -> newValue)

  def updateVisibility(name: VariableName): Unit = if (visibilityDependencies contains name) {
    visible = shouldBeVisible
    managed = isVisible
  }

  def shouldBeVisible: Boolean = visibilityExpressions.forall(isTrue)

  def isTrue(e: Expression): Boolean = isTrue(evaluator.eval(e, env))

  def isTrue(v: Value): Boolean = v match {
    case BooleanValue(b) => b
    case _ => false
  }

  def isVisible: Boolean = visible.value
}

class BooleanQuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  type UpdateFunction = (ObservableValue[Boolean, java.lang.Boolean], java.lang.Boolean, java.lang.Boolean) => Unit

  val field = initialize(eval, (_, _, newValue) => { updateEnv(BooleanValue(newValue)) })
  def initialize(value: Boolean, updateEnvironment: UpdateFunction): CheckBox = {
    updateEnv(BooleanValue(value))
    val checkBox = new CheckBox
    checkBox.selected = value
    checkBox.selected.onChange(updateEnvironment)
    checkBox
  }
  children.add(field)

  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(field, addedName)
    case Replace(replacedName, _, _) => updateProperties(field, replacedName)
  })

  def updateProperties(field: CheckBox, name: VariableName): Unit = {
    updateVisibility(name)
    if (isVisible) {
      updateValue(field, name, eval)
    }
  }

  def updateValue(field: CheckBox, name: VariableName, value: Boolean): Unit =  if (valueDependencies contains name) {
    field.selected = value
  }

  def eval: Boolean = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case BooleanValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Boolean.")
    }
    case None => false
  }
}

class NumberQuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  type UpdateFunction = (ObservableValue[String, java.lang.String], java.lang.String, java.lang.String) => Unit

  val field = initialize(eval, (obs, oldValue, newValue) => {
    val newIntValue = Try(new StringOps(newValue).toInt).toOption.getOrElse(0)
    updateEnv(NumberValue(newIntValue))
  })
  def initialize(value: Int, updateEnvironment: UpdateFunction): TextField = {
    updateEnv(NumberValue(value))
    val textField = new TextField
    textField.text = value.toString
    textField.text.onChange(updateEnvironment)
    textField
  }
  children.add(field)

  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(field, addedName)
    case Replace(replacedName, _, _) => updateProperties(field, replacedName)
  })

  def updateProperties(field: TextField, name: VariableName): Unit = {
    updateVisibility(name)
    if (isVisible) {
      updateValue(field, name, eval)
    }
  }

  def updateValue(field: TextField, name: VariableName, value: Int): Unit =  if (valueDependencies contains name) {
    field.text = value.toString
  }

  def eval: Int = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case NumberValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type Number.")
    }
    case None => 0
  }
}

class StringQuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QuestionBox(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  type UpdateFunction = (ObservableValue[String, java.lang.String], java.lang.String, java.lang.String) => Unit

  val field = initialize(eval, (obs, oldValue, newValue) => { updateEnv(StringValue(newValue)) })
  def initialize(value: String, updateEnvironment: UpdateFunction): TextField = {
    updateEnv(StringValue(value))
    val textField = new TextField
    textField.text = value
    textField.text.onChange(updateEnvironment)
    textField
  }
  children.add(field)

  env.onChange((map, change) => change match {
    case Add(addedName, _) => updateProperties(field, addedName)
    case Replace(replacedName, _, _) => updateProperties(field, replacedName)
  })

  def updateProperties(field: TextField, name: VariableName): Unit = {
    updateVisibility(name)
    if (isVisible) {
      updateValue(field, name, eval)
    }
  }

  def updateValue(field: TextField, name: VariableName, value: String): Unit =  if (valueDependencies contains name) {
    field.text = value
  }

  def eval: String = q.expression match {
    case Some(e) => evaluator.eval(e, env) match {
      case StringValue(v) => v
      case _ => throw new AssertionError(s"Error in type checker. Variable ${q.variable.name} not of type String.")
    }
    case None => ""
  }
}
