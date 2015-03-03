package gui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.{Node, Scene}

class FormGUI(label: String, nodes: List[Node]) extends JFXApp {

  val Width = 600
  val Height = 450

  stage = new PrimaryStage {
    title.value = label
    width = Width
    height = Height
  }

  val grid = new GridPane()
  for ((node, index) <- nodes.zipWithIndex) {
    grid.add(node, 1, index + 1)
  }

  val scene = new Scene(grid, Width, Height)
  scene.fill = Color.LIGHTGRAY
  stage.setScene(scene)
}
