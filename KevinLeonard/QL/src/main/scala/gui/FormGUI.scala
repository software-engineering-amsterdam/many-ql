package gui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.{Scene, Node}
import scalafx.scene.layout.GridPane

class FormGUI(label: String, nodes: List[Node]) extends JFXApp {

  stage = new PrimaryStage {
    title.value = label
    width = 600
    height = 450
  }

  val grid = new GridPane()
  for ((node, index) <- nodes.zipWithIndex) {
    grid.add(node, 1, index + 1)
  }

  val scene = new Scene(grid, 600, 450)
  scene.fill = Color.LIGHTGRAY
  stage.setScene(scene)
}
