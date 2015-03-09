package ql.ast

object DefaultValues {
  val BooleanValue: Boolean = false
  val NumberValue: Int = 0
  val StringValue: String = ""
}

sealed trait Value
case class BooleanValue(value: Boolean = DefaultValues.BooleanValue) extends Value
case class NumberValue(value: Int = DefaultValues.NumberValue) extends Value
case class StringValue(value: String = DefaultValues.StringValue) extends Value
