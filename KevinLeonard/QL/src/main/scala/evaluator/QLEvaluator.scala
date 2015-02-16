package evaluator

import ast.QLAST
import scala.io.StdIn
import scala.collection.immutable.Map

class QLEvaluator {
  import QLAST._

  type VariableName = String
  type VariableValue = Any // TODO: fix specificity of type
  type Environment = Map[VariableName, VariableValue]
  val emptyEnvironment = Map[VariableName, VariableValue] ()

  def eval(f: Form, environment: Environment = emptyEnvironment) : Environment = eval(f.e, environment)

  def eval(s: Statement, env: Environment): Environment = s match {
    case Sequence(statements) => statements.foldLeft(env) { (env, s) => eval(s, env) }
    case IfStatement(e, s1, None) => eval(e, env) match {
      case true => eval(s1, env)
      case _ => env
    }
    case IfStatement(e, s1, Some(s2)) => eval(e, env) match {
      case true => eval(s1, env)
      case false => eval(s2, env)
    }
    case BooleanQuestion(Variable(name), label) =>
      println(label)
      val value = StdIn.readBoolean()
      env + (name -> value)
    case IntegerQuestion(Variable(name), label) =>
      println(label)
      val value = StdIn.readInt()
      env + (name -> value)
    case StringQuestion(Variable(name), label) =>
      println(label)
      val value = StdIn.readLine()
      env + (name -> value)
    case ComputedBooleanQuestion(Variable(name), label, e) =>
      println(label + "[default: " + eval(e, env) + "]")
      val value = StdIn.readBoolean()
      env + (name -> value)
    case ComputedIntegerQuestion(Variable(name), label, e) =>
      println(label + "[default: " + eval(e, env) + "]")
      val value = StdIn.readInt()
      env + (name -> value)
    case ComputedStringQuestion(Variable(name), label, e) =>
      println(label + "[default: " + eval(e, env) + "]")
      val value = StdIn.readLine()
      env + (name -> value)
  }

  // TODO: fix specificity of return type
  def eval(e: Expression, env: Environment): Any = e match {
    case Or(l, r) =>  (eval(l, env), eval(r, env)) match {
      case (l: Boolean, r: Boolean) => l || r
    }
    case And(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Boolean, r: Boolean) => l && r
    }
    case Not(e) => eval(e, env) match {
      case e: Boolean => !e
    }
    case Equal(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Boolean, r: Boolean) => l == r
      case (l: Int, r: Int) => l == r
      case (l: String, r: String) => l == r
    }
    case NotEqual(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Boolean, r: Boolean) => l != r
      case (l: Int, r: Int) => l != r
      case (l: String, r: String) => l != r
    }
    case LessThan(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l < r
    }
    case LessThanEqual(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l <= r
    }
    case GreaterThan(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l > r
    }
    case GreaterThanEqual(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l >= r
    }
    case Add(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l + r
    }
    case Sub(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l - r
    }
    case Mul(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l * r
    }
    case Div(l, r) => (eval(l, env), eval(r, env)) match {
      case (l: Int, r: Int) => l / r
    }
    case Variable(v) => env getOrElse(v, sys.error("Undefined variable" + v))
    case BooleanLiteral(value) => value
    case NumberLiteral(value) => value
    case StringLiteral(value) => value
  }

}
