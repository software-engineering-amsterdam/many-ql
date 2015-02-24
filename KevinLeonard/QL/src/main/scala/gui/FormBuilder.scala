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
    //case i: IfStatement => Evaluation stuff + build the rights sequence body.
    case q: Question => q._type match {
      case StringType() => List(addTextField(q.label, q.variable.name, env))
      case BooleanType() => List(addCheckBox(q.label))
      case NumberType() => List(addTextField(q.label, q.variable.name, env))
    }
    case _ => List()
  }

  def addTextField(l: String, name: VariableName, env: EvalEnvironment): VBox = {
    val box = new VBox()
    val label = new Label(l)
    val field = new TextField {
      text = env get name match {
        case Some(StringValue(v)) => v
        case Some(NumberValue(v)) => v.toString
        case None => throw new AssertionError("Error in evaluator. Variable not found.")
      }
    }
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    box.children.addAll(label, field)
    box
  }

  def addCheckBox(l: String): VBox = {
    val box = new VBox()
    val label = new Label(l)
    val field = new CheckBox()
    box.children.addAll(label, field)
    box
  }
}
