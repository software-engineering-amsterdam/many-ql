package qls.gui.widgets

import ql.ast.{Expression, Question}
import ql.gui.widgets.BooleanQuestionWidget
import types._

class CheckBoxQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends BooleanQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)

  // TODO: Change style properties.
