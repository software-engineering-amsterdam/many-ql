package qls.gui.widgets

import ql.ast.{Expression, Question}
import ql.gui.widgets.{QuestionWidget => QLQuestionWidget}
import types._

abstract class QuestionWidget(q: Question, visibilityExpressions: List[Expression], env: EvalEnvironment)
  extends QLQuestionWidget(q, visibilityExpressions, env) {


}
