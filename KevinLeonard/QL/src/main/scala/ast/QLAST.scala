package ast

trait QLAST {

  sealed abstract class Expr
  
  // Basic
  sealed abstract class Literal extends Expr
  case class BooleanLiteral(value: Boolean) extends Literal
  case class Variable(name: String) extends Expr

  // Form
  case class Form(name: String, e: Expr)
  case class Sequence(l: List[Expr]) extends Expr

  // If statements
  case class IfExpr(v: Variable, e1: Expr, e2: Option[Expr]) extends Expr

  // Questions
  sealed abstract class QuestionExpr extends Expr
  case class BooleanQuestion(v: Variable, label: String) extends QuestionExpr
  case class IntegerQuestion(v: Variable, label: String) extends QuestionExpr
  case class StringQuestion(v: Variable, label: String) extends QuestionExpr

  // Boolean expressions
  case class Or(l: Expr, r: Expr) extends Expr
  case class And(l: Expr, r: Expr) extends Expr
  case class Not(v: Expr) extends Expr

}
