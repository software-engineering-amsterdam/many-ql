package ql.ast

import types.VariableName

import scala.util.parsing.input.Positional

sealed trait Expression extends Positional
case class Or(lhs: Expression, rhs: Expression) extends Expression
case class And(lhs: Expression, rhs: Expression) extends Expression
case class Not(expression: Expression) extends Expression
case class Equal(lhs: Expression, rhs: Expression) extends Expression
case class NotEqual(lhs: Expression, rhs: Expression) extends Expression
case class LessThan(lhs: Expression, rhs: Expression) extends Expression
case class LessThanEqual(lhs: Expression, rhs: Expression) extends Expression
case class GreaterThan(lhs: Expression, rhs: Expression) extends Expression
case class GreaterThanEqual(lhs: Expression, rhs: Expression) extends Expression
case class Add(lhs: Expression, rhs: Expression) extends Expression
case class Sub(lhs: Expression, rhs: Expression) extends Expression
case class Mul(lhs: Expression, rhs: Expression) extends Expression
case class Div(lhs: Expression, rhs: Expression) extends Expression
case class Negation(expression: Expression) extends Expression
case class Variable(name: VariableName) extends Expression

sealed trait Literal extends Expression
case class BooleanLiteral(value: Value) extends Literal
case class NumberLiteral(value: Value) extends Literal
case class StringLiteral(value: Value) extends Literal
