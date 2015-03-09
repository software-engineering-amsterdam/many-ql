package ql.ast

import scala.util.parsing.input.Positional

sealed trait Statement extends Positional
case class Sequence(statements: List[Statement]) extends Statement
case class IfStatement(expression: Expression, ifBlock: Statement, optionalElseBlock: Option[Statement]) extends Statement
case class Question(_type: Type, variable: Variable, label: String, optionalExpression: Option[Expression]) extends Statement
