package evaluator

import ast._
import scala.collection.immutable.Map

class QLEvaluator {

  type VariableName = String
  sealed trait VariableValue
  case class BoolVal(v: Boolean = false) extends VariableValue
  case class NumberVal(v: Int = 0) extends VariableValue
  case class StringVal(v: String = "") extends VariableValue
  type Environment = Map[VariableName, VariableValue]

  val emptyEnvironment = Map[VariableName, VariableValue]()

  def eval(f: Form, environment: Environment = emptyEnvironment): Environment = eval(f.e, environment)

  def eval(s: Statement, env: Environment): Environment = s match {
    case Sequence(statements) => statements.foldLeft(env) { (env, s) => eval(s, env) }
    case IfStatement(e, s1, None) => mkIfStatement(e, env, eval(s1, env), env)
    case IfStatement(e, s1, Some(s2)) => mkIfStatement(e, env, eval(s1, env), eval(s2, env))
    case BooleanQuestion(Variable(name), label) => env + (name -> BoolVal())
    case NumberQuestion(Variable(name), label) => env + (name -> NumberVal())
    case StringQuestion(Variable(name), label) => env + (name -> StringVal())
    case ComputedBooleanQuestion(Variable(name), label, e) => env + (name -> eval(e, env))
    case ComputedNumberQuestion(Variable(name), label, e) => env + (name -> eval(e, env))
    case ComputedStringQuestion(Variable(name), label, e) => env + (name -> eval(e, env))
  }

  def eval(e: Expression, env: Environment): VariableValue = e match {
    case Or(l, r) => mkBooleanOperation(_ || _, eval(l, env), eval(r, env))
    case And(l, r) => mkBooleanOperation(_ && _, eval(l, env), eval(r, env))
    case Not(e1) => mkBooleanOperation(!_, eval(e1, env))
    case Equal(l, r) => mkEqualityOperation(_ == _, eval(l, env), eval(r, env))
    case NotEqual(l, r) => mkEqualityOperation(_ != _, eval(l, env), eval(r, env))
    case LessThan(l, r) => mkOrderOperation(_ < _, eval(l, env), eval(r, env))
    case LessThanEqual(l, r) => mkOrderOperation(_ <= _, eval(l, env), eval(r, env))
    case GreaterThan(l, r) => mkOrderOperation(_ > _, eval(l, env), eval(r, env))
    case GreaterThanEqual(l, r) => mkOrderOperation(_ >= _, eval(l, env), eval(r, env))
    case Add(l, r) => mkArithmeticOperation(_ + _, eval(l, env), eval(r, env))
    case Sub(l, r) => mkArithmeticOperation(_ - _, eval(l, env), eval(r, env))
    case Mul(l, r) => mkArithmeticOperation(_ * _, eval(l, env), eval(r, env))
    case Div(l, r) => mkArithmeticOperation(_ / _, eval(l, env), eval(r, env))
    case Variable(v) => env getOrElse(v, sys.error(s"Error in type checker. Undefined variable $v."))
    case BooleanLiteral(value) => BoolVal(value)
    case NumberLiteral(value) => NumberVal(value)
    case StringLiteral(value) => StringVal(value)
  }

  // Parameters ifTrue and ifFalse are evaluated lazy.
  def mkIfStatement(e: Expression, env: Environment, ifTrue: => Environment, ifFalse: => Environment): Environment = {
    eval(e, env) match {
      case BoolVal(true) => ifTrue
      case BoolVal(false) => ifFalse
      case _ => sys.error("Error in type checker. If statement expects boolean expression.")
    }
  }

  def mkBooleanOperation(op: Boolean => Boolean, e1: VariableValue): BoolVal = {
    e1 match {
      case BoolVal(b1) => BoolVal(op(b1))
      case _ => sys.error("Error in type checker. Boolean operator expects a boolean value.")
    }
  }

  def mkBooleanOperation(op: (Boolean, Boolean) => Boolean, e1: VariableValue, e2: VariableValue): BoolVal = {
    (e1, e2) match {
      case (BoolVal(b1), BoolVal(b2)) => BoolVal(op(b1, b2))
      case _ => sys.error("Error in type checker. Boolean operator expects two boolean values.")
    }
  }

  def mkEqualityOperation(op: (Any, Any) => Boolean, e1: VariableValue, e2: VariableValue): BoolVal = {
    (e1, e2) match {
      case (BoolVal(l), BoolVal(r)) => BoolVal(op(l, r))
      case (NumberVal(l), NumberVal(r)) => BoolVal(op(l, r))
      case (StringVal(l), StringVal(r)) => BoolVal(op(l, r))
      case _ => sys.error("Error in type checker. Equality operator expects two values of the same type.")
    }
  }

  def mkOrderOperation(op: (Int, Int) => Boolean, e1: VariableValue, e2: VariableValue): BoolVal = {
    (e1, e2) match {
      case (NumberVal(b1), NumberVal(b2)) => BoolVal(op(b1, b2))
      case _ => sys.error("Error in type checker. Order operator expects two number values.")
    }
  }

  def mkArithmeticOperation(op: (Int, Int) => Int, e1: VariableValue, e2: VariableValue): NumberVal = {
    (e1, e2) match {
      case (NumberVal(b1), NumberVal(b2)) => NumberVal(op(b1, b2))
      case _ => sys.error("Error in type checker. Arithmetic operator expects two number values.")
    }
  }

}
