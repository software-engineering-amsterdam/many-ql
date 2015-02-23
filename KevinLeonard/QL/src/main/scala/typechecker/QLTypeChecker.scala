package typechecker

import ast._

class QLTypeChecker {

  def check(form: Form, env: Environment = new Environment()): Environment = check(form.e, env)

  def check(statement: Statement, env: Environment): Environment = statement match {
    case Sequence(statements: List[Statement]) => statements.foldLeft(env) { (env, statement) => check(statement, env) }
    case s @ IfStatement(e: Expression, s1: Statement, None) => check(e, env) match {
      case BooleanType() =>
        check(s1, env)
        env // Return environment without the questions in s1.
      case _ => sys.error(s"Invalid boolean condition for if statement at line ${s.pos}")
    }
    case s @ IfStatement(e: Expression, s1: Statement, Some(s2: Statement)) => check(e, env) match {
      case BooleanType() =>
        check(s1, env)
        check(s2, env)
        env // Return environment without the questions in s1 and s2.
      case _ => sys.error(s"Invalid boolean condition for if statement at line ${s.pos}")
    }
    case BooleanQuestion(v: Variable, label: String, None) => env.tryAddVariable(v.name, BooleanType()).tryAddLabel(label)
    case NumberQuestion(v: Variable, label: String, None) => env.tryAddVariable(v.name, NumberType()).tryAddLabel(label)
    case StringQuestion(v: Variable, label: String, None) => env.tryAddVariable(v.name, StringType()).tryAddLabel(label)
    case s @ BooleanQuestion(v: Variable, label: String, Some(e: Expression)) => check(e, env) match {
      case BooleanType() => env.tryAddVariable(v.name, BooleanType()).tryAddLabel(label)
      case _ => sys.error(s"Invalid expression for value of computed boolean question at line ${s.pos}")
    }
    case s @ NumberQuestion(v: Variable, label: String, Some(e: Expression)) => check(e, env) match {
      case NumberType() => env.tryAddVariable(v.name, NumberType()).tryAddLabel(label)
      case _ => sys.error(s"Invalid expression for value of computed number expression at line ${s.pos}")
    }
    case s @ StringQuestion(v: Variable, label: String, Some(e: Expression)) => check(e, env) match {
      case StringType() => env.tryAddVariable(v.name, StringType()).tryAddLabel(label)
      case _ => sys.error(s"Invalid expression for value of computed string expression at line ${s.pos}")
    }
  }

  def check(expression: Expression, env: Environment): Type = expression match {
    case e @ Or(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanType(), BooleanType()) => BooleanType()
      case _ => sys.error(s"Invalid or expression at line ${e.pos}")
    }
    case e @ And(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanType(), BooleanType()) => BooleanType()
      case _ => sys.error(s"Invalid and expression at line ${e.pos}")
    }
    case e @ Not(expr: Expression) => check(expr, env) match {
      case BooleanType() => BooleanType()
      case _ => sys.error(s"Invalid not expression at line ${e.pos}")
    }
    case e @ Equal(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanType(), BooleanType()) => BooleanType()
      case (NumberType(), NumberType()) => BooleanType()
      case (StringType(), StringType()) => BooleanType()
      case _ => sys.error(s"Invalid == expression at line ${e.pos}")
    }
    case e @ NotEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanType(), BooleanType()) => BooleanType()
      case (NumberType(), NumberType()) => BooleanType()
      case (StringType(), StringType()) => BooleanType()
      case _ => sys.error(s"Invalid != expression at line ${e.pos}")
    }
    case e @ LessThan(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => BooleanType()
      case _ => sys.error(s"Invalid < expression at line ${e.pos}")
    }
    case e @ LessThanEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => BooleanType()
      case _ => sys.error(s"Invalid <= expression at line ${e.pos}")
    }
    case e @ GreaterThan(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => BooleanType()
      case _ => sys.error(s"Invalid > than expression at line ${e.pos}")
    }
    case e @ GreaterThanEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => BooleanType()
      case _ => sys.error(s"Invalid >= expression at line ${e.pos}")
    }
    case e @ Add(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => NumberType()
      case _ => sys.error(s"Invalid addition expression at line ${e.pos}")
    }
    case e @ Sub(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => NumberType()
      case _ => sys.error(s"Invalid subtraction expression at line ${e.pos}")
    }
    case e @ Mul(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => NumberType()
      case _ => sys.error(s"Invalid multiplication expression at line ${e.pos}")
    }
    case e @ Div(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberType(), NumberType()) => NumberType()
      case _ => sys.error(s"Invalid division expression at line ${e.pos}")
    }
    case v: Variable => env.tryGetVariable(v)
    case BooleanLiteral(_) => BooleanType()
    case NumberLiteral(_) => NumberType()
    case StringLiteral(_) => StringType()
  }

}

sealed trait Type
case class BooleanType() extends Type
case class NumberType() extends Type
case class StringType() extends Type

class Environment(val typeOfFields: Map[String, Type] = Map(), val labels: List[String] = List()) {

  def tryGetVariable(v: Variable): Type = typeOfFields getOrElse(v.name, sys.error(s"Undefined variable ${v.name} at line ${v.pos}"))

  def tryAddVariable(name: String, _type: Type): Environment = {
    if (typeOfFields contains name) {
      sys.error(s"Variable $name is already defined")
    } else {
      new Environment(typeOfFields + (name -> _type), labels)
    }
  }

  def tryAddLabel(label: String): Environment = {
    if (labels contains label) {
      sys.error(s"Label $label is already defined")
    } else {
      new Environment(typeOfFields, labels :+ label)
    }
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Environment]

  override def equals(other: Any): Boolean = other match {
    case that: Environment =>
      (that canEqual this) &&
        typeOfFields == that.typeOfFields &&
        labels == that.labels
    case _ => false
  }

}
