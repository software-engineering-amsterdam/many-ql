package gui

import javafx.beans.value.ObservableValue

import ast._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene._
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.scene.paint._
import javafx.beans.Observable

object FormGUI extends JFXApp {

  stage = new PrimaryStage {
    title.value = "Hello Stage"
    width = 600
    height = 450
  }

  var grid = new GridPane()
  
  var formBuilder = new GUIBuilder();
  var elements = formBuilder.build(Sequence(List(Question(StringType(), Variable("X"), "Question X (String)", None), Question(BooleanType(), Variable("Y"), "Question Y (Boolean)", None), Question(NumberType(), Variable("Z"), "Question X (Number)", None))))
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
      case StringType() => {
        val box = new VBox()
        box.fillWidth()
        val label = new Label(q.label)
        val field = new TextField()
        field.text.addListener(
          //(obs: Observable) => println("addListener worked on invalidate")
          (obs: ObservableValue[_ <: Object], oldV: Object, newV: Object) => println(newV)
        )
        box.getChildren().addAll(label, field)
        List(box)
      }
      case BooleanType() => {
        val box = new VBox()
        val label = new Label(q.label)
        val field = new CheckBox()
        box.getChildren().addAll(label, field)
        List(box)
      }
      case NumberType() => {
        val box = new VBox()
        val label = new Label(q.label)
        val field = new TextField()
        box.getChildren().addAll(label, field)
        List(box)
      }
      case _ => throw new AssertionError(s"Unsupported question type. ${q.pos}")
    }
  }
  
}
