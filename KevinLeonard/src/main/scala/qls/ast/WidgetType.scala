package qls.ast

import ql.ast.{BooleanType, NumberType, StringType, Type}

sealed trait WidgetType {
  def allowsType(_type: Type): Boolean
}
case class SpinBox() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == NumberType()
  override def toString: String = "spin box"
}
case class Slider() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == NumberType()
  override def toString: String = "slider"
}
case class Text() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == StringType() || _type == NumberType()
  override def toString: String = "text"
}
case class TextBlock() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == StringType()
  override def toString: String = "text block"
}
case class Radio() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "radio"
}
case class CheckBox() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "check box"
}
case class DropDown() extends WidgetType {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "drop down"
}
