package ql.evaluator

import ql.ast._
import ql.types.EvalEnvironment

class Evaluator {

  def eval(e: Expression, env: EvalEnvironment): Value = e match {
    case Or(lhs, rhs) => doBooleanOperation(_ || _, lhs, rhs, env)
    case And(lhs, rhs) => doBooleanOperation(_ && _, lhs, rhs, env)
    case Not(e1) => doBooleanOperation(!_, e1, env)
    case Equal(lhs, rhs) => doEqualityOperation(_ == _, lhs, rhs, env)
    case NotEqual(lhs, rhs) => doEqualityOperation(_ != _, lhs, rhs, env)
    case LessThan(lhs, rhs) => doRelationalOperation(_ < _, lhs, rhs, env)
    case LessThanEqual(lhs, rhs) => doRelationalOperation(_ <= _, lhs, rhs, env)
    case GreaterThan(lhs, rhs) => doRelationalOperation(_ > _, lhs, rhs, env)
    case GreaterThanEqual(lhs, rhs) => doRelationalOperation(_ >= _, lhs, rhs, env)
    case Add(lhs, rhs) => doArithmeticOperation(_ + _, lhs, rhs, env)
    case Sub(lhs, rhs) => doArithmeticOperation(_ - _, lhs, rhs, env)
    case Mul(lhs, rhs) => doArithmeticOperation(_ * _, lhs, rhs, env)
    case Div(lhs, rhs) => doArithmeticOperation(_ / _, lhs, rhs, env)
    case Variable(v) => env getOrElse(v, throw new AssertionError(s"Error in type checker. Undefined variable $v."))
    case Literal(_, v) => v
  }

  def doBooleanOperation(op: Boolean => Boolean, e: Expression, env: EvalEnvironment): BooleanValue = {
    eval(e, env) match {
      case BooleanValue(v) => BooleanValue(op(v))
      case _ => throw new AssertionError("Error in type checker. Boolean operator expects a boolean value.")
    }
  }

  def doBooleanOperation(op: (Boolean, Boolean) => Boolean, lhs: Expression, rhs: Expression, env: EvalEnvironment): BooleanValue = {
    (eval(lhs, env), eval(rhs, env)) match {
      case (BooleanValue(v1), BooleanValue(v2)) => BooleanValue(op(v1, v2))
      case _ => throw new AssertionError("Error in type checker. Boolean operator expects two boolean values.")
    }
  }

  def doEqualityOperation(op: (Any, Any) => Boolean, lhs: Expression, rhs: Expression, env: EvalEnvironment): BooleanValue = {
    (eval(lhs, env), eval(rhs, env)) match {
      case (BooleanValue(v1), BooleanValue(v2)) => BooleanValue(op(v1, v2))
      case (NumberValue(v1), NumberValue(v2)) => BooleanValue(op(v1, v2))
      case (StringValue(v1), StringValue(v2)) => BooleanValue(op(v1, v2))
      case _ => throw new AssertionError("Error in type checker. Equality operator expects two values of the same type.")
    }
  }

  def doRelationalOperation(op: (Int, Int) => Boolean, lhs: Expression, rhs: Expression, env: EvalEnvironment): BooleanValue = {
    (eval(lhs, env), eval(rhs, env)) match {
      case (NumberValue(v1), NumberValue(v2)) => BooleanValue(op(v1, v2))
      case _ => throw new AssertionError("Error in type checker. Relational operator expects two number values.")
    }
  }

  def doArithmeticOperation(op: (Int, Int) => Int, lhs: Expression, rhs: Expression, env: EvalEnvironment): NumberValue = {
    (eval(lhs, env), eval(rhs, env)) match {
      case (NumberValue(v1), NumberValue(v2)) => NumberValue(op(v1, v2))
      case _ => throw new AssertionError("Error in type checker. Arithmetic operator expects two number values.")
    }
  }
}
