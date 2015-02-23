package gui

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color

object GUI extends JFXApp {

  val check = new CheckBox {
    text = "CheckBox"
  }
  check.onAction = (event: ActionEvent) => {
    lblCheckState.text = check.selected.get().toString
  }

  val lblCheckState = new Label {
    text = check.selected.get().toString
  }

  val btnFire = new Button {
    text = "Fire!"
  }
  btnFire.onAction = (event: ActionEvent) =>  check.fire()

  val txfText = new TextField
  txfText.delegate.textProperty.bindBidirectional(check.text)

  val grid = new GridPane {
    padding = Insets(10)
    hgap = 5
    vgap = 5
  }
  grid.add(check, 0, 0)
  grid.add(lblCheckState, 1, 0)
  grid.add(btnFire, 0, 2)
  grid.add(txfText, 1, 2)

  stage = new PrimaryStage {
    title = "Hello World"
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = grid
    }
  }

}
