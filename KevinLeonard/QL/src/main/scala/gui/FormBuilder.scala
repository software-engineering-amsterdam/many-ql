package gui

import ast._
import evaluator.Evaluator

import scala.collection.immutable.StringOps
import scala.util.Try
import scalafx.beans.property.BooleanProperty
import scalafx.beans.value.ObservableValue

import scalafx.collections.ObservableMap
import scalafx.collections.ObservableMap.{Change, Replace, Add}

import scalafx.scene.control.{CheckBox, Label, TextField}
import scalafx.scene.layout.VBox

class FormBuilder {

  val evaluator = new Evaluator()
  val dependencyResolver = new DependencyResolver()

  type VariableName = String
  type Dependencies = List[VariableName]
  type EvalEnvironment = ObservableMap[VariableName, Value]

  var env: EvalEnvironment = ObservableMap.empty[VariableName, Value]

  def build(form: Form): FormGUI = {
    env = evaluator.eval(form)
    new FormGUI(form.label, build(form.s))
  }

  def build(s: Statement, visibilityExpressions: List[Expression] = List()): List[VBox] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s, visibilityExpressions))
    case i: IfStatement => buildIfStatement(i, visibilityExpressions)
    case q: Question => List(buildQuestion(q, visibilityExpressions))
  }

  def buildIfStatement(i: IfStatement, visibilityExpressions: List[Expression]): List[VBox] = {
    val ifBlock = build(i.ifBlock, i.expression :: visibilityExpressions)
    val elseBlock = i.optionalElseBlock match {
      case Some(s) => build(s, Not(i.expression) :: visibilityExpressions)
      case None => List()
    }
    ifBlock ++ elseBlock
  }

  def buildQuestion(q: Question, visibilityExpressions: List[Expression]): VBox = {
    q._type match {
      case BooleanType() => new BooleanQuestionBox(q, visibilityExpressions)
      case NumberType() => new NumberQuestionBox(q, visibilityExpressions)
      case StringType() => new StringQuestionBox(q, visibilityExpressions)
    }
  }

  abstract class QuestionBox(q: Question, visibilityExpressions: List[Expression]) extends VBox {

    val name: VariableName = q.variable.name
    val valueDependencies: Dependencies = q.optionalExpression.fold[Dependencies](List())(e => dependencyResolver.resolve(e))
    val visibilityDependencies: Dependencies = visibilityExpressions.flatMap(e => dependencyResolver.resolve(e))
    
    def setVisibility(key: String) = if (visibilityDependencies contains key) visible = shouldBeVisible
    def shouldBeVisible: Boolean = visibilityExpressions.forall(evaluator.eval(_, env) == BooleanValue(true))
    def isVisible: Boolean = visible.value

    visible = shouldBeVisible
    children.add(new Label(q.label))
  }

  class BooleanQuestionBox(q: Question, visibilityExpressions: List[Expression]) extends QuestionBox(q: Question, visibilityExpressions: List[Expression]) {

    def addCheckBoxElement(value: Boolean, onChangeCallback: (ObservableValue[Boolean, java.lang.Boolean], java.lang.Boolean, java.lang.Boolean) => Unit): CheckBox = {
      val checkbox = new CheckBox
      checkbox.selected = value
      checkbox.selected.onChange(onChangeCallback)
      checkbox
    }
    
    def value: Boolean = q.optionalExpression match {
      case Some(e) => evaluator.eval(e, env) match {
        case BooleanValue(v) => v
        case _ => throw new AssertionError(s"Error in type checker. Variable $name not of type Boolean.")
      }
      case None => false
    }

    def setValue(field: CheckBox, key: String, value: Boolean) =  if (valueDependencies contains key) field.selected = value

    def envChangeCallback(field: CheckBox, key: String) = {
      setVisibility(key)
      // Only evaluate if visible
      if (isVisible) setValue(field, key, value)
    }
    
    val field = addCheckBoxElement(value, (_, _, newValue) => { env += (name -> BooleanValue(newValue))})
    children.add(field)

    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => envChangeCallback(field, key)
    })
  }

  class NumberQuestionBox(q: Question, visibilityExpressions: List[Expression]) extends QuestionBox(q: Question, visibilityExpressions: List[Expression]) {

    def addTextFieldElement(value: Integer, onChangeCallback: (ObservableValue[String, java.lang.String], java.lang.String, java.lang.String) => Unit): TextField = {
      val textField = new TextField
      textField.text = value.toString
      textField.text.onChange(onChangeCallback)
      textField
    }
    
    def value: Int = q.optionalExpression match {
      case Some(e) => evaluator.eval(e, env) match {
        case NumberValue(v) => v
        case _ => throw new AssertionError(s"Error in type checker. Variable $name not of type Number.")
      }
      case None => 0
    }

    def setValue(field: TextField, key: String, value: Int) =  if (valueDependencies contains key) field.text = value.toString
    
    def envChangeCallback(field: TextField, key: String) = {
      setVisibility(key)
      // Only evaluate if visible
      if (isVisible) setValue(field, key, value)
    }
    
    val field = addTextFieldElement(value, (obs, oldValue, newValue) => {
      val newIntV = Try(new StringOps(newValue).toInt).toOption.getOrElse(0)
      env += (name -> NumberValue(newIntV))
    })
    children.add(field)
    
    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => envChangeCallback(field, key)
    })
  }

  class StringQuestionBox(q: Question, visibilityExpressions: List[Expression]) extends QuestionBox(q: Question, visibilityExpressions: List[Expression]) {

    def addTextFieldElement(value: String, onChangeCallback: (ObservableValue[String, java.lang.String], java.lang.String, java.lang.String) => Unit): TextField = {
      val textField = new TextField
      textField.text = value.toString
      textField.text.onChange(onChangeCallback)
      textField
    }
    
    def value: String = q.optionalExpression match {
      case Some(e) => evaluator.eval(e, env) match {
        case StringValue(v) => v
        case _ => throw new AssertionError(s"Error in type checker. Variable $name not of type String.")
      }
      case None => ""
    }

    def setValue(field: TextField, key: String, value: String) =  if (valueDependencies contains key) field.text = value
    
    def envChangeCallback(field: TextField, key: String) = {
      setVisibility(key)
      // Only evaluate if visible
      if (isVisible) setValue(field, key, value)
    }
    
    val field = addTextFieldElement(value, (obs, oldValue, newValue) => { env += (name -> StringValue(newValue)) })
    children.add(field)
    
    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => envChangeCallback(field, key)
    })
  }
  
}