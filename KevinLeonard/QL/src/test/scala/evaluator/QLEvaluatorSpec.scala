package evaluator

import ast._
import org.specs2.mutable.Specification

class QLEvaluatorSpec extends Specification {
  val evaluators = new QLEvaluator

  import evaluators._

  "evaluation of statements" should {
    "add default value of boolean to environment when evaluating boolean question" in {
      eval(BooleanQuestion(Variable("a"), "label"), emptyEnvironment) must beEqualTo(Map("a" -> false))
    }

    "add default value of number to environment when evaluating number question" in {
      eval(NumberQuestion(Variable("a"), "label"), emptyEnvironment) must beEqualTo(Map("a" -> 0))
    }

    "add default value of string to environment when evaluating string question" in {
      eval(StringQuestion(Variable("a"), "label"), emptyEnvironment) must beEqualTo(Map("a" -> ""))
    }

    "add default value of boolean to environment when evaluating boolean question" in {
      eval(ComputedBooleanQuestion(Variable("a"), "label", BooleanLiteral(true)), emptyEnvironment) must beEqualTo(Map("a" -> true))
    }

    "add default value of number to environment when evaluating number question" in {
      eval(ComputedNumberQuestion(Variable("a"), "label", NumberLiteral(1)), emptyEnvironment) must beEqualTo(Map("a" -> 1))
    }

    "add default value of string to environment when evaluating string question" in {
      eval(ComputedStringQuestion(Variable("a"), "label", StringLiteral("b")), emptyEnvironment) must beEqualTo(Map("a" -> "b"))
    }

    "eval the statements in the if block, if the expression evaluates to true" in {
      eval(IfStatement(BooleanLiteral(true), BooleanQuestion(Variable("a"), "label"), None), emptyEnvironment) must beEqualTo(Map("a" -> false))
    }

    "eval no statements, if the expression evaluates to false" in {
      eval(IfStatement(BooleanLiteral(false), BooleanQuestion(Variable("a"), "label"), None), emptyEnvironment) must beEqualTo(emptyEnvironment)
    }

    "eval the statements in the if block, if the expression evaluates to true" in {
      eval(IfStatement(BooleanLiteral(true), BooleanQuestion(Variable("a"), "label"), Some(BooleanQuestion(Variable("b"), "label"))), emptyEnvironment) must beEqualTo(Map("a" -> false))
    }

    "eval the statements in the else block, if the expression evaluates to false" in {
      eval(IfStatement(BooleanLiteral(false), BooleanQuestion(Variable("a"), "label"), Some(BooleanQuestion(Variable("b"), "label"))), emptyEnvironment) must beEqualTo(Map("b" -> false))
    }

    "eval all the statements in a sequence" in {
      eval(Sequence(List(BooleanQuestion(Variable("a"), "label"), BooleanQuestion(Variable("b"), "label"), BooleanQuestion(Variable("c"), "label"))), emptyEnvironment) must beEqualTo(Map("a" -> false, "b" -> false, "c" -> false))
    }
  }

  "evaluation of expressions" should {
    "succeed for or expressions" in {
      eval(Or(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for and expressions" in {
      eval(And(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for not expressions" in {
      eval(Not(BooleanLiteral(true)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for equal expressions on booleans" in {
      eval(Equal(BooleanLiteral(true), BooleanLiteral(true)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for equal expressions on booleans" in {
      eval(Equal(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for equal expressions on numbers" in {
      eval(Equal(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for equal expressions on numbers" in {
      eval(Equal(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for equal expressions on strings" in {
      eval(Equal(StringLiteral("a"), StringLiteral("a")), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for equal expressions on strings" in {
      eval(Equal(StringLiteral("a"), StringLiteral("b")), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for notEqual expressions on booleans" in {
      eval(NotEqual(BooleanLiteral(true), BooleanLiteral(true)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for notEqual expressions on booleans" in {
      eval(NotEqual(BooleanLiteral(true), BooleanLiteral(false)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for notEqual expressions on numbers" in {
      eval(NotEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for notEqual expressions on numbers" in {
      eval(NotEqual(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for notEqual expressions on strings" in {
      eval(NotEqual(StringLiteral("a"), StringLiteral("a")), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for notEqual expressions on strings" in {
      eval(NotEqual(StringLiteral("a"), StringLiteral("b")), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(NumberLiteral(2), NumberLiteral(1)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(2), NumberLiteral(1)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(2), NumberLiteral(1)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(1), NumberLiteral(1)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(2), NumberLiteral(1)), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(false)
    }

    "succeed for add expressions" in {
      eval(Add(NumberLiteral(1), NumberLiteral(2)), emptyEnvironment) must beEqualTo(3)
    }

    "succeed for sub expressions" in {
      eval(Sub(NumberLiteral(2), NumberLiteral(1)), emptyEnvironment) must beEqualTo(1)
    }

    "succeed for mul expressions" in {
      eval(Mul(NumberLiteral(2), NumberLiteral(3)), emptyEnvironment) must beEqualTo(6)
    }

    "succeed for div expressions" in {
      eval(Div(NumberLiteral(2), NumberLiteral(1)), emptyEnvironment) must beEqualTo(2)
    }

    "succeed for variable expressions" in {
      eval(Variable("test"), Map("test" -> 3)) must beEqualTo(3)
    }

    "succeed for boolean literals" in {
      eval(BooleanLiteral(true), emptyEnvironment) must beEqualTo(true)
    }

    "succeed for number literals" in {
      eval(NumberLiteral(1), emptyEnvironment) must beEqualTo(1)
    }

    "succeed for string literals" in {
      eval(StringLiteral("a"), emptyEnvironment) must beEqualTo("a")
    }

    "succeed for nested expressions" in {
      eval(Mul(NumberLiteral(5), Add(NumberLiteral(3), NumberLiteral(2))), emptyEnvironment) must beEqualTo(25)
    }

    "succeed for multiple nested expressions" in {
      eval(And(Equal(NumberLiteral(7), Add(NumberLiteral(4), Div(NumberLiteral(6), NumberLiteral(2)))), Equal(StringLiteral("a"), StringLiteral("a"))), emptyEnvironment) must beEqualTo(true)
    }
  }

}
