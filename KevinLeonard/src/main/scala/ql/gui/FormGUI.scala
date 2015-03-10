package ql.gui

import types.Label

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.{Node, Scene}

class FormGUI(label: Label, nodes: List[Node]) extends JFXApp {

  val Width: Int = 600
  val Height: Int = 450
  val Padding: Int = 10

  stage = new PrimaryStage {
    title.value = label
    width = Width
    height = Height
  }

  val grid = new GridPane
  grid.padding = Insets(Padding)
  for ((node, index) <- nodes.zipWithIndex) {
    grid.add(node, 1, index + 1)
  }

  val scene = new Scene(grid, Width, Height)
  scene.fill = Color.LIGHTGRAY
  stage.setScene(scene)
}
