package typechecker

import ast._
import org.specs2.matcher.ExceptionMatchers
import org.specs2.mutable.Specification

class QLTypeCheckerSpec extends Specification with ExceptionMatchers {
  val checkers = new QLTypeChecker
  import checkers._

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      check(BooleanQuestion(Variable("X"), "label", None), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> BooleanType()), labels = List("label")))
    }

    "add variable + type to environment, if statement is number question" in {
      check(NumberQuestion(Variable("X"), "label", None), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> NumberType()), labels = List("label")))
    }

    "add variable + type to environment, if statement is string question" in {
      check(StringQuestion(Variable("X"), "label", None), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> StringType()), labels = List("label")))
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      check(BooleanQuestion(Variable("X"), "label", Some(BooleanLiteral(true))), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> BooleanType()), labels = List("label")))
    }

    "throw exception, if statement is computed boolean question with invalid expression" in {
      check(BooleanQuestion(Variable("X"), "label", Some(NumberLiteral(1))), new Environment()) must throwA[RuntimeException]
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      check(NumberQuestion(Variable("X"), "label", Some(NumberLiteral(1))), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> NumberType()), labels = List("label")))
    }

    "throw exception, if statement is computed number question with invalid expression" in {
      check(NumberQuestion(Variable("X"), "label", Some(BooleanLiteral(false))), new Environment()) must throwA[RuntimeException]
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      check(StringQuestion(Variable("X"), "label", Some(StringLiteral(""))), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> StringType()), labels = List("label")))
    }

    "throw exception, if statement is computed string question with invalid expression" in {
      check(StringQuestion(Variable("X"), "label", Some(NumberLiteral(1))), new Environment()) must throwA[RuntimeException]
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(BooleanLiteral(true), BooleanQuestion(Variable("X"), "label", None), None), new Environment()) must beEqualTo(new Environment())
    }

    "throw exception, if invalid boolean condition" in {
      check(IfStatement(NumberLiteral(0), BooleanQuestion(Variable("X"), "label", None), None), new Environment()) must throwA[RuntimeException]
    }

    "return empty environment, if valid boolean condition" in {
      check(IfStatement(BooleanLiteral(true), BooleanQuestion(Variable("X"), "label", None), Some(BooleanQuestion(Variable("X"), "label", None))), new Environment()) must beEqualTo(new Environment())
    }

    "throw exception, if invalid boolean condition" in {
      check(IfStatement(NumberLiteral(0), BooleanQuestion(Variable("X"), "label", None), Some(BooleanQuestion(Variable("X"), "label", None))), new Environment()) must throwA[RuntimeException]
    }

    "add variables + types to environment" in {
      check(Sequence(List(BooleanQuestion(Variable("X"), "label1", None), NumberQuestion(Variable("Y"), "label2", None), StringQuestion(Variable("Z"), "label3", None))), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> BooleanType(), "Y" -> NumberType(), "Z" -> StringType()), labels = List("label1", "label2", "label3")))
    }
    
    "add variable + type to environment " in {
      check(Form("Form1", BooleanQuestion(Variable("X"), "label", None)), new Environment()) must beEqualTo(new Environment(typeOfFields = Map("X" -> BooleanType()), labels = List("label")))
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      check(Not(And(Variable("X"), GreaterThan(NumberLiteral(2), NumberLiteral(1)))), new Environment(typeOfFields = Map("X" -> BooleanType()))) must beEqualTo(BooleanType())
    }
  }

  "literals" should {
    "type check on booleans" in {
      check(BooleanLiteral(true), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on numbers" in {
      check(NumberLiteral(10), new Environment()) must beEqualTo(NumberType())
    }

    "type check on strings" in {
      check(StringLiteral("Test"), new Environment()) must beEqualTo(StringType())
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      check(Or(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(Or(Or(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on other types" in {
      check(Or(StringLiteral("Test"), NumberLiteral(100)), new Environment()) must throwA[RuntimeException]
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      check(And(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      check(And(And(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on other types" in {
      check(And(StringLiteral("Test"), NumberLiteral(100)), new Environment()) must throwA[RuntimeException]
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      check(Not(BooleanLiteral(true)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on other types" in {
      check(Not(StringLiteral("")), new Environment())  must throwA[RuntimeException]
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      check(Equal(BooleanLiteral(true), BooleanLiteral(true)), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on numbers" in {
      check(Equal(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on strings" in {
      check(Equal(StringLiteral(""), StringLiteral("")), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on two different types" in {
      check(Equal(StringLiteral(""), BooleanLiteral(true)), new Environment()) must throwA[RuntimeException]
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      check(NotEqual(BooleanLiteral(true), BooleanLiteral(true)), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on numbers" in {
      check(NotEqual(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(BooleanType())
    }

    "type check on strings" in {
      check(NotEqual(StringLiteral(""), StringLiteral("")), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on two different types" in {
      check(NotEqual(StringLiteral(""), BooleanLiteral(true)), new Environment()) must throwA[RuntimeException]
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      check(LessThan(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on strings" in {
      check(LessThan(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(LessThan(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      check(LessThanEqual(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on strings" in {
      check(LessThanEqual(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(LessThanEqual(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      check(GreaterThan(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThan(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(GreaterThan(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      check(GreaterThanEqual(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(BooleanType())
    }

    "not type check on strings" in {
      check(GreaterThanEqual(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(GreaterThanEqual(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      check(Add(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(NumberType())
    }

    "type check on 2 + 2 + 2" in {
      check(Add(NumberLiteral(2), Add(NumberLiteral(2), NumberLiteral(2))), new Environment()) must beEqualTo(NumberType())
    }

    "not type check on strings" in {
      check(Add(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Add(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      check(Sub(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(NumberType())
    }

    "not type check on strings" in {
      check(Sub(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Sub(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      check(Mul(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(NumberType())
    }

    "not type check on strings" in {
      check(Mul(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Mul(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      check(Div(NumberLiteral(1), NumberLiteral(1)), new Environment()) must beEqualTo(NumberType())
    }

    "not type check on strings" in {
      check(Div(StringLiteral(""), StringLiteral("")), new Environment()) must throwA[RuntimeException]
    }

    "not type check on booleans" in {
      check(Div(BooleanLiteral(true), BooleanLiteral(false)), new Environment()) must throwA[RuntimeException]
    }
  }

  "variable expressions" should {
    "lookup integers" in {
      check(Variable("X"), new Environment(typeOfFields = Map("X" -> NumberType()))) must beEqualTo(NumberType())
    }

    "lookup strings" in {
      check(Variable("X"), new Environment(typeOfFields = Map("X" -> StringType()))) must beEqualTo(StringType())
    }

    "lookup booleans" in {
      check(Variable("X"), new Environment(typeOfFields = Map("X" -> BooleanType()))) must beEqualTo(BooleanType())
    }

    "fail when variable is undefined" in {
      check(Variable("X"), new Environment(typeOfFields = Map("Y" -> BooleanType()))) must throwA[RuntimeException]
    }
  }

  "type checker" should {
    "detect duplicate question declarations" in {
      check(BooleanQuestion(Variable("X"), "label", None), new Environment(typeOfFields = Map("X" -> BooleanType()))) must throwA[RuntimeException]
    }
    
    "detect duplicate label" in {
      check(BooleanQuestion(Variable("X"), "label", None), new Environment(labels = List("label"))) must throwA[RuntimeException]
    }
  }
}
