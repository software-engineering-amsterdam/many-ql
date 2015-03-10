package qls.ast

import ql.ast.Variable

import scala.util.parsing.input.Positional

case class Question(variable: Variable, widget: Widget) extends Positional
