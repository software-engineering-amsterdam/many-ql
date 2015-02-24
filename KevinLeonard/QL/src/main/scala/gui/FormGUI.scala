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


object FormGUI extends JFXApp {

  stage = new PrimaryStage {
    title.value = "Hello Stage"
    width = 600
    height = 450
  }

  var grid = new GridPane()
  
  var formBuilder = new GUIBuilder();
  var elements = formBuilder.build(Sequence(List(Question(StringType(), Variable("X"), "label", None),Question(BooleanType(), Variable("X"), "label", None),Question(NumberType(), Variable("X"), "label", None))))
  for ((element, index) <- elements.zipWithIndex) {
    grid.add(element, 1, index + 10)
  }

  var scene = new Scene(grid, 600, 450)
  scene.fill = Color.LIGHTGRAY
  stage.setScene(scene)
  stage.show()
}

class GUIBuilder {

  //def build(form: Form = new Form("form1", Sequence(List()))) : = build(form.s)

  def build(s: Statement): List[Node] = s match {
    case Sequence(statements: List[Statement]) => statements.flatMap(s => build(s))
    //case i: IfStatement => Evaluation stuff + build the rights sequence body.
    case q: Question => q._type match {
      case StringType() => var hbox = new HBox(); hbox.getChildren().addAll(new Label(q.label), new TextField()); List(hbox)

      case BooleanType() => var hbox = new HBox(); hbox.getChildren().addAll(new Label(q.label), new CheckBox()); List(hbox)
      case NumberType() => var hbox = new HBox(); hbox.getChildren().addAll(new Label(q.label), new CheckBox()); List(hbox)
      case _ => throw new AssertionError(s"Unsupported question type. ${q.pos}")
    }
  }
  
}
