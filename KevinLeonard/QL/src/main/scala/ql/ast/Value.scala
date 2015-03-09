package ql.ast

sealed trait Value
case class BooleanValue(v: Boolean = false) extends Value
case class NumberValue(v: Int = 0) extends Value
case class StringValue(v: String = "") extends Value
