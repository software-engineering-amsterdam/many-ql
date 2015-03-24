package qls.ast

import ql.ast.{BooleanType, StringType, NumberType, Type}

abstract class Widget {
  val properties: List[StyleProperty]
  def allowsType(_type: Type): Boolean
}
case class SpinBox(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == NumberType()
  override def toString: String = "spin box"
}
case class Slider(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == NumberType()
  override def toString: String = "slider"
}
case class Text(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == StringType() || _type == NumberType()
  override def toString: String = "text"
}
case class TextBlock(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == StringType()
  override def toString: String = "text block"
}
case class Radio(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "radio"
}
case class CheckBox(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "check box"
}
case class DropDown(properties: List[StyleProperty]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "drop down"
}
