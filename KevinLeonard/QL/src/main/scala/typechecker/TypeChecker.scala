package typechecker

import ast._

class TypeChecker {

  def check(form: Form, env: TypeEnvironment = new TypeEnvironment()): TypeEnvironment = check(form.s, env)

  def check(s: Statement, env: TypeEnvironment): TypeEnvironment = s match {
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
    case s @ Question(BooleanType(), v: Variable, label: String, None) => env.tryAddVariable(v, BooleanType()).tryAddLabel(s)
    case s @ Question(BooleanType(), v: Variable, label: String, Some(e: Expression)) => check(e, env) match {
      case BooleanType() => env.tryAddVariable(v, BooleanType()).tryAddLabel(s)
      case _ => sys.error(s"Invalid expression for value of computed boolean question at line ${s.pos}")
    }
    case s @ Question(NumberType(), v: Variable, label: String, None) => env.tryAddVariable(v, NumberType()).tryAddLabel(s)
    case s @ Question(NumberType(), v: Variable, label: String, Some(e: Expression)) => check(e, env) match {
      case NumberType() => env.tryAddVariable(v, NumberType()).tryAddLabel(s)
      case _ => sys.error(s"Invalid expression for value of computed number expression at line ${s.pos}")
    }
    case s @ Question(StringType(), v: Variable, label: String, None) => env.tryAddVariable(v, StringType()).tryAddLabel(s)
    case s @ Question(StringType(), v: Variable, label: String, Some(e: Expression)) => check(e, env) match {
      case StringType() => env.tryAddVariable(v, StringType()).tryAddLabel(s)
      case _ => sys.error(s"Invalid expression for value of computed string expression at line ${s.pos}")
    }
  }

  def check(expression: Expression, env: TypeEnvironment): Type = expression match {
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
    case Literal(t, _) => t
  }

}
