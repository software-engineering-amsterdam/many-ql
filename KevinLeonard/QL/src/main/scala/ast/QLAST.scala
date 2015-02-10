package ast

trait QLAST {

  sealed abstract class Expr

  // Basic
  sealed abstract class Literal extends Expr
  case class BooleanLiteral(value: Boolean) extends Literal
  case class NumberLiteral(value: Int) extends Literal
  case class Variable(name: String) extends Expr

  // Form
  case class Form(name: String, e: Expr)
  case class Sequence(l: List[Expr]) extends Expr
  case class IfExpr(v: Variable, e1: Expr, e2: Option[Expr]) extends Expr

  // Questions
  sealed abstract class QuestionExpr extends Expr
  sealed abstract class ComputedQuestionExpr extends QuestionExpr
  case class BooleanQuestion(v: Variable, label: String) extends QuestionExpr
  case class IntegerQuestion(v: Variable, label: String) extends QuestionExpr
  case class StringQuestion(v: Variable, label: String) extends QuestionExpr
  case class ComputedBooleanQuestion(v: Variable, label: String, value: Object) extends ComputedQuestionExpr
  case class ComputedIntegerQuestion(v: Variable, label: String) extends ComputedQuestionExpr
  case class ComputedStringQuestion(v: Variable, label: String) extends ComputedQuestionExpr
  sealed abstract class QuestionType
  case class BooleanType() extends QuestionType
  case class IntegerType() extends QuestionType
  case class StringType() extends QuestionType

  // Boolean and arithmetic expressions
  case class Or(l: Expr, r: Expr) extends Expr
  case class And(l: Expr, r: Expr) extends Expr
  case class Not(v: Expr) extends Expr
  case class Equal(l: Expr, r: Expr) extends Expr
  case class NotEqual(l: Expr, r: Expr) extends Expr
  case class LessThan(l: Expr, r: Expr) extends Expr
  case class LessThanEqual(l: Expr, r: Expr) extends Expr
  case class GreaterThan(l: Expr, r: Expr) extends Expr
  case class GreaterThanEqual(l: Expr, r: Expr) extends Expr
  case class Add(l: Expr, r: Expr) extends Expr
  case class Sub(l: Expr, r: Expr) extends Expr
  case class Mul(l: Expr, r: Expr) extends Expr
  case class Div(l: Expr, r: Expr) extends Expr

}
