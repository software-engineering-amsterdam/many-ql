package ql.evaluator

import org.specs2.mutable.Specification
import ql.ast._
import types.{EvalEnvironment, VariableName}


import scalafx.collections.ObservableMap

class EvaluatorSpec extends Specification {
  val evaluators = new Evaluator

  val EmptyEnvironment: EvalEnvironment = ObservableMap.empty[VariableName, Value]
  val False: BooleanValue = BooleanValue(false)
  val True: BooleanValue = BooleanValue(true)

  "evaluation of expressions" should {
    "succeed for or expressions" in {
      val expression = Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for and expressions" in {
      val expression = And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for not expressions" in {
      val expression = Not(BooleanLiteral(BooleanValue(true)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for equal expressions on booleans" in {
      val expression = Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for equal expressions on booleans" in {
      val expression = Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for equal expressions on numbers" in {
      val expression = Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for equal expressions on numbers" in {
      val expression = Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for equal expressions on strings" in {
      val expression = Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for equal expressions on strings" in {
      val expression = Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for notEqual expressions on booleans" in {
      val expression = NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for notEqual expressions on booleans" in {
      val expression = NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for notEqual expressions on numbers" in {
      val expression = NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for notEqual expressions on numbers" in {
      val expression = NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for notEqual expressions on strings" in {
      val expression = NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for notEqual expressions on strings" in {
      val expression = NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for lessThan expressions (1 < 2)" in {
      val expression = LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for lessThan expressions (1 < 1)" in {
      val expression = LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for lessThan expressions (2 < 1)" in {
      val expression = LessThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for lessThanEqual expressions" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for lessThanEqual expressions" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for lessThanEqual expressions" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for greaterThan expressions" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for greaterThan expressions" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for greaterThan expressions" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for greaterThanEqual expressions" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for greaterThanEqual expressions" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for greaterThanEqual expressions" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(False)
    }

    "succeed for add expressions" in {
      val expression = Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))
      val result = NumberValue(3)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for sub expressions" in {
      val expression = Sub(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))
      val result = NumberValue(1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for mul expressions" in {
      val expression = Mul(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(3)))
      val result = NumberValue(6)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for div expressions" in {
      val expression = Div(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))
      val result = NumberValue(2)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for negation expressions" in {
      val expression = Negation(NumberLiteral(NumberValue(1)))
      val result = NumberValue(-1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for nested negation expressions" in {
      val expression = Negation(Negation(NumberLiteral(NumberValue(1))))
      val result = NumberValue(1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for variable expressions" in {
      val expression = Variable("test")
      val environment = EmptyEnvironment += ("test" -> NumberValue(3))
      val result = NumberValue(3)

      evaluators.eval(expression, environment) must beEqualTo(result)
    }

    "succeed for boolean literals" in {
      val expression = BooleanLiteral(BooleanValue(true))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }

    "succeed for number literals" in {
      val expression = NumberLiteral(NumberValue(1))
      val result = NumberValue(1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for string literals" in {
      val expression = StringLiteral(StringValue("a"))
      val result = StringValue("a")

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for nested expressions" in {
      val expression = Mul(NumberLiteral(NumberValue(5)), Add(NumberLiteral(NumberValue(3)), NumberLiteral(NumberValue(2))))
      val result = NumberValue(25)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "succeed for multiple nested expressions" in {
      val expression = And(
        Equal(NumberLiteral(NumberValue(1)), Add(NumberLiteral(NumberValue(4)), Div(NumberLiteral(NumberValue(6)), Negation(NumberLiteral(NumberValue(2)))))),
        Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))
      )

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(True)
    }
  }

}
