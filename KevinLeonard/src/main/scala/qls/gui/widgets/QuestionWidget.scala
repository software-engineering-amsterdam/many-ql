package qls.gui.widgets

import ql.gui.widgets.{QuestionWidget => QLQuestionWidget}
import ql.ast.{Expression, Question}
import qls.ast.{Style, Font, FontSize, FontColor, Width, HexadecimalColor}
import types.EvalEnvironment

import scalafx.scene.text.{Font => FXFont}
import scalafx.scene.paint.Color
import scalafx.scene.control.Label

abstract class QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment, styles: List[Style])
  extends QLQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment) {

  def applyLabelStyle(label: Label, styles: List[Style]): Unit = {
    val font = styles.collectFirst({
      case Font(name) => name
    })
    val fontSize = styles.collectFirst({
      case FontSize(size) => size.toDouble
    })
    val fontColor = styles.collectFirst({
      case FontColor(HexadecimalColor(color)) => color
    })
    val width = styles.collectFirst({
      case Width(width) => width
    })

    label.setFont(FXFont(font.get, fontSize.get))
    label.setTextFill(Color.web(fontColor.get))
  }
  applyLabelStyle(label, styles)

}
