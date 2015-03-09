package ql.ast

import scala.util.parsing.input.Positional

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
case class Literal(t: Type, v: Value) extends Expression
