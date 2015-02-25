package typechecker

import scala.util.parsing.input.Position

sealed trait Level
case class Warning() extends Level {
  override def toString: String = "Warning"
}
case class Exception() extends Level {
  override def toString: String = "Exception"
}

class Error(val level: Level, val message: String, val position: Position) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[Error]

  override def equals(other: Any): Boolean = other match {
    case that: Error =>
      (that canEqual this) &&
        level == that.level &&
        message == that.message &&
        position == that.position
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(level, message, position)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString: String = s"$level - $message $position"
}
