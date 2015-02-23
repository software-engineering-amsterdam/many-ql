package ast

import scala.util.parsing.input.Positional

sealed trait Statement extends Positional
case class Sequence(statements: List[Statement]) extends Statement
case class IfStatement(e: Expression, s1: Statement, s2: Option[Statement]) extends Statement

sealed trait Question extends Statement {
  val v: Variable
  val label: String
}
case class BooleanQuestion(v: Variable, label: String, e: Option[Expression]) extends Question
case class NumberQuestion(v: Variable, label: String, e: Option[Expression]) extends Question
case class StringQuestion(v: Variable, label: String, e: Option[Expression]) extends Question
