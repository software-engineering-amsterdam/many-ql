package ql.ast

import types.Label

class Form(val label: Label, val statements: Statement) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[Form]

  override def equals(other: Any): Boolean = other match {
    case that: Form =>
      (that canEqual this) &&
        label == that.label &&
        statements == that.statements
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(label, statements)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
