package qls.gui

import ql.ast.{StringType, NumberType, BooleanType, Expression, Question => QLQuestion}
import ql.gui.widgets.{
  BooleanQuestionWidget => QLBooleanQuestionWidget,
  NumberQuestionWidget => QLNumberQuestionWidget,
  StringQuestionWidget => QLStringQuestionWidget
}
import ql.gui.{FormBuilder => QLFormBuilder}

import qls.ast._
import qls.gui.widgets._
import qls.typechecker.Questions
import types.EvalEnvironment

import scalafx.collections.ObservableMap
import scalafx.scene.layout.VBox

class FormBuilder(stylesheet: StyleSheet, env: EvalEnvironment = ObservableMap.empty)
  extends QLFormBuilder {

  val questionStyles: List[Question] = Questions.extract(stylesheet)

  override def buildQuestion(q: QLQuestion, visibilityExpressions: List[Expression]): VBox = {
    questionStyles.find(qs => qs.variable == q.variable) match {
      case None => {
        q._type match {
          case BooleanType() => new QLBooleanQuestionWidget(q, visibilityExpressions, env)
          case NumberType() => new QLNumberQuestionWidget(q, visibilityExpressions, env)
          case StringType() => new QLStringQuestionWidget(q, visibilityExpressions, env)
        }
      }
      case Some(qs) => qs.widget match {
        // TODO: Spinner class not available: see https://codingonthestaircase.wordpress.com/2014/11/08/scalafx-8-0-40-snapshot-spinner/
        //case SpinBox() => new SpinBoxQuestionWidget(q, visibilityExpressions, env)
        case Slider(styleProperties) => new SliderQuestionWidget(q, visibilityExpressions, env)
        case Text(styleProperties) => q._type match {
          case NumberType() => new NumberQuestionWidget(q, visibilityExpressions, env)
          case StringType() => new StringQuestionWidget(q, visibilityExpressions, env)
        }
          // TODO: TextBlock
        case Radio(styleProperties) => new RadioQuestionWidget(q, visibilityExpressions, env)
        case CheckBox(styleProperties) => new CheckBoxQuestionWidget(q, visibilityExpressions, env)
        case DropDown(styleProperties) => new DropDownQuestionWidget(q, visibilityExpressions, env)
      }
    }
  }

}
