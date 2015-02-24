package typechecker

import ast._
import scala.util.parsing.input.Position

class TypeChecker {

  def check(form: Form, env: TypeEnvironment = new TypeEnvironment()): TypeEnvironment = check(form.s, env)

  def check(s: Statement, env: TypeEnvironment): TypeEnvironment = s match {
    case Sequence(statements: List[Statement]) => statements.foldLeft(env) { (env, statement) => check(statement, env) }
    case i: IfStatement => checkIfStatement(i, env)
    case q: Question => checkQuestionStatement(q, env)
  }

  def check(expression: Expression, env: TypeEnvironment): Type = expression match {
    case e @ Or(l: Expression, r: Expression) =>  checkBooleanExpression(l, r, env, e.pos)
    case e @ And(l: Expression, r: Expression) => checkBooleanExpression(l, r, env, e.pos)
    case e @ Not(e1: Expression) => checkBooleanExpression(e1, env, e.pos)
    case e @ Equal(l: Expression, r: Expression) => checkEqualityExpression(l, r, env, e.pos)
    case e @ NotEqual(l: Expression, r: Expression) => checkEqualityExpression(l, r, env, e.pos)
    case e @ LessThan(l: Expression, r: Expression) => checkOrderExpression(l, r, env, e.pos)
    case e @ LessThanEqual(l: Expression, r: Expression) => checkOrderExpression(l, r, env, e.pos)
    case e @ GreaterThan(l: Expression, r: Expression) => checkOrderExpression(l, r, env, e.pos)
    case e @ GreaterThanEqual(l: Expression, r: Expression) => checkOrderExpression(l, r, env, e.pos)
    case e @ Add(l: Expression, r: Expression) => checkArithmeticExpression(l, r, env, e.pos)
    case e @ Sub(l: Expression, r: Expression) => checkArithmeticExpression(l, r, env, e.pos)
    case e @ Mul(l: Expression, r: Expression) => checkArithmeticExpression(l, r, env, e.pos)
    case e @ Div(l: Expression, r: Expression) => checkArithmeticExpression(l, r, env, e.pos)
    case v: Variable => env.tryGetVariable(v)
    case Literal(t, _) => t
  }
  
  def checkIfStatement(i: IfStatement, env: TypeEnvironment): TypeEnvironment = {
    check(i.expression, env) match {
      // Return environment without the questions in s1 and s2.
      case BooleanType() => i.optionalElseBlock match {
        case None => check(i.ifBlock, env); env
        case Some(elseBlock) => check(i.ifBlock, env); check(elseBlock, env); env
      }
      case _ => sys.error(s"Invalid boolean condition for if statement at line ${i.pos}")
    }
  }

  def checkQuestionStatement(q: Question, env: TypeEnvironment): TypeEnvironment = {
    q.optionalExpression match {
      case None => env.tryAddVariable(q.variable, q._type).tryAddLabel(q.label, q.pos)
      case Some(e) => check(e, env) match {
        case q._type => env.tryAddVariable(q.variable, q._type).tryAddLabel(q.label, q.pos)
        case _ => sys.error(s"Invalid expression for value of computed expression at line ${q.pos}")
      }
    }
  }

  def checkBooleanExpression(e1: Expression, env: TypeEnvironment, p: Position): Type = {
    check(e1, env) match {
      case BooleanType() => BooleanType()
      case _ => sys.error(s"Invalid boolean expression at line $p")
    }
  }

  def checkBooleanExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Type = {
    (check(e1, env), check(e2, env)) match {
      case (BooleanType(), BooleanType()) => BooleanType()
      case _ => sys.error(s"Invalid boolean expression at line $p")
    }
  }

  def checkEqualityExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Type = {
    (check(e1, env), check(e2, env)) match {
      case (BooleanType(), BooleanType()) => BooleanType()
      case (NumberType(), NumberType()) => BooleanType()
      case (StringType(), StringType()) => BooleanType()
      case _ => sys.error(s"Invalid equality expression at line $p")
    }
  }

  def checkOrderExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Type = {
    (check(e1, env), check(e2, env)) match {
      case (NumberType(), NumberType()) => BooleanType()
      case _ => sys.error(s"Invalid order expression at line $p")
    }
  }

  def checkArithmeticExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Type = {
    (check(e1, env), check(e2, env)) match {
      case (NumberType(), NumberType()) => NumberType()
      case _ => sys.error(s"Invalid arithmetic expression at line $p")
    }
  }

}
