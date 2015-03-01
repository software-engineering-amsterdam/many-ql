package gui

import javafx.beans.value.ObservableValue

import ast._
import evaluator.Evaluator

import scala.collection.immutable.Map
import scalafx.Includes._
import scalafx.scene.Node
import scalafx.scene.control.{CheckBox, Label, TextField}
import scalafx.scene.layout.VBox

class FormBuilder {

  val evaluator = new Evaluator()

  type VariableName = String
  type EvalEnvironment = Map[VariableName, Value]

  def build(form: Form): FormGUI = {
    val env = evaluator.eval(form)
    new FormGUI(form.label, build(form.s, env))
  }

  def build(s: Statement, env: EvalEnvironment): List[VBox] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s, env))
    case i: IfStatement => buildIfStatement(i, env)
    case q: Question => List(buildQuestion(q, env))
  }

  def buildIfStatement(i: IfStatement, env: EvalEnvironment): List[VBox] = evaluator.eval(i.expression, env) match {
    case BooleanValue(true) => build(i.ifBlock, env)
    case BooleanValue(false) => i.optionalElseBlock match {
      case Some(s) => build(i.optionalElseBlock.get, env)
      case None => List()
    }
    case _ =>  throw new AssertionError(s"Error in type checker. If expression is not of type Boolean.")
  }

  def buildQuestion(q: Question, env: EvalEnvironment): VBox = buildVerticalBox(getFieldElements(q, env))
  
  def buildVerticalBox(nodes: List[Node]): VBox = {
    val box = new VBox()
    for (node <- nodes) box.children.add(node)
    box
  }

  def getFieldElements(q: Question, env: EvalEnvironment): List[Node] = q._type match {
    case BooleanType() => getBooleanFieldElements(q.label, q.variable.name, env)
    case NumberType() => getNumberFieldElements(q.label, q.variable.name, env)
    case StringType() => getStringFieldElements(q.label, q.variable.name, env)
  }
  
  def getStringFieldElements(l: String, name: VariableName, env: EvalEnvironment): List[Node] = {
    val label = new Label(l)
    val field = new TextField {
      text = env get name match {
        case Some(StringValue(v)) => v
        case Some(_) => throw new AssertionError(s"Error in type checker. Variable $name not of type String.")
        case None => throw new AssertionError(s"Error in evaluator. Variable $name not found.")
      }
    }
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    List(label, field)
  } 
  
  def getNumberFieldElements(l: String, name: VariableName, env: EvalEnvironment): List[Node] = {
    val label = new Label(l)
    val field = new TextField {
      text = env get name match {
        case Some(NumberValue(v)) => v.toString
        case Some(_) => throw new AssertionError(s"Error in type checker. Variable $name not of type Number.")
        case None => throw new AssertionError(s"Error in evaluator. Variable $name not found.")
      }
    }
    
    // TODO: Add number input validation.
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    List(label, field)
  }
  
  def getBooleanFieldElements(l: String, name: VariableName, env: EvalEnvironment): List[Node] = {
    val label = new Label(l)
    val field = new CheckBox {
      selected = env get name match {
        case Some(BooleanValue(v)) => v
        case Some(_) => throw new AssertionError(s"Error in type checker. Variable $name not of type Boolean.")
        case None => throw new AssertionError(s"Error in evaluator. Variable $name not found.")
      }
    }
    field.selectedProperty().addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    List(label, field)
  }
}
