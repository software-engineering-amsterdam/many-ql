package ql.typechecker

import scala.util.parsing.input.Position

class Error(val message: String, val position: Position) {
  override def toString: String = s"Error: $message $position"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Error]

  override def equals(other: Any): Boolean = other match {
    case that: Error =>
      (that canEqual this) &&
        message == that.message &&
        position == that.position
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(message, position)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
