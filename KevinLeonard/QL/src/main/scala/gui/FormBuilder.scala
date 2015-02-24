package gui

import javafx.beans.value.ObservableValue

import ast._

import scala.collection.immutable.Map
import scalafx.Includes._
import scalafx.scene.Node
import scalafx.scene.control.{CheckBox, Label, TextField}
import scalafx.scene.layout.VBox

class FormBuilder {

  type VariableName = String
  type EvalEnvironment = Map[VariableName, Value]

  def build(form: Form, env: EvalEnvironment): FormGUI = {
    new FormGUI(form.label, build(form.s, env))
  }

  def build(s: Statement, env: EvalEnvironment): List[Node] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s, env))
    case i: IfStatement => /* TODO: Add evaluator! */ build(i.ifBlock, env)
    case q: Question => q._type match { // TODO: Check if computed
      case BooleanType() => List(addBox(getBooleanFieldElement(q.label, q.variable.name, env)))
      case NumberType() => List(addBox(getNumberFieldElement(q.label, q.variable.name, env)))
      case StringType() => List(addBox(getStringFieldElement(q.label, q.variable.name, env)))
    }
    case _ => List()
  }
  
  def addBox(nodes: List[Node]): VBox = {
    val box = new VBox();
    for (node <- nodes) box.children.add(node)
    box
  }
  
  def getStringFieldElement(l: String, name: VariableName, env: EvalEnvironment): List[Node] = {
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
  
  def getNumberFieldElement(l: String, name: VariableName, env: EvalEnvironment): List[Node] = {
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
  
  def getBooleanFieldElement(l: String, name: VariableName, env: EvalEnvironment): List[Node] = {
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
