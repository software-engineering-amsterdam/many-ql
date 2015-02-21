package typechecker

import ast._
import org.specs2.matcher.ExceptionMatchers
import org.specs2.mutable.Specification

class QLTypeCheckerSpec extends Specification with ExceptionMatchers {
  val checkers = new QLTypeChecker
  import checkers._

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      check(BooleanQuestion(Variable("X"), "label"), emptyEnvironment) must beEqualTo(Map("X" -> defaultBooleanValue))
    }

    "add variable + type to environment, if statement is number question" in {
      check(NumberQuestion(Variable("X"), "label"), emptyEnvironment) must beEqualTo(Map("X" -> defaultNumberValue))
    }

    "add variable + type to environment, if statement is string question" in {
      check(StringQuestion(Variable("X"), "label"), emptyEnvironment) must beEqualTo(Map("X" -> defaultStringValue))
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      check(ComputedBooleanQuestion(Variable("X"), "label", BooleanLiteral(true)), emptyEnvironment) must beEqualTo(Map("X" -> defaultBooleanValue))
    }

    "throw exception, if statement is computed boolean question with invalid expression" in {
      check(ComputedBooleanQuestion(Variable("X"), "label", NumberLiteral(1)), emptyEnvironment) must throwA[RuntimeException]
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      check(ComputedNumberQuestion(Variable("X"), "label", NumberLiteral(1)), emptyEnvironment) must beEqualTo(Map("X" -> defaultNumberValue))
    }

    "throw exception, if statement is computed number question with invalid expression" in {
      check(ComputedNumberQuestion(Variable("X"), "label", BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      check(ComputedStringQuestion(Variable("X"), "label", StringLiteral("")), emptyEnvironment) must beEqualTo(Map("X" -> defaultStringValue))
    }

    "throw exception, if statement is computed string question with invalid expression" in {
      check(ComputedStringQuestion(Variable("X"), "label", NumberLiteral(1)), emptyEnvironment) must throwA[RuntimeException]
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(BooleanLiteral(true), BooleanQuestion(Variable("X"), "label"), None), emptyEnvironment) must beEqualTo(emptyEnvironment)
    }

    "throw exception, if invalid boolean condition" in {
      check(IfStatement(NumberLiteral(0), BooleanQuestion(Variable("X"), "label"), None), emptyEnvironment) must throwA[RuntimeException]
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(BooleanLiteral(true), BooleanQuestion(Variable("X"), "label"), Some(BooleanQuestion(Variable("X"), "label"))), emptyEnvironment) must beEqualTo(emptyEnvironment)
    }

    "throw exception, if invalid boolean condition" in {
      check(IfStatement(NumberLiteral(0), BooleanQuestion(Variable("X"), "label"), Some(BooleanQuestion(Variable("X"), "label"))), emptyEnvironment) must throwA[RuntimeException]
    }

    "add variables + types to environment" in {
      check(Sequence(List(BooleanQuestion(Variable("X"), "label"), NumberQuestion(Variable("Y"), "label"), StringQuestion(Variable("Z"), "label"))), emptyEnvironment) must beEqualTo(Map("X" -> defaultBooleanValue, "Y" -> defaultNumberValue, "Z" -> defaultStringValue))
    }
    
    "add variable + type to environment " in {
      check(Form("Form1", BooleanQuestion(Variable("X"), "label")), emptyEnvironment) must beEqualTo(Map("X" -> defaultBooleanValue))
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      check(Not(And(Variable("X"), GreaterThan(NumberLiteral(2), NumberLiteral(1)))), Map("X" -> defaultBooleanValue)) must beEqualTo(defaultBooleanValue)
    }
  }

  "literals" should {
    "type check on booleans" in {
      check(BooleanLiteral(true), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on numbers" in {
      check(NumberLiteral(10), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }

    "type check on strings" in {
      check(StringLiteral("Test"), emptyEnvironment) must beEqualTo(defaultStringValue)
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      check(Or(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(Or(Or(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on other types" in {
      check(Or(StringLiteral("Test"), NumberLiteral(100)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      check(And(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(And(And(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on other types" in {
      check(And(StringLiteral("Test"), NumberLiteral(100)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      check(Not(BooleanLiteral(true)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on other types" in {
      check(Not(StringLiteral("")), emptyEnvironment)  must throwA[RuntimeException]
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      check(Equal(BooleanLiteral(true), BooleanLiteral(true)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on numbers" in {
      check(Equal(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on strings" in {
      check(Equal(StringLiteral(""), StringLiteral("")), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on two different types" in {
      check(Equal(StringLiteral(""), BooleanLiteral(true)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      check(NotEqual(BooleanLiteral(true), BooleanLiteral(true)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on numbers" in {
      check(NotEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "type check on strings" in {
      check(NotEqual(StringLiteral(""), StringLiteral("")), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on two different types" in {
      check(NotEqual(StringLiteral(""), BooleanLiteral(true)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      check(LessThan(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on strings" in {
      check(LessThan(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(LessThan(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      check(LessThanEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on strings" in {
      check(LessThanEqual(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(LessThanEqual(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      check(GreaterThan(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on strings" in {
      check(GreaterThan(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(GreaterThan(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      check(GreaterThanEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }

    "not type check on strings" in {
      check(GreaterThanEqual(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(GreaterThanEqual(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      check(Add(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }

    "type check on 2 + 2 + 2" in {
      check(Add(NumberLiteral(2), Add(NumberLiteral(2), NumberLiteral(2))), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }

    "not type check on strings" in {
      check(Add(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Add(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      check(Sub(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }

    "not type check on strings" in {
      check(Sub(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Sub(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      check(Mul(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }

    "not type check on strings" in {
      check(Mul(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Mul(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      check(Div(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }

    "not type check on strings" in {
      check(Div(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Div(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException]
    }
  }

  "variable expressions" should {
    "lookup integers" in {
      check(Variable("X"), Map("X" -> defaultNumberValue)) must beEqualTo(defaultNumberValue)
    }

    "lookup strings" in {
      check(Variable("X"), Map("X" -> defaultStringValue)) must beEqualTo(defaultStringValue)
    }

    "lookup booleans" in {
      check(Variable("X"), Map("X" -> defaultBooleanValue)) must beEqualTo(defaultBooleanValue)
    }

    "fail when variable is undefined" in {
      check(Variable("X"), Map("Y" -> defaultBooleanValue)) must throwA[RuntimeException]
    }
  }

  "type checker" should {
    "detect duplicate question declarations" in {
      check(BooleanQuestion(Variable("X"), "label"), Map("X" -> defaultBooleanValue)) must throwA[RuntimeException]
    }
  }
}
