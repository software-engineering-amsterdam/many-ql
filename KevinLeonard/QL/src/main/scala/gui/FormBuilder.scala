package gui

import java.awt.Checkbox
import javafx.beans.value.ObservableValue

import ast._
import evaluator.Evaluator

import scalafx.Includes._
import scalafx.scene.Node
import scalafx.scene.control._
import scalafx.scene.layout.VBox

class FormBuilder extends Evaluator {

  def build(form: Form): FormGUI = {
    new FormGUI(form.label, build(form.s))
  }

  def build(s: Statement): List[Node] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s))
    case i: IfStatement => /* TODO: Add evaluator! */ build(i.ifBlock)
    case q: Question => q._type match {
      case StringType() => List(addBox(getStringFieldElement(new Label(q.label))))
      case BooleanType() => List(addBox(getBooleanFieldElement(new Label(q.label))))
      case NumberType() => List(addBox(getNumberFieldElement(new Label(q.label))))
    }
    case _ => List()
  }
  
  def addBox(nodes: List[Node]): VBox = {
    val box = new VBox();
    for (node <- nodes) box.children.add(node)
    box
  }
  
  def getStringFieldElement(label: Label): List[Node] = {
    val field = new TextField()
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    List(label, field)
  } 
  
  def getNumberFieldElement(label: Label): List[Node] = {
    val field = new TextField()
    
    // TODO: Add number input validation.
    field.text.addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    List(label, field)
  }
  
  def getBooleanFieldElement(label: Label): List[Node] = {
    val field = new CheckBox()
    field.selectedProperty().addListener(
      (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
    )
    List(label, field)
  }
}
