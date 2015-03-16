package ql.typechecker

case class Warning(message: String) {
  override def toString: String = s"Warning: $message"
}
