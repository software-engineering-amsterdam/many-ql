package ql.typechecker

class Warning(val message: String) {
  override def toString: String = s"Warning: $message"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Warning]

  override def equals(other: Any): Boolean = other match {
    case that: Warning =>
      (that canEqual this) &&
        message == that.message
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(message)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
