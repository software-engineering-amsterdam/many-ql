package ql.typechecker

import org.specs2.mutable.Specification
import ql.ast._
import types.TypeEnvironment

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification {
  val checker = new TypeChecker
  import checker._

  val EmptyEnvironment: TypeEnvironment = Map()

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      check(Question(BooleanType(), Variable("X"), "label", None), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> BooleanType())))
    }

    "add variable + type to environment, if statement is number question" in {
      check(Question(NumberType(), Variable("X"), "label", None), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> NumberType())))
    }

    "add variable + type to environment, if statement is string question" in {
      check(Question(StringType(), Variable("X"), "label", None), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> StringType())))
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      check(Question(BooleanType(), Variable("X"), "label", Some(BooleanLiteral(BooleanValue(true)))), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> BooleanType())))
    }

    "return error and add variable + type to environment, if statement is computed boolean question with invalid expression" in {
      check(Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), EmptyEnvironment) must beEqualTo((List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> BooleanType())))
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      check(Question(NumberType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> NumberType())))
    }

    "return error and add variable + type to environment, if statement is computed number question with invalid expression" in {
      check(Question(NumberType(), Variable("X"), "label", Some(BooleanLiteral(BooleanValue(false)))), EmptyEnvironment) must beEqualTo((List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> NumberType())))
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      check(Question(StringType(), Variable("X"), "label", Some(StringLiteral(StringValue("")))), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> StringType())))
    }

    "return error and add variable + type to environment, if statement is computed string question with invalid expression" in {
      check(Question(StringType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), EmptyEnvironment) must beEqualTo((List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> StringType())))
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), None), EmptyEnvironment) must beEqualTo((List[Error](), EmptyEnvironment))
    }

    "return error, if invalid boolean condition" in {
      check(IfStatement(NumberLiteral(NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), None), EmptyEnvironment) must beEqualTo((List(Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment))
    }

    "return error, if error in if block" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), None), EmptyEnvironment) must beEqualTo((List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment))
    }

    "return empty environment, if valid boolean condition (with else block)" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))), EmptyEnvironment) must beEqualTo((List[Error](), EmptyEnvironment))
    }

    "return error, if invalid boolean condition (with else block)" in {
      check(IfStatement(NumberLiteral(NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))), EmptyEnvironment) must beEqualTo((List(Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment))
    }

    "return error, if error in if block (with else block)" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), Some(Question(BooleanType(), Variable("X"), "label", None))), EmptyEnvironment) must beEqualTo(List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
    }

    "return error, if error in else block" in {
      check(IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))))), EmptyEnvironment) must beEqualTo(List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
    }

    "add variable + type to environment " in {
      check(Sequence(List(Question(BooleanType(), Variable("X"), "label", None))), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> BooleanType())))
    }

    "add variables + types to environment" in {
      check(Sequence(List(Question(BooleanType(), Variable("X"), "label1", None), Question(NumberType(), Variable("Y"), "label2", None), Question(StringType(), Variable("Z"), "label3", None))), EmptyEnvironment) must beEqualTo((List[Error](), Map("X" -> BooleanType(), "Y" -> NumberType(), "Z" -> StringType())))
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      val expression = Not(And(Variable("X"), GreaterThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))))
      val environmentWithQuestion = Map("X" -> BooleanType())
      check(expression, environmentWithQuestion) must beRight(BooleanType())
    }
  }

  "literals" should {
    "type check on booleans" in {
      check(BooleanLiteral(BooleanValue(true)), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(NumberLiteral(NumberValue(10)), EmptyEnvironment) must beRight(NumberType())
    }

    "type check on strings" in {
      check(StringLiteral(StringValue("Test")), EmptyEnvironment) must beRight(StringType())
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      check(Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(Or(Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(Or(StringLiteral(StringValue("Test")), NumberLiteral(NumberValue(100))), EmptyEnvironment) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      check(And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(And(And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(And(StringLiteral(StringValue("Test")), NumberLiteral(NumberValue(100))), EmptyEnvironment) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      check(Not(BooleanLiteral(BooleanValue(true))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      check(Not(StringLiteral(StringValue(""))), EmptyEnvironment)  must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      check(Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on strings" in {
      check(Equal(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      check(Equal(StringLiteral(StringValue("")), BooleanLiteral(BooleanValue(true))), EmptyEnvironment) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      check(NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      check(NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on strings" in {
      check(NotEqual(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      check(NotEqual(StringLiteral(StringValue("")), BooleanLiteral(BooleanValue(true))), EmptyEnvironment) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      check(LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(LessThan(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(LessThan(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      check(LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(LessThanEqual(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(LessThanEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      check(GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThan(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(GreaterThan(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      check(GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThanEqual(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(GreaterThanEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      check(Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(NumberType())
    }

    "type check on 2 + 2 + 2" in {
      check(Add(NumberLiteral(NumberValue(2)), Add(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(2)))), EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Add(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(Add(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      check(Sub(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Sub(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(Sub(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      check(Mul(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Mul(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(Mul(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      check(Div(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Div(StringLiteral(StringValue("")), StringLiteral(StringValue(""))), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(Div(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), EmptyEnvironment) must beLeft
    }
  }

  "negation expressions" should {
    "type check on -1" in {
      check(Negation(NumberLiteral(NumberValue())), EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      check(Negation(StringLiteral(StringValue())), EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      check(Negation(BooleanLiteral(BooleanValue())), EmptyEnvironment) must beLeft
    }
  }

  "variable expressions" should {
    "lookup booleans" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> BooleanType())

      check(variable, environmentWithQuestion) must beRight(BooleanType())
    }

    "lookup integers" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> NumberType())

      check(variable, environmentWithQuestion) must beRight(NumberType())
    }

    "lookup strings" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> StringType())

      check(variable, environmentWithQuestion) must beRight(StringType())
    }
  }

  "type checker" should {
    "detect duplicate question declarations" in {
      val question = Question(BooleanType(), Variable("X"), "label", None)
      val environmentWithQuestion = Map("X" -> BooleanType())
      val errors = List(Error("Variable X is already defined", Some(NoPosition)))

      check(question, environmentWithQuestion) must beEqualTo((errors, environmentWithQuestion))
    }
  }
}
