package ql.gui

import types.Label

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color
import scalafx.scene.{Node, Scene}

class FormGUI(label: Label, nodes: List[Node]) extends JFXApp {

  val Padding: Int = 10

  // TODO: expand grid if fields become visible
  val grid = new GridPane {
    padding = Insets(Padding)
    for ((node, i) <- nodes.zipWithIndex) {
      add(node, 1, i + 1)
    }
  }

  stage = new PrimaryStage {
    title.value = label
    scene = new Scene(grid, Color.LIGHTGRAY)
  }
}
