package ast

trait QLAST {

  sealed abstract class Expr

  sealed abstract class QuestionExpr extends Expr

  case class Form(name: String, e: Expr)

  case class Sequence(l: List[Expr]) extends Expr

  case class BooleanQuestionExpr(v: Variable, label: String) extends QuestionExpr

  case class IntegerQuestionExpr(v: Variable, label: String) extends QuestionExpr

  case class StringQuestionExpr(v: Variable, label: String) extends QuestionExpr

  case class IfExpr(v: Variable, e1: Expr, e2: Option[Expr]) extends Expr

  case class Variable(name: String) extends Expr

}
