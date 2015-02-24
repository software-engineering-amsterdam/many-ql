package gui

import javafx.collections.{FXCollections, ObservableList}

import ast._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.{Node, Scene}
import scalafx.scene.control.{Label, CheckBox, TextField}
import scalafx.scene.layout.{HBox, GridPane}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.stage.Stage

class FormBuilder {

  def build(form: Form): FormGUI = {
    new FormGUI(form.label, build(form.s))
  }

  def build(s: Statement): List[Node] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s))
    //case i: IfStatement => Evaluation stuff + build the rights sequence body.
    case q: Question => q._type match {
      case StringType() => List(addHBox(q.label, new TextField()))
      case BooleanType() => List(addHBox(q.label, new TextField()))
      case NumberType() => List(addHBox(q.label, new TextField()))
      case _ => throw new AssertionError(s"Unsupported question type. ${q.pos}")
    }
    case _ => List()
  }

  def addHBox(label: String, field: Node): HBox = {
    val hBox = new HBox()
    hBox.children.addAll(new Label(label), new TextField())
    hBox
  }
}
