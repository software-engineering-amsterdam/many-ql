package typechecker

import ast._
import scala.util.parsing.input.Position

class TypeChecker {

  def check(form: Form, env: TypeEnvironment = new TypeEnvironment()): Either[Error, TypeEnvironment] = check(form.s, env)

  def check(s: Statement, env: TypeEnvironment): Either[Error, TypeEnvironment] = s match {
    case Sequence(statements: List[Statement]) => checkSequence(statements, env)
    case i: IfStatement => checkIfStatement(i, env)
    case q: Question => checkQuestionStatement(q, env)
  }

  def check(expression: Expression, env: TypeEnvironment): Either[Error, Type] = expression match {
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
    case Literal(t, _) => Right(t)
  }

  def checkSequence(statements: List[Statement], env: TypeEnvironment): Either[Error, TypeEnvironment] = {
    statements match {
      case Nil => Right(env)
      case s :: ss => check(s, env).fold({ e: Error => Left(e) }, { newEnv => checkSequence(ss, newEnv) })
    }
  }

  def checkIfStatement(i: IfStatement, env: TypeEnvironment): Either[Error, TypeEnvironment] = {
    check(i.expression, env) match {
      // Return environment without the questions in s1 and s2.
      case Right(BooleanType()) => i.optionalElseBlock match {
        case None => for {
          check1 <- check(i.ifBlock, env).right
        } yield env
        case Some(elseBlock) => for {
          check1 <- check(i.ifBlock, env).right
          check2 <- check(elseBlock, env).right
        } yield env
      }
      case Right(_) => Left(new Error(Exception(), "Invalid boolean condition for if statement at line", i.pos))
      case Left(e) => Left(e)
    }
  }

  def checkQuestionStatement(q: Question, env: TypeEnvironment): Either[Error, TypeEnvironment] = {
    q.optionalExpression match {
      case None => tryAddQuestionToEnvironment(q, env)
      case Some(e) => check(e, env) match {
        case Right(t: Type) if t == q._type => tryAddQuestionToEnvironment(q, env)
        case Right(_) => Left(new Error(Exception(), "Invalid expression type for computed question at line", q.pos))
        case Left(e) => Left(e)
      }
    }
  }

  def tryAddQuestionToEnvironment(q: Question, env: TypeEnvironment): Either[Error, TypeEnvironment] = {
    for {
      env1 <- env.tryAddVariable(q.variable, q._type).right
      env2 <- env1.tryAddLabel(q.label, q.pos).right
    } yield env2
  }

  def checkBooleanExpression(e1: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    check(e1, env) match {
      case Right(BooleanType()) => Right(BooleanType())
      case Left(e) => Left(e)
      case _ => Left(new Error(Exception(), "Invalid boolean expression at line", p))
    }
  }

  // TODO: Fix these (Left, _) and (_, Left) cases
  def checkBooleanExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(e1, env), check(e2, env)) match {
      case (Right(BooleanType()), Right(BooleanType())) => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error(Exception(), "Invalid boolean expression at line", p))
    }
  }

  def checkEqualityExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(e1, env), check(e2, env)) match {
      case (Right(t1), Right(t2)) if t1 == t2 => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error(Exception(), "Invalid equality expression at line", p))
    }
  }

  def checkOrderExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(e1, env), check(e2, env)) match {
      case (Right(NumberType()), Right(NumberType())) => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error(Exception(), "Invalid order expression at line", p))
    }
  }

  def checkArithmeticExpression(e1: Expression, e2: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(e1, env), check(e2, env)) match {
      case (Right(NumberType()), Right(NumberType())) => Right(NumberType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error(Exception(), "Invalid arithmetic expression at line", p))
    }
  }
}
