package qls.gui.widgets

import ql.ast.{Expression, Question}
import ql.gui.widgets.{QuestionWidget => QLQuestionWidget}
import qls.ast.{Font, FontColor, FontSize, HexadecimalColor, Style, Width}
import types.EvalEnvironment

import scalafx.scene.control.Label
import scalafx.scene.paint.Color
import scalafx.scene.text.{Font => FXFont}

abstract class QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style])
  extends QLQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  applyLabelStyle(label, styles)

  def applyLabelStyle(label: Label, styles: List[Style]): Unit = {
    val font = styles.collectFirst({
      case Font(name) => name
    }).get
    val fontSize = styles.collectFirst({
      case FontSize(size) => size.toDouble
    }).get
    val fontColor = styles.collectFirst({
      case FontColor(HexadecimalColor(color)) => color
    }).get

    label.setFont(FXFont(font, fontSize))
    label.setTextFill(Color.web(fontColor))
  }
}
