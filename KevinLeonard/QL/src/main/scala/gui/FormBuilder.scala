package gui

import javafx.beans.value.ObservableValue

import ast._
import evaluator.Evaluator

import scala.collection.immutable.StringOps
import scala.util.Try

import scalafx.Includes._
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableMap
import scalafx.collections.ObservableMap.Replace

import scalafx.scene.control.{CheckBox, Label, TextField}
import scalafx.scene.layout.VBox

class FormBuilder {

  val evaluator = new Evaluator()

  type VariableName = String
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
    val box = new QuestionBox(q, visibilityExpressions)
    val field = q._type match {
      case BooleanType() => buildBooleanField(box.fieldValue, q.variable.name)
      case NumberType() => buildNumberField(box.fieldValue, q.variable.name)
      case StringType() => buildStringField(box.fieldValue, q.variable.name)
    }
    box.children.add(field)
    box.children.add(new Label(q.label))
    box.visible = box.isVisible
    box
  }

  def buildBooleanField(fieldValue: StringProperty, name: VariableName): CheckBox = {
    val field = new CheckBox {
//      selected = env get name match {
//        case Some(BooleanValue(v)) => v
//        case Some(_) => throw new AssertionError(s"Error in type checker. Variable $name not of type Boolean.")
//        case None => throw new AssertionError(s"Error in evaluator. Variable $name not found.")
//      }
    }
//    field.selected.bindBidirectional(fieldValue)
    field
  }

  def buildNumberField(fieldValue: StringProperty, name: VariableName): TextField = {
    val field = new TextField
    field.text.bindBidirectional(fieldValue)

    // TODO: Add number input validation.
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => {
        val newIntV = Try(new StringOps(newV.toString).toInt).toOption.getOrElse(0)
        env += (name -> NumberValue(newIntV))
        ()
      }
    )
    field
  }

  def buildStringField(fieldValue: StringProperty, name: VariableName): TextField = {
    val field = new TextField
    field.text.bindBidirectional(fieldValue)

    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => {
        env += (name -> StringValue(newV.toString))
        ()
      }
    )
    field
  }

  class QuestionBox(q: Question, visibilityExpressions: List[Expression]) extends VBox {
    val fieldValue: StringProperty = env get q.variable.name match {
      case None => StringProperty("")
      case Some(BooleanValue(_)) => StringProperty("false")
      case Some(NumberValue(v)) => StringProperty(v.toString)
      case Some(StringValue(v)) => StringProperty(v)
    }
    def fieldValue_=(v: Value) {
      v match {
        case BooleanValue(_) => fieldValue() = ""
        case NumberValue(v) => fieldValue() = v.toString
        case StringValue(v) => fieldValue() = v
      }
    }
    val dependencies: List[VariableName] = q.optionalExpression match {
      case Some(e) => findDependencies(e)
      case None => List()
    }
    val visibilityDependencies: List[VariableName] = visibilityExpressions.flatMap(v => findDependencies(v))

    def isVisible: Boolean = visibilityExpressions.forall(evaluator.eval(_, env) == BooleanValue(true))

    env.onChange((map, change) => change match {
      case Replace(key, added, removed) => {
        if (visibilityDependencies contains key) {
          visible = isVisible
        }

        // Only evaluate if visible
        if (visible.value) {
          if (dependencies contains key) {
            q.optionalExpression match {
              case Some(e) => fieldValue_=(evaluator.eval(e, env))
              case None => ()
            }
          }
        }
      }
    })
  }

  def findDependencies(e: Expression, dependencies: List[VariableName] = List()): List[VariableName] = e match {
    case Or(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case And(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case Not(e1) => findDependencies(e1, dependencies)
    case Equal(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case NotEqual(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case LessThan(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case LessThanEqual(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case GreaterThan(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case GreaterThanEqual(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case ast.Add(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case Sub(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case Mul(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case Div(l, r) => findDependencies(l, dependencies) ++ findDependencies(r, dependencies)
    case Variable(name) => name :: dependencies 
    case Literal(_, v) => dependencies
  }
}




