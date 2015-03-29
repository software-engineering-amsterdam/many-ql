package qls.gui.widgets

import ql.ast.{Expression, Question}
import ql.gui.widgets.{StringQuestionWidget => QLStringQuestionWidget}
import types._

class StringQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QLStringQuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)

  // TODO: Change style properties.
