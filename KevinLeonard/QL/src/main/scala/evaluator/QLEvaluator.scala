package evaluator

import ast._
import scala.collection.immutable.Map

class QLEvaluator {

  type VariableName = String
  sealed trait VariableValue
  case class BoolVal(v: Boolean = false) extends VariableValue
  case class NumberVal(v: Int = 0) extends VariableValue
  case class StringVal(v: String= "") extends VariableValue
  type Environment = Map[VariableName, VariableValue]

  val emptyEnvironment = Map[VariableName, VariableValue]()

  def eval(f: Form, environment: Environment = emptyEnvironment): Environment = eval(f.e, environment)

  def eval(s: Statement, env: Environment): Environment = s match {
    case Sequence(statements) => statements.foldLeft(env) { (env, s) => eval(s, env) }
    case IfStatement(e, s1, None) => eval(e, env) match {
      case BoolVal(true) => eval(s1, env)
      case _ => env
    }
    case IfStatement(e, s1, Some(s2)) => eval(e, env) match {
      case BoolVal(true) => eval(s1, env)
      case BoolVal(false) => eval(s2, env)
    }
    case BooleanQuestion(Variable(name), label) => env + (name -> BoolVal())
    case NumberQuestion(Variable(name), label) => env + (name -> NumberVal())
    case StringQuestion(Variable(name), label) => env + (name -> StringVal())
    case ComputedBooleanQuestion(Variable(name), label, e) => env + (name -> eval(e, env))
    case ComputedNumberQuestion(Variable(name), label, e) => env + (name -> eval(e, env))
    case ComputedStringQuestion(Variable(name), label, e) => env + (name -> eval(e, env))
  }

  def eval(e: Expression, env: Environment): VariableValue = e match {
    case Or(l, r) => (eval(l, env), eval(r, env)) match {
      case (BoolVal(l), BoolVal(r)) => BoolVal(l || r)
    }
    case And(l, r) => (eval(l, env), eval(r, env)) match {
      case (BoolVal(l), BoolVal(r)) => BoolVal(l && r)
    }
    case Not(e) => eval(e, env) match {
      case BoolVal(e) => BoolVal(!e)
    }
    case Equal(l, r) => (eval(l, env), eval(r, env)) match {
      case (BoolVal(l), BoolVal(r)) => BoolVal(l == r)
      case (NumberVal(l), NumberVal(r)) => BoolVal(l == r)
      case (StringVal(l), StringVal(r)) => BoolVal(l == r)
    }
    case NotEqual(l, r) => (eval(l, env), eval(r, env)) match {
      case (BoolVal(l), BoolVal(r)) => BoolVal(l != r)
      case (NumberVal(l), NumberVal(r)) => BoolVal(l != r)
      case (StringVal(l), StringVal(r)) => BoolVal(l != r)
    }
    case LessThan(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => BoolVal(l < r)
    }
    case LessThanEqual(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => BoolVal(l <= r)
    }
    case GreaterThan(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) =>BoolVal(l > r)
    }
    case GreaterThanEqual(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => BoolVal(l >= r)
    }
    case Add(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => NumberVal(l + r)
    }
    case Sub(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => NumberVal(l - r)
    }
    case Mul(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => NumberVal(l * r)
    }
    case Div(l, r) => (eval(l, env), eval(r, env)) match {
      case (NumberVal(l), NumberVal(r)) => NumberVal(l / r)
    }
    case Variable(v) => env getOrElse(v, sys.error("Undefined variable" + v))
    case BooleanLiteral(value) => BoolVal(value)
    case NumberLiteral(value) => NumberVal(value)
    case StringLiteral(value) => StringVal(value)
  }

}
