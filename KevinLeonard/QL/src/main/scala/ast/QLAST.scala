package ast

trait QLAST {

  // Form
  sealed abstract class Statement
  case class Form(label: String, e: Statement)
  case class Sequence(statements: List[Statement]) extends Statement
  case class IfStatement(e: Expression, s1: Statement, s2: Option[Statement]) extends Statement

  // Questions
  sealed abstract class Question extends Statement
  sealed abstract class ComputedQuestion extends Question
  case class BooleanQuestion(v: Variable, label: String) extends Question
  case class IntegerQuestion(v: Variable, label: String) extends Question
  case class StringQuestion(v: Variable, label: String) extends Question
  case class ComputedBooleanQuestion(v: Variable, label: String, value: Object) extends ComputedQuestion
  case class ComputedIntegerQuestion(v: Variable, label: String, value: Object) extends ComputedQuestion
  case class ComputedStringQuestion(v: Variable, label: String, value: Object) extends ComputedQuestion
  sealed abstract class QuestionType
  case class BooleanType() extends QuestionType
  case class IntegerType() extends QuestionType
  case class StringType() extends QuestionType

  // Boolean and arithmetic expressions
  sealed abstract class Expression
  sealed abstract class Literal extends Expression
  case class BooleanLiteral(value: Boolean) extends Literal
  case class NumberLiteral(value: Int) extends Literal
  case class StringLiteral(value: String) extends Literal
  case class Or(l: Expression, r: Expression) extends Expression
  case class And(l: Expression, r: Expression) extends Expression
  case class Not(v: Expression) extends Expression
  case class Equal(l: Expression, r: Expression) extends Expression
  case class NotEqual(l: Expression, r: Expression) extends Expression
  case class LessThan(l: Expression, r: Expression) extends Expression
  case class LessThanEqual(l: Expression, r: Expression) extends Expression
  case class GreaterThan(l: Expression, r: Expression) extends Expression
  case class GreaterThanEqual(l: Expression, r: Expression) extends Expression
  case class Add(l: Expression, r: Expression) extends Expression
  case class Sub(l: Expression, r: Expression) extends Expression
  case class Mul(l: Expression, r: Expression) extends Expression
  case class Div(l: Expression, r: Expression) extends Expression
  case class Variable(name: String) extends Expression

}
