package ast

import scala.util.parsing.input.Positional

// Boolean and arithmetic expressions
sealed trait Expression extends Positional

case class Or(l: Expression, r: Expression) extends Expression
case class And(l: Expression, r: Expression) extends Expression
case class Not(e: Expression) extends Expression
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

sealed trait Literal extends Expression
case class BooleanLiteral(value: Boolean) extends Literal
case class NumberLiteral(value: Int) extends Literal
case class StringLiteral(value: String) extends Literal
