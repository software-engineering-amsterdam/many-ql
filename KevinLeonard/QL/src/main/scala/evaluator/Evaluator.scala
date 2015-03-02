package evaluator

import ast._
import scalafx.collections.ObservableMap

class Evaluator {

  type VariableName = String
  type EvalEnvironment = ObservableMap[VariableName, Value]

  def eval(f: Form, environment: EvalEnvironment = ObservableMap.empty[VariableName, Value]): EvalEnvironment = eval(f.s, environment)

  def eval(s: Statement, env: EvalEnvironment): EvalEnvironment = s match {
    case Sequence(statements) => statements.foldLeft(env) { (env, s) => eval(s, env)}
    case i: IfStatement => doIfStatement(i, env)
    case q: Question => doQuestionStatement(q, env)
  }

  def eval(e: Expression, env: EvalEnvironment): Value = e match {
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
    case Variable(v) => env getOrElse(v, throw new AssertionError(s"Error in type checker. Undefined variable $v."))
    case Literal(_, v) => v
  }

  def doIfStatement(i: IfStatement, env: EvalEnvironment): EvalEnvironment = {
     eval(i.expression, env) match {
      case BooleanValue(true) => eval(i.ifBlock, env)
      case BooleanValue(false) => i.optionalElseBlock match {
        case None => env
        case Some(elseBlock) => eval(elseBlock, env)
      }
      case _ => throw new AssertionError("Error in type checker. If statement expects boolean expression.")
    }
  }

  def doQuestionStatement(q: Question, env: EvalEnvironment): EvalEnvironment = {
    q.optionalExpression match {
      case None => q._type match {
        case BooleanType() => env += (q.variable.name -> BooleanValue())
        case NumberType() => env += (q.variable.name -> NumberValue())
        case StringType() => env += (q.variable.name -> StringValue())
      }
      case Some(e) => env += (q.variable.name -> eval(e, env))
    }
  }

  def doBooleanOperation(op: Boolean => Boolean, e1: Expression, env: EvalEnvironment): BooleanValue = {
    eval(e1, env) match {
      case BooleanValue(b1) => BooleanValue(op(b1))
      case _ => throw new AssertionError("Error in type checker. Boolean operator expects a boolean value.")
    }
  }

  def doBooleanOperation(op: (Boolean, Boolean) => Boolean, e1: Expression, e2: Expression, env: EvalEnvironment): BooleanValue = {
    (eval(e1, env), eval(e2, env)) match {
      case (BooleanValue(b1), BooleanValue(b2)) => BooleanValue(op(b1, b2))
      case _ => throw new AssertionError("Error in type checker. Boolean operator expects two boolean values.")
    }
  }

  def doEqualityOperation(op: (Any, Any) => Boolean, e1: Expression, e2: Expression, env: EvalEnvironment): BooleanValue = {
    (eval(e1, env), eval(e2, env)) match {
      case (BooleanValue(l), BooleanValue(r)) => BooleanValue(op(l, r))
      case (NumberValue(l), NumberValue(r)) => BooleanValue(op(l, r))
      case (StringValue(l), StringValue(r)) => BooleanValue(op(l, r))
      case _ => throw new AssertionError("Error in type checker. Equality operator expects two values of the same type.")
    }
  }

  def doOrderOperation(op: (Int, Int) => Boolean, e1: Expression, e2: Expression, env: EvalEnvironment): BooleanValue = {
    (eval(e1, env), eval(e2, env)) match {
      case (NumberValue(b1), NumberValue(b2)) => BooleanValue(op(b1, b2))
      case _ => throw new AssertionError("Error in type checker. Order operator expects two number values.")
    }
  }

  def doArithmeticOperation(op: (Int, Int) => Int, e1: Expression, e2: Expression, env: EvalEnvironment): NumberValue = {
    (eval(e1, env), eval(e2, env)) match {
      case (NumberValue(b1), NumberValue(b2)) => NumberValue(op(b1, b2))
      case _ => throw new AssertionError("Error in type checker. Arithmetic operator expects two number values.")
    }
  }
}
