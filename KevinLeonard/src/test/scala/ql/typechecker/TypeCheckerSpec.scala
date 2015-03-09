package ql.typechecker

import ql.ast._
import org.specs2.matcher.{MatchResult, Expectable, Matcher, ExceptionMatchers}
import org.specs2.mutable.Specification

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification with ExceptionMatchers {
  val checker = new TypeChecker
  import checker._

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      check(Question(BooleanType(), Variable("X"), "label", None), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType())))
    }

    "add variable + type to environment, if statement is number question" in {
      check(Question(NumberType(), Variable("X"), "label", None), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> NumberType())))
    }

    "add variable + type to environment, if statement is string question" in {
      check(Question(StringType(), Variable("X"), "label", None), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> StringType())))
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      check(Question(BooleanType(), Variable("X"), "label", Some(BooleanLiteral(BooleanValue(true)))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType())))
    }

    "throw exception, if statement is computed boolean question with invalid expression" in {
      check(Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), new TypeEnvironment()) must beLeft
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      check(Question(NumberType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> NumberType())))
    }

    "throw exception, if statement is computed number question with invalid expression" in {
      check(Question(NumberType(), Variable("X"), "label", Some(BooleanLiteral(BooleanValue(false)))), new TypeEnvironment()) must beLeft
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      check(Question(StringType(), Variable("X"), "label", Some(StringLiteral(StringValue("")))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> StringType())))
    }

    "throw exception, if statement is computed string question with invalid expression" in {
      check(Question(StringType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), new TypeEnvironment()) must beLeft
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), None), new TypeEnvironment()) must beRight(new TypeEnvironment())
    }

    "throw exception, if invalid boolean condition" in {
      check(IfStatement(NumberLiteral(NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), None), new TypeEnvironment()) must beLeft
    }

    "throw exception, if error in if block" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), None), new TypeEnvironment()) must beLeft
    }

    "return empty environment, if valid boolean condition (with else block)" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))), new TypeEnvironment()) must beRight(new TypeEnvironment())
    }

    "throw exception, if invalid boolean condition (with else block)" in {
      check(IfStatement(NumberLiteral(NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))), new TypeEnvironment()) must beLeft
    }

    "throw exception, if error in if block (with else block)" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), Some(Question(BooleanType(), Variable("X"), "label", None))), new TypeEnvironment()) must beLeft
    }

    "throw exception, if error in else block" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))))), new TypeEnvironment()) must beLeft
    }

    "add variable + type to environment " in {
      check(new Form("Form1", Question(BooleanType(), Variable("X"), "label", None)), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType())))
    }

    "add variables + types to environment" in {
      check(Sequence(List(Question(BooleanType(), Variable("X"), "label1", None), Question(NumberType(), Variable("Y"), "label2", None), Question(StringType(), Variable("Z"), "label3", None))), new TypeEnvironment()) must beRight(new TypeEnvironment(env = Map("X" -> BooleanType(), "Y" -> NumberType(), "Z" -> StringType())))
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      check(Not(And(Variable("X"), GreaterThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))))), new TypeEnvironment(env = Map("X" -> BooleanType()))) must beRight(BooleanType())
    }
  }

  "literals" should {
    "type check on booleans" in {
      check(BooleanLiteral(BooleanValue(true)), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(NumberLiteral(NumberValue(10)), new TypeEnvironment()) must beRight(NumberType())
    }

    "type check on strings" in {
      check(StringLiteral(StringValue("Test")), new TypeEnvironment()) must beRight(StringType())
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      check(Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(Or(Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(Or(StringLiteral(StringValue("Test")), NumberLiteral(NumberValue(100))), new TypeEnvironment()) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      check(And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(And(And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(And(StringLiteral(StringValue("Test")), NumberLiteral(NumberValue(100))), new TypeEnvironment()) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      check(Not(BooleanLiteral(BooleanValue(true))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(Not(StringLiteral(StringValue(""))), new TypeEnvironment())  must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      check(Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on strings" in {
      check(Equal(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      check(Equal(StringLiteral(StringValue("")), BooleanLiteral(BooleanValue(true))), new TypeEnvironment()) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      check(NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "type check on strings" in {
      check(NotEqual(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      check(NotEqual(StringLiteral(StringValue("")), BooleanLiteral(BooleanValue(true))), new TypeEnvironment()) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      check(LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(LessThan(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(LessThan(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      check(LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(LessThanEqual(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(LessThanEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      check(GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThan(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(GreaterThan(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      check(GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThanEqual(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(GreaterThanEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      check(Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "type check on 2 + 2 + 2" in {
      check(Add(NumberLiteral(NumberValue(2)), Add(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(2)))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Add(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Add(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      check(Sub(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Sub(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Sub(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      check(Mul(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Mul(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Mul(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      check(Div(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), new TypeEnvironment()) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Div(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), new TypeEnvironment()) must beLeft
    }

    "not type check on booleans" in {
      check(Div(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), new TypeEnvironment()) must beLeft
    }
  }

  "variable expressions" should {
    "lookup integers" in {
      check(Variable("X"), new TypeEnvironment(env = Map("X" -> NumberType()))) must beRight(NumberType())
    }

    "lookup strings" in {
      check(Variable("X"), new TypeEnvironment(env = Map("X" -> StringType()))) must beRight(StringType())
    }

    "lookup booleans" in {
      check(Variable("X"), new TypeEnvironment(env = Map("X" -> BooleanType()))) must beRight(BooleanType())
    }
  }

  "type checker" should {
    "detect duplicate question declarations" in {
      check(Question(BooleanType(), Variable("X"), "label", None), new TypeEnvironment(env = Map("X" -> BooleanType()))) must beLeft
    }
  }
}
