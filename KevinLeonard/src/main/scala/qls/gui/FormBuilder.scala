package qls.gui

import ql.ast.{BooleanType, Expression, NumberType, Question => QLQuestion, StringType}
import ql.gui.{FormBuilder => QLFormBuilder}
import qls.ast._
import qls.gui.widgets._
import qls.typechecker.Questions
import types.EvalEnvironment

import scalafx.collections.ObservableMap
import scalafx.scene.layout.VBox

class FormBuilder(stylesheet: StyleSheet, env: EvalEnvironment = ObservableMap.empty) extends QLFormBuilder(env) {

  val questionStyles: List[Question] = Questions.extract(stylesheet)

  override def buildQuestion(q: QLQuestion, visibilityExpressions: List[Expression]): VBox = {
    questionStyles.find(_.variable == q.variable) match {
      case None => throw new AssertionError("All questions should be placed.")
      case Some(question) =>
        val styles = question.widget.styles
        question.widget._type match {
        case SpinBox() => throw new NotImplementedError("Spinner class not available.")
        case Slider() => new SliderQuestionWidget(q, visibilityExpressions, env, styles)
        case Text() => q._type match {
          case NumberType() => new NumberQuestionWidget(q, visibilityExpressions, env, styles)
          case StringType() => new StringQuestionWidget(q, visibilityExpressions, env, styles)
          case BooleanType() => throw new AssertionError("Text widget not allowed for boolean questions.")
        }
        case TextBlock() => new TextBlockQuestionWidget(q, visibilityExpressions, env, styles)
        case Radio() => new RadioQuestionWidget(q, visibilityExpressions, env, styles)
        case CheckBox() => new CheckBoxQuestionWidget(q, visibilityExpressions, env, styles)
        case DropDown() => new DropDownQuestionWidget(q, visibilityExpressions, env, styles)
      }
    }
  }

}
