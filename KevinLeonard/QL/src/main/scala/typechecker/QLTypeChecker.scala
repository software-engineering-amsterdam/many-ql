package typechecker

import ast._

class QLTypeChecker extends {

  // Holds the defined variables and their type.
  // Note that we require variables to be declared before being used.
  type Environment = Map[String, Literal]
  val emptyEnvironment = Map[String, Literal]()

  val defaultBooleanValue = BooleanLiteral(false)
  val defaultNumberValue = NumberLiteral(0)
  val defaultStringValue = StringLiteral("")

  def check(form: Form, env: Environment = emptyEnvironment): Environment = check(form.e, env)

  def check(statement: Statement, env: Environment): Environment = statement match {
    case Sequence(statements: List[Statement]) => statements.foldLeft(env) { (env, statement) => check(statement, env) }
    case s @ IfStatement(e: Expression, s1: Statement, None) => check(e, env) match {
      case BooleanLiteral(_) =>
        check(s1, env)
        env // Return environment without the questions in s1.
      case _ => sys.error(s"Invalid boolean condition for if statement at line ${s.pos}")
    }
    case s @ IfStatement(e: Expression, s1: Statement, Some(s2: Statement)) => check(e, env) match {
      case BooleanLiteral(_) =>
        check(s1, env)
        check(s2, env)
        env // Return environment without the questions in s1 and s2.
      case _ => sys.error(s"Invalid boolean condition for if statement at line ${s.pos}")
    }
    case BooleanQuestion(v: Variable, label: String) => tryAddVariable(v.name, defaultBooleanValue, env)
    case NumberQuestion(v: Variable, label: String) => tryAddVariable(v.name, defaultNumberValue, env)
    case StringQuestion(v: Variable, label: String) => tryAddVariable(v.name, defaultStringValue, env)
    case s @ ComputedBooleanQuestion(v: Variable, label: String, e: Expression) => check(e, env) match {
      case BooleanLiteral(_) => tryAddVariable(v.name, defaultBooleanValue, env)
      case _ => sys.error(s"Invalid expression for value of computed boolean question at line ${s.pos}")
    }
    case s @ ComputedNumberQuestion(v: Variable, label: String, e: Expression) => check(e, env) match {
      case NumberLiteral(_) => tryAddVariable(v.name, defaultNumberValue, env)
      case _ => sys.error(s"Invalid expression for value of computed number expression at line ${s.pos}")
    }
    case s @ ComputedStringQuestion(v: Variable, label: String, e: Expression) => check(e, env) match {
      case StringLiteral(_) => tryAddVariable(v.name, defaultStringValue, env)
      case _ => sys.error(s"Invalid expression for value of computed string expression at line ${s.pos}")
    }
  }

  def check(expression: Expression, env: Environment): Literal = expression match {
    case e @ Or(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid or expression at line ${e.pos}")
    }
    case e @ And(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid and expression at line ${e.pos}")
    }
    case e @ Not(expr: Expression) => check(expr, env) match {
      case BooleanLiteral(_) => defaultBooleanValue
      case _ => sys.error(s"Invalid not expression at line ${e.pos}")
    }
    case e @ Equal(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
      case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
      case (StringLiteral(_), StringLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid == expression at line ${e.pos}")
    }
    case e @ NotEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (BooleanLiteral(_), BooleanLiteral(_)) => defaultBooleanValue
      case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
      case (StringLiteral(_), StringLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid != expression at line ${e.pos}")
    }
    case e @ LessThan(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid < expression at line ${e.pos}")
    }
    case e @ LessThanEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid <= expression at line ${e.pos}")
    }
    case e @ GreaterThan(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid > than expression at line ${e.pos}")
    }
    case e @ GreaterThanEqual(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultBooleanValue
      case _ => sys.error(s"Invalid >= expression at line ${e.pos}")
    }
    case e @ Add(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultNumberValue
      case _ => sys.error(s"Invalid addition expression at line ${e.pos}")
    }
    case e @ Sub(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultNumberValue
      case _ => sys.error(s"Invalid subtraction expression at line ${e.pos}")
    }
    case e @ Mul(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultNumberValue
      case _ => sys.error(s"Invalid multiplication expression at line ${e.pos}")
    }
    case e @ Div(l: Expression, r: Expression) => (check(l, env), check(r, env)) match {
      case (NumberLiteral(_), NumberLiteral(_)) => defaultNumberValue
      case _ => sys.error(s"Invalid division expression at line ${e.pos}")
    }
    case e @ Variable(name: String) => env getOrElse(name, sys.error(s"Undefined variable $name at line ${e.pos}"))
    case BooleanLiteral(_) => defaultBooleanValue
    case NumberLiteral(_) => defaultNumberValue
    case StringLiteral(_) => defaultStringValue
  }

  def tryAddVariable(name: String, _type: Literal, env: Environment): Environment = {
    if (env contains name) {
      sys.error(s"Variable $name is already defined")
    } else {
      env + (name -> _type)
    }
  }
}
