package typechecker

import scala.util.parsing.input.Position

class Error(val message: String, val position: Position) {
  override def toString: String = s"$message $position"
}
