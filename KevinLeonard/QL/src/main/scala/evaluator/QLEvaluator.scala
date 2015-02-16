package evaluator

import ast.QLAST

class QLEvaluator extends QLAST {

  }

  def eval(e: Expression): Any = e match {
    case Or(l, r) =>  (eval(l), eval(r)) match {
      case (l: Boolean, r: Boolean) => l || r
    }
    case And(l, r) => (eval(l), eval(r)) match {
      case (l: Boolean, r: Boolean) => l && r
    }
    case Not(e) => eval(e) match {
      case e: Boolean => !e
    }
    case Equal(l, r) => (eval(l), eval(r)) match {
      case (l: Boolean, r: Boolean) => l == r
      case (l: Int, r: Int) => l == r
      case (l: String, r: String) => l == r
    }
    case NotEqual(l, r) => (eval(l), eval(r)) match {
      case (l: Boolean, r: Boolean) => l != r
      case (l: Int, r: Int) => l != r
      case (l: String, r: String) => l != r
    }
    case LessThan(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l < r
    }
    case LessThanEqual(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l <= r
    }
    case GreaterThan(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l > r
    }
    case GreaterThanEqual(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l >= r
    }
    case Add(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l + r
    }
    case Sub(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l - r
    }
    case Mul(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l * r
    }
    case Div(l, r) => (eval(l), eval(r)) match {
      case (l: Int, r: Int) => l / r
    }
    case Variable(v) => sys.error("Variables are not supported yet.")
    case BooleanLiteral(value) => value
    case NumberLiteral(value) => value
    case StringLiteral(value) => value
  }

}
