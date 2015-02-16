package ast

trait QLAST {

  sealed abstract class Expr
  case class Form(name: String, e: Expr)
  case class Sequence(l: List[Expr]) extends Expr
  case class IfExpr(v: Variable, e1: Expr, e2: Option[Expr]) extends Expr
  case class Const(name: String) extends Expr
  case class Variable(name: String) extends Expr

  sealed abstract class QuestionExpr extends Expr
  case class BooleanQuestion(v: Variable, label: String) extends QuestionExpr
  case class IntegerQuestion(v: Variable, label: String) extends QuestionExpr
  case class StringQuestion(v: Variable, label: String) extends QuestionExpr

  case class Or(l: Expr, r: Expr) extends Expr
  case class And(l: Expr, r: Expr) extends Expr
  case class Not(v: Expr) extends Expr

}
