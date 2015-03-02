package ast

class Form(val label: String, val s: Statement) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[Form]

  override def equals(other: Any): Boolean = other match {
    case that: Form =>
      (that canEqual this) &&
        label == that.label &&
        s == that.s
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(label, s)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
