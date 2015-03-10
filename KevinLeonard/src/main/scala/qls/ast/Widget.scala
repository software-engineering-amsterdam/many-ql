package qls.ast

import ql.ast.Type

sealed trait Widget
case class SpinBox(properties: List[StyleProperty]) extends Widget
case class Slider(properties: List[StyleProperty]) extends Widget
case class Text(properties: List[StyleProperty]) extends Widget
case class TextBlock(properties: List[StyleProperty]) extends Widget
case class Radio(properties: List[StyleProperty]) extends Widget
case class DropDown(properties: List[StyleProperty]) extends Widget

case class DefaultWidget(_type: Type, widget: Widget)