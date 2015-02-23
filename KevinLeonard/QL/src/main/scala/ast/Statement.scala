package ast

import scala.util.parsing.input.Positional

sealed trait Statement extends Positional
case class Sequence(statements: List[Statement]) extends Statement
case class IfStatement(e: Expression, s1: Statement, s2: Option[Statement]) extends Statement
case class Question(t: Type, v: Variable, label: String, e: Option[Expression]) extends Statement
