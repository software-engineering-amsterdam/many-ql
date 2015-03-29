package ql.typechecker

import ql.ast._
import types.{TypeEnvironment, VariableName}

import scala.util.parsing.input.Position

class TypeChecker {

  def check(f: Form, env: TypeEnvironment = Map()): (List[Error], TypeEnvironment) = check(f.statements, env)

  def check(s: Statement, env: TypeEnvironment): (List[Error], TypeEnvironment) = s match {
    case Sequence(statements) => checkSequence(statements, env)
    case i: IfStatement => checkIfStatement(i, env)
    case q: Question => checkQuestionStatement(q, env)
  }

  def check(expression: Expression, env: TypeEnvironment): Either[Error, Type] = expression match {
    case e: Or =>  checkBooleanExpression(e.lhs, e.rhs, env, e.pos)
    case e: And => checkBooleanExpression(e.lhs, e.rhs, env, e.pos)
    case e: Not => checkBooleanExpression(e.expression, env, e.pos)
    case e: Equal => checkEqualityExpression(e.lhs, e.rhs, env, e.pos)
    case e: NotEqual => checkEqualityExpression(e.lhs, e.rhs, env, e.pos)
    case e: LessThan => checkRelationalExpression(e.lhs, e.rhs, env, e.pos)
    case e: LessThanEqual => checkRelationalExpression(e.lhs, e.rhs, env, e.pos)
    case e: GreaterThan => checkRelationalExpression(e.lhs, e.rhs, env, e.pos)
    case e: GreaterThanEqual => checkRelationalExpression(e.lhs, e.rhs, env, e.pos)
    case e: Add => checkArithmeticExpression(e.lhs, e.rhs, env, e.pos)
    case e: Sub => checkArithmeticExpression(e.lhs, e.rhs, env, e.pos)
    case e: Mul => checkArithmeticExpression(e.lhs, e.rhs, env, e.pos)
    case e: Div => checkArithmeticExpression(e.lhs, e.rhs, env, e.pos)
    case e: Negation => checkArithmeticExpression(e.expression, env, e.pos)
    case v: Variable => checkVariable(v.name, env, v.pos)
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
      case Right(_) => List(Error("Invalid boolean condition for if statement", Some(i.pos)))
      case Left(e) => List(e)
    }

    val (errorsInBlocks, envWithIfAndElseBlock) = i.elseBlock match {
      case None => check(i.ifBlock, env)
      case Some(elseBlock) =>
        val (errorsInIfBlock, envWithIfBlock) = check(i.ifBlock, env)
        val (errorsInElseBlock, envWithIfAndElseBlock) = check(elseBlock, envWithIfBlock)
        (errorsInIfBlock ++ errorsInElseBlock, envWithIfAndElseBlock)
    }

    (errorInExpression ++ errorsInBlocks, envWithIfAndElseBlock)
  }

  def checkQuestionStatement(q: Question, env: TypeEnvironment): (List[Error], TypeEnvironment) = {
    val updatedEnv = tryAddQuestionToEnvironment(q, env)

    val errorInExpression = q.expression match {
      case None => List()
      case Some(expression) => check(expression, env) match {
        case Right(t: Type) if t != q._type  => List(Error(s"Invalid expression type for computed question: expected ${q._type}, got $t", Some(q.pos)))
        case Right(t: Type) if t == q._type => List()
        case Left(e) => List(e)
      }
    }

    updatedEnv.fold({ error => (error :: errorInExpression, env) }, { newEnv => (errorInExpression, newEnv) })
  }

  def tryAddQuestionToEnvironment(q: Question, env: TypeEnvironment): Either[Error, TypeEnvironment] = {
    val name = q.variable.name

    env get name match {
      case Some(t) if t != q._type => Left(Error(s"Variable $name is already defined as a $t", Some(q.pos)))
      case Some(t) if t == q._type => Right(env)
      case None => Right(env + (name -> q._type))
    }
  }

  def checkBooleanExpression(e: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    check(e, env) match {
      case Right(BooleanType()) => Right(BooleanType())
      case Left(error) => Left(error)
      case _ => Left(Error("Invalid boolean expression", Some(p)))
    }
  }

  def checkBooleanExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(BooleanType()), Right(BooleanType())) => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(Error("Invalid boolean expression", Some(p)))
    }
  }

  def checkEqualityExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(t1), Right(t2)) if t1 == t2 => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(Error("Invalid equality expression", Some(p)))
    }
  }

  def checkRelationalExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(NumberType()), Right(NumberType())) => Right(BooleanType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(Error("Invalid relational expression", Some(p)))
    }
  }

  def checkArithmeticExpression(e: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    check(e, env) match {
      case Right(NumberType()) => Right(NumberType())
      case Left(error) => Left(error)
      case _ => Left(Error("Invalid negation expression", Some(p)))
    }
  }

  def checkArithmeticExpression(lhs: Expression, rhs: Expression, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    (check(lhs, env), check(rhs, env)) match {
      case (Right(NumberType()), Right(NumberType())) => Right(NumberType())
      case (Left(e), _) => Left(e)
      case (_, Left(e)) => Left(e)
      case _ => Left(Error("Invalid arithmetic expression", Some(p)))
    }
  }

  def checkVariable(name: VariableName, env: TypeEnvironment, p: Position): Either[Error, Type] = {
    env get name match {
      case Some(t) => Right(t)
      case None => Left(Error(s"Variable $name is not defined", Some(p)))
    }
  }
}
