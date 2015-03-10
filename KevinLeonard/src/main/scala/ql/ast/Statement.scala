package ql.ast

import types.Label

import scala.util.parsing.input.Positional

sealed trait Statement extends Positional
case class Sequence(statements: List[Statement]) extends Statement
case class IfStatement(expression: Expression, ifBlock: Statement, elseBlock: Option[Statement]) extends Statement
case class Question(_type: Type, variable: Variable, label: Label, expression: Option[Expression]) extends Statement
