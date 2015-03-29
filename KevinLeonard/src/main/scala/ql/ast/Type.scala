package ql.ast

sealed trait Type
case class BooleanType() extends Type {
  override def toString: String = "boolean"
}
case class NumberType() extends Type {
  override def toString: String = "number"
}
case class StringType() extends Type {
  override def toString: String = "string"
}
