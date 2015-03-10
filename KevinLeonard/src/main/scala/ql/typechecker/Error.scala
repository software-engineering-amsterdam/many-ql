package ql.typechecker

import scala.util.parsing.input.Position

class Error(val message: String, val position: Option[Position] = None) {

  override def toString: String = position match {
    case Some(p) => s"Error: $message at line $position"
    case None => s"Error: $message"
  }

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
