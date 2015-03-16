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

  val grid = new GridPane {
    padding = Insets(Padding)
    for ((node, i) <- nodes.zipWithIndex) {
      add(node, 1, i + 1)
    }
  }

  stage = new PrimaryStage {
    title.value = label
    width = Width
    height = Height
    scene = new Scene(grid, Width, Height, Color.LIGHTGRAY)
  }
}
