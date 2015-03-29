package qls.gui.widgets

import ql.ast.{Expression, Question}
import ql.gui.widgets.{NumberQuestionWidget => QLNumberQuestionWidget}
import types._

class NumberQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QLNumberQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)

  // TODO: Change style properties.
