package ql.typechecker

import ql.ast._

import scala.util.parsing.input.Position

class TypeChecker {

  def check(f: Form, env: TypeEnvironment = new TypeEnvironment()): List[Error] = check(f.statements, env)._1

  def check(s: Statement, env: TypeEnvironment): (List[Error], TypeEnvironment) = s match {
    case Sequence(statements) => checkSequence(statements, env)
    case i: IfStatement => checkIfStatement(i, env)
    case q: Question => checkQuestionStatement(q, env)
  }

  def check(expression: Expression, env: TypeEnvironment): Either[Error, Type] = expression match {
    case e @ Or(lhs, rhs) =>  checkBooleanExpression(lhs, rhs, env, e.pos)
    case e @ And(lhs, rhs) => checkBooleanExpression(lhs, rhs, env, e.pos)
    case e @ Not(e1) => checkBooleanExpression(e1, env, e.pos)
    case e @ Equal(lhs, rhs) => checkEqualityExpression(lhs, rhs, env, e.pos)
    case e @ NotEqual(lhs, rhs) => checkEqualityExpression(lhs, rhs, env, e.pos)
    case e @ LessThan(lhs, rhs) => checkRelationalExpression(lhs, rhs, env, e.pos)
    case e @ LessThanEqual(lhs, rhs) => checkRelationalExpression(lhs, rhs, env, e.pos)
    case e @ GreaterThan(lhs, rhs) => checkRelationalExpression(lhs, rhs, env, e.pos)
    case e @ GreaterThanEqual(lhs, rhs) => checkRelationalExpression(lhs, rhs, env, e.pos)
    case e @ Add(lhs, rhs) => checkArithmeticExpression(lhs, rhs, env, e.pos)
    case e @ Sub(lhs, rhs) => checkArithmeticExpression(lhs, rhs, env, e.pos)
    case e @ Mul(lhs, rhs) => checkArithmeticExpression(lhs, rhs, env, e.pos)
    case e @ Div(lhs, rhs) => checkArithmeticExpression(lhs, rhs, env, e.pos)
    case v: Variable => env.tryGetVariable(v)
    case BooleanLiteral(_) => Right(BooleanType())
    case NumberLiteral(_) => Right(NumberType())
    case StringLiteral(_) => Right(StringType())
  }

  def checkSequence(statements: List[Statement], env: TypeEnvironment): (List[Error], TypeEnvironment) = {
    statements.foldLeft((List[Error](), env)) {
      case ((accumulatedErrors, accumulatedEnv), statement) =>
        val (newErrors, newEnv) = check(statement, accumulatedEnv)
        (accumulatedErrors ++ newErrors, newEnv)
    }
  }

  def checkIfStatement(i: IfStatement, env: TypeEnvironment): (List[Error], TypeEnvironment) = {
    val errorInExpression = check(i.expression, env) match {
      case Right(BooleanType()) => List()
      case Right(_) => List(new Error("Invalid boolean condition for if statement at line", i.pos))
      case Left(e) => List(e)
    }

    val errorsInBlocks = i.elseBlock match {
      case None => check(i.ifBlock, env)._1
      case Some(elseBlock) =>
        val errorsInIfBlock = check(i.ifBlock, env)._1
        val errorsInElseBlock = check(elseBlock, env)._1
        errorsInIfBlock ++ errorsInElseBlock
    }

    // Return environment without the questions in s1 and s2.
    (errorInExpression ++ errorsInBlocks, env)
  }

  def checkQuestionStatement(q: Question, env: TypeEnvironment): (List[Error], TypeEnvironment) = {
    val updatedEnv = tryAddQuestionToEnvironment(q, env)

    val errorInExpression = q.expression match {
      case None => List()
      case Some(expression) => check(expression, env) match {
        case Right(t: Type) if t == q._type => List()
        case Right(_) => List(new Error("Invalid expression type for computed question at line", q.pos))
        case Left(e) => List(e)
      }
    }

    updatedEnv.fold({ error => (error :: errorInExpression, env) }, { newEnv => (errorInExpression, newEnv) })
  }

  def tryAddQuestionToEnvironment(q: Question, env: TypeEnvironment): Either[Error, TypeEnvironment] = {
    env.tryAddVariable(q.variable, q._type)
  }

  def checkBooleanExpression(e: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    check(e, env) match {
      case Right(BooleanType()) => Right(BooleanType())
      case Left(error) => Left(error)
      case _ => Left(new Error("Invalid boolean expression at line", p))
    }
  }

  def checkBooleanExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(BooleanType()), Right(BooleanType())) => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error("Invalid boolean expression at line", p))
    }
  }

  def checkEqualityExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(t1), Right(t2)) if t1 == t2 => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error("Invalid equality expression at line", p))
    }
  }

  def checkRelationalExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(NumberType()), Right(NumberType())) => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error("Invalid relational expression at line", p))
    }
  }

  def checkArithmeticExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(NumberType()), Right(NumberType())) => Right(NumberType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(new Error("Invalid arithmetic expression at line", p))
    }
  }
}
