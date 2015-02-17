package typechecker

import ast.QLAST._
import org.specs2.matcher.ExceptionMatchers
import org.specs2.mutable.Specification

class QLTypeCheckerSpec extends Specification with ExceptionMatchers {
  val checkers = new QLTypeChecker
  import checkers._

//  "question property check" should {
//    "isDuplicateQuestionVariable true" in {
//      isDuplicateQuestionVariable(List(BooleanQuestion(Variable("Test"), "Label")), BooleanQuestion(Variable("Test"), "Label")) must beEqualTo(true)
//    }
//    "isDuplicateQuestionVariable false" in {
//      isDuplicateQuestionVariable(List(BooleanQuestion(Variable("Test"), "Label")), BooleanQuestion(Variable("Other"), "Label")) must beEqualTo(false)
//    }
//    "isDuplicateQuestionLabel true" in {
//      isDuplicateQuestionLabel(List(BooleanQuestion(Variable("Test"), "Label")), BooleanQuestion(Variable("Test"), "Label")) must beEqualTo(true)
//    }
//    "isDuplicateQuestionLabel false" in {
//      isDuplicateQuestionLabel(List(BooleanQuestion(Variable("Test"), "Label")), BooleanQuestion(Variable("Test"), "Other Label")) must beEqualTo(false)
//    }
//
//  }
  
  
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
    "BooleanLiteral" in {
      check(BooleanLiteral(true), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "NumberLiteral" in {
      check(NumberLiteral(10), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }
    "StringLiteral" in {
      check(StringLiteral("Test"), emptyEnvironment) must beEqualTo(defaultStringValue)
    }
  }

  "OR expressions" should {
    "be true (both boolean literals)" in {
      check(Or(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "be true (an expression and a boolean literal)" in {
      check(Or(Or(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "be false (an string literal and a number literal)" in {
      check(Or(StringLiteral("Test"), NumberLiteral(100)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid OR expression")
    }
  }

  "AND expressions" should {
    "be true (both boolean literals)" in {
      check(And(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "be true (an expression and a boolean literal)" in {
      check(And(And(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "be false (an string literal and a number literal)" in {
      check(And(StringLiteral("Test"), NumberLiteral(100)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid AND expression")
    }
  }

  "NOT expressions" should {
    "be true" in {
      check(Not(BooleanLiteral(true)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "be false" in {
      check(Not(StringLiteral("")), emptyEnvironment)  must throwA[RuntimeException](message = "Invalid NOT expression")
    }
  }

  "EQUAL expressions" should {
    "booleans be true" in {
      check(Equal(BooleanLiteral(true), BooleanLiteral(true)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "numbers be true" in {
      check(Equal(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "strings true" in {
      check(Equal(StringLiteral(""), StringLiteral("")), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "two different types be false" in {
      check(Equal(StringLiteral(""), BooleanLiteral(true)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid EQUAL expression")
    }
  }

  "NOT EQUAL expressions" should {
    "booleans be true" in {
      check(NotEqual(BooleanLiteral(true), BooleanLiteral(true)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "numbers be true" in {
      check(NotEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "strings be true" in {
      check(NotEqual(StringLiteral(""), StringLiteral("")), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "two different types be false" in {
      check(NotEqual(StringLiteral(""), BooleanLiteral(true)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid NOT EQUAL expression")
    }
  }

  "LESS THAN expressions" should {
    "numbers be true" in {
      check(LessThan(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "strings be false" in {
      check(LessThan(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid LESS THAN expression")
    }
    "booleans be false" in {
      check(LessThan(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid LESS THAN expression")
    }
  }

  "LESS THAN EQUAL expressions" should {
    "numbers be true" in {
      check(LessThanEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "strings be false" in {
      check(LessThanEqual(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid LESS THAN EQUAL expression")
    }
    "booleans be false" in {
      check(LessThanEqual(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid LESS THAN EQUAL expression")
    }
  }

  "GREATER THAN expressions" should {
    "numbers be true" in {
      check(GreaterThan(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "strings be false" in {
      check(GreaterThan(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid GREATER THAN expression")
    }
    "booleans be false" in {
      check(GreaterThan(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid GREATER THAN expression")
    }
  }

  "GREATER THAN EQUAL expressions" should {
    "numbers be true" in {
      check(GreaterThanEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultBooleanValue)
    }
    "strings be false" in {
      check(GreaterThanEqual(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid GREATER THAN EQUAL expression")
    }
    "booleans be false" in {
      check(GreaterThanEqual(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid GREATER THAN EQUAL expression")
    }
  }

  "ADD expressions" should {
    "2 + 2 + 2" in {
      check(Add(NumberLiteral(2), Add(NumberLiteral(2), NumberLiteral(2))), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }
    "1 + 1" in {
      check(Add(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }
    "strings be false" in {
      check(Add(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid ADD expression")
    }
    "booleans be false" in {
      check(Add(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid ADD expression")
    }
  }

  "SUB expressions" should {
    "1 - 1" in {
      check(Sub(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }
    "strings be false" in {
      check(Sub(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid SUB expression")
    }
    "booleans be false" in {
      check(Sub(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid SUB expression")
    }
  }

  "MUL expressions" should {
    "1 * 1" in {
      check(Mul(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }
    "strings be false" in {
      check(Mul(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid MUL expression")
    }
    "booleans be false" in {
      check(Mul(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid MUL expression")
    }
  }

  "DIV expressions" should {
    "1 / 1" in {
      check(Div(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(defaultNumberValue)
    }
    "strings be false" in {
      check(Div(StringLiteral(""), StringLiteral("")), emptyEnvironment) must throwA[RuntimeException](message = "Invalid DIV expression")
    }
    "booleans be false" in {
      check(Div(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must throwA[RuntimeException](message = "Invalid DIV expression")
    }
  }

  "VARIABLE expressions" should {
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
      check(Variable("X"), Map("Y" -> defaultBooleanValue)) must throwA[RuntimeException](message = "Undefined variable: X")
    }
  }
  
  
  
  
}