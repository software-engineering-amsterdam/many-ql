package evaluator

import ast.QLAST

class QLEvaluator extends QLAST {

  def eval(l: Literal): Boolean = l match {
    case BooleanLiteral(value) => value
    case _ => false
  }

  def eval(e: Expression): Any = e match {
    case Or(l, r) =>  (eval(l), eval(r)) match {
      case (l: Boolean, r: Boolean) => l || r
      case _ => sys.error("Error: '||' requires two boolean expressions.")
    }
    case And(l, r) => (eval(l), eval(r)) match {
      case (l: Boolean, r: Boolean) => l && r
      case _ => sys.error("Error: '&&' requires two boolean expressions.")
    }
    case l: Literal => eval(l)
  }

}
