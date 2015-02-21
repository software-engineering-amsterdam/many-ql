package ast

import scala.util.parsing.input.Positional

// Statements
sealed trait Statement extends Positional
case class Sequence(statements: List[Statement]) extends Statement
case class IfStatement(e: Expression, s1: Statement, s2: Option[Statement]) extends Statement

// Questions
sealed trait Question extends Statement {
  val v: Variable
  val label: String
}
case class BooleanQuestion(v: Variable, label: String) extends Question
case class NumberQuestion(v: Variable, label: String) extends Question
case class StringQuestion(v: Variable, label: String) extends Question
sealed trait ComputedQuestion extends Question
case class ComputedBooleanQuestion(v: Variable, label: String, e: Expression) extends ComputedQuestion
case class ComputedNumberQuestion(v: Variable, label: String, e: Expression) extends ComputedQuestion
case class ComputedStringQuestion(v: Variable, label: String, e: Expression) extends ComputedQuestion
sealed trait QuestionType
case class BooleanType() extends QuestionType
case class NumberType() extends QuestionType
case class StringType() extends QuestionType
