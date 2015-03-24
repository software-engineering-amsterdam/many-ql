package ql.typechecker

import scala.util.parsing.input.Position

case class Error(message: String, position: Option[Position] = None) {
  override def toString: String = position match {
    case Some(p) => s"Error at line $p: $message"
    case None => s"Error: $message"
  }
}
