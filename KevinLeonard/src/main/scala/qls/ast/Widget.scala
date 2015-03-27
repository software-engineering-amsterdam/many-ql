package qls.ast

import ql.ast.{BooleanType, StringType, NumberType, Type}

sealed trait Widget {
  val styles: List[Style]
  def allowsType(_type: Type): Boolean
}
case class SpinBox(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == NumberType()
  override def toString: String = "spin box"
}
case class Slider(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == NumberType()
  override def toString: String = "slider"
}
case class Text(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == StringType() || _type == NumberType()
  override def toString: String = "text"
}
case class TextBlock(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == StringType()
  override def toString: String = "text block"
}
case class Radio(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "radio"
}
case class CheckBox(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "check box"
}
case class DropDown(styles: List[Style]) extends Widget {
  override def allowsType(_type: Type): Boolean = _type == BooleanType()
  override def toString: String = "drop down"
}
