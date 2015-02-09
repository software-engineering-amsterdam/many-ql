package ast

trait QLAST {
  sealed abstract class Expr
  case class Sequence(l: List[Expr]) extends Expr
  case class QuestionExpr(v: Variable, label: String, _type: String) extends Expr
  case class IfExpr(v: Variable, e1: Expr, e2: Option[Expr]) extends Expr
  case class Variable(name: String) extends Expr
}
