package evaluator

import ast._
import scala.collection.immutable.Map

class QLEvaluator {

  sealed trait VariableValue
  case class BoolVal(v: Boolean = false) extends VariableValue
  case class NumberVal(v: Int = 0) extends VariableValue
  case class StringVal(v: String = "") extends VariableValue

  type VariableName = String
  type Environment = Map[VariableName, VariableValue]

  val emptyEnvironment = Map[VariableName, VariableValue]()

  def eval(f: Form, environment: Environment = emptyEnvironment): Environment = eval(f.e, environment)

  def eval(s: Statement, env: Environment): Environment = s match {
    case Sequence(statements) => statements.foldLeft(env) { (env, s) => eval(s, env)}
    case IfStatement(e, ifBody, elseBodyOption) => doIfStatement(e, env, ifBody, elseBodyOption)
    case BooleanQuestion(Variable(name), label, None) => env + (name -> BoolVal())
    case NumberQuestion(Variable(name), label, None) => env + (name -> NumberVal())
    case StringQuestion(Variable(name), label, None) => env + (name -> StringVal())
    case BooleanQuestion(Variable(name), label, Some(e)) => env + (name -> eval(e, env))
    case NumberQuestion(Variable(name), label, Some(e)) => env + (name -> eval(e, env))
    case StringQuestion(Variable(name), label, Some(e)) => env + (name -> eval(e, env))
  }

  def eval(e: Expression, env: Environment): VariableValue = e match {
    case Or(l, r) => doBooleanOperation(_ || _, l, r, env)
    case And(l, r) => doBooleanOperation(_ && _, l, r, env)
    case Not(e1) => doBooleanOperation(!_, e1, env)
    case Equal(l, r) => doEqualityOperation(_ == _, l, r, env)
    case NotEqual(l, r) => doEqualityOperation(_ != _, l, r, env)
    case LessThan(l, r) => doOrderOperation(_ < _, l, r, env)
    case LessThanEqual(l, r) => doOrderOperation(_ <= _, l, r, env)
    case GreaterThan(l, r) => doOrderOperation(_ > _, l, r, env)
    case GreaterThanEqual(l, r) => doOrderOperation(_ >= _, l, r, env)
    case Add(l, r) => doArithmeticOperation(_ + _, l, r, env)
    case Sub(l, r) => doArithmeticOperation(_ - _, l, r, env)
    case Mul(l, r) => doArithmeticOperation(_ * _, l, r, env)
    case Div(l, r) => doArithmeticOperation(_ / _, l, r, env)
    case Variable(v) => env getOrElse(v, sys.error(s"Error in type checker. Undefined variable $v."))
    case BooleanLiteral(value) => BoolVal(value)
    case NumberLiteral(value) => NumberVal(value)
    case StringLiteral(value) => StringVal(value)
  }

  def doIfStatement(e: Expression, env: Environment, ifBody: Statement, elseBodyOption: Option[Statement]): Environment = {
     eval(e, env) match {
      case BoolVal(true) => eval(ifBody, env)
      case BoolVal(false) => elseBodyOption match {
        case None => env
        case Some(elseBody) => eval(elseBody, env)
      }
      case _ => sys.error("Error in type checker. If statement expects boolean expression.")
    }
  }

  def doBooleanOperation(op: Boolean => Boolean, e1: Expression, env: Environment): BoolVal = {
    eval(e1, env) match {
      case BoolVal(b1) => BoolVal(op(b1))
      case _ => sys.error("Error in type checker. Boolean operator expects a boolean value.")
    }
  }

  def doBooleanOperation(op: (Boolean, Boolean) => Boolean, e1: Expression, e2: Expression, env: Environment): BoolVal = {
    (eval(e1, env), eval(e2, env)) match {
      case (BoolVal(b1), BoolVal(b2)) => BoolVal(op(b1, b2))
      case _ => sys.error("Error in type checker. Boolean operator expects two boolean values.")
    }
  }

  def doEqualityOperation(op: (Any, Any) => Boolean, e1: Expression, e2: Expression, env: Environment): BoolVal = {
    (eval(e1, env), eval(e2, env)) match {
      case (BoolVal(l), BoolVal(r)) => BoolVal(op(l, r))
      case (NumberVal(l), NumberVal(r)) => BoolVal(op(l, r))
      case (StringVal(l), StringVal(r)) => BoolVal(op(l, r))
      case _ => sys.error("Error in type checker. Equality operator expects two values of the same type.")
    }
  }

  def doOrderOperation(op: (Int, Int) => Boolean, e1: Expression, e2: Expression, env: Environment): BoolVal = {
    (eval(e1, env), eval(e2, env)) match {
      case (NumberVal(b1), NumberVal(b2)) => BoolVal(op(b1, b2))
      case _ => sys.error("Error in type checker. Order operator expects two number values.")
    }
  }

  def doArithmeticOperation(op: (Int, Int) => Int, e1: Expression, e2: Expression, env: Environment): NumberVal = {
    (eval(e1, env), eval(e2, env)) match {
      case (NumberVal(b1), NumberVal(b2)) => NumberVal(op(b1, b2))
      case _ => sys.error("Error in type checker. Arithmetic operator expects two number values.")
    }
  }

}
