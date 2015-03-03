package gui

import ast._
import evaluator.Evaluator

import scala.collection.immutable.StringOps
import scala.util.Try

import scalafx.collections.ObservableMap
import scalafx.collections.ObservableMap.{Replace, Add}

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
    val valueDeps: Dependencies = q.optionalExpression.fold[Dependencies](List())(e => dependencyResolver.resolve(e))
    val visibilityDeps: Dependencies = visibilityExpressions.flatMap(e => dependencyResolver.resolve(e))
    def isVisible: Boolean = visibilityExpressions.forall(evaluator.eval(_, env) == BooleanValue(true))
    visible = isVisible
  }

  class BooleanQuestionBox(q: Question, visibilityExpressions: List[Expression]) extends QuestionBox(q: Question, visibilityExpressions: List[Expression]) {
    val name: VariableName = q.variable.name

    children.add(new Label(q.label))
    val field: CheckBox = new CheckBox
    children.add(field)

    def value: Boolean = q.optionalExpression match {
      case Some(e) => evaluator.eval(e, env) match {
        case BooleanValue(v) => v
        case _ => throw new AssertionError(s"Error in type checker. Variable $name not of type Boolean.")
      }
      case None => false
    }
    field.selected = value
    field.selected.onChange((obs, oldValue, newValue) => { env += (name -> BooleanValue(newValue)) })

    def envChangeCallback(key: String) = {
      if (visibilityDeps contains key) {
        visible = isVisible
      }

      // Only evaluate if visible
      if (visible.value) {
        if (valueDeps contains key) {
          field.selected = value
        }
      }
    }
    
    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => envChangeCallback(key)
      case Add(key, value) => envChangeCallback(key)
    })
  }

  class NumberQuestionBox(q: Question, visibilityExpressions: List[Expression]) extends QuestionBox(q: Question, visibilityExpressions: List[Expression]) {
    val name: VariableName = q.variable.name

    children.add(new Label(q.label))
    val field: TextField = new TextField
    children.add(field)

    def value: Int = q.optionalExpression match {
      case Some(e) => evaluator.eval(e, env) match {
        case NumberValue(v) => v
        case _ => throw new AssertionError(s"Error in type checker. Variable $name not of type Boolean.")
      }
      case None => 0
    }
    field.text = value.toString
    field.text.onChange((obs, oldValue, newValue) => {
      val newIntV = Try(new StringOps(newValue).toInt).toOption.getOrElse(0)
      env += (name -> NumberValue(newIntV))
    })

    def envChangeCallback(key: String) = {
      if (visibilityDeps contains key) {
        visible = isVisible
      }

      // Only evaluate if visible
      if (visible.value) {
        if (valueDeps contains key) {
          field.text = value.toString
        }
      }
    }
    
    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => envChangeCallback(key)
      case Add(key, value) => envChangeCallback(key)
    })
  }

  class StringQuestionBox(q: Question, visibilityExpressions: List[Expression]) extends QuestionBox(q: Question, visibilityExpressions: List[Expression]) {
    val name: VariableName = q.variable.name

    children.add(new Label(q.label))
    val field: TextField = new TextField
    children.add(field)

    def value: String = q.optionalExpression match {
      case Some(e) => evaluator.eval(e, env) match {
        case StringValue(v) => v
        case _ => throw new AssertionError(s"Error in type checker. Variable $name not of type Boolean.")
      }
      case None => ""
    }
    field.text = value
    field.text.onChange((obs, oldValue, newValue) => { env += (name -> StringValue(newValue)) })

    def envChangeCallback(key: String) = {
      if (visibilityDeps contains key) {
        visible = isVisible
      }

      // Only evaluate if visible
      if (visible.value) {
        if (valueDeps contains key) {
          field.text = value
        }
      }
    }
    
    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => envChangeCallback(key)
      case Add(key, value) => envChangeCallback(key)
    })
  }
  
}
