package gui

import javafx.beans.value.ObservableValue

import ast._

import scalafx.Includes._
import scalafx.scene.Node
import scalafx.scene.control.{Label, TextField}
import scalafx.scene.layout.VBox

class FormBuilder {

  def build(form: Form): FormGUI = {
    new FormGUI(form.label, build(form.s))
  }

  def build(s: Statement): List[Node] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s))
    //case i: IfStatement => Evaluation stuff + build the rights sequence body.
    case q: Question => q._type match {
      case StringType() => List(addVBox(q.label, new TextField()))
      case BooleanType() => List(addVBox(q.label, new TextField()))
      case NumberType() => List(addVBox(q.label, new TextField()))
    }
    case _ => List()
  }

  def addVBox(l: String, field: Node): VBox = {
    val box = new VBox()
    val label = new Label(l)
    val field = new TextField()
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    box.children.addAll(label, field)
    box
  }
}
