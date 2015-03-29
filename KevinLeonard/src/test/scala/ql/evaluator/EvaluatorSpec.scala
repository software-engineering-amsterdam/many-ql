package ql.evaluator

import org.specs2.mutable.Specification
import ql.ast._
import types.{EvalEnvironment, VariableName}

import scalafx.collections.ObservableMap

class EvaluatorSpec extends Specification {
  val evaluators = new Evaluator

  val EmptyEnvironment: EvalEnvironment = ObservableMap.empty[VariableName, Value]
  val LiteralTrue: BooleanLiteral = BooleanLiteral(BooleanValue(true))
  val LiteralFalse: BooleanLiteral = BooleanLiteral(BooleanValue(false))
  val ValueTrue: BooleanValue = BooleanValue(true)
  val ValueFalse: BooleanValue = BooleanValue(false)

  "evaluation of boolean expressions" should {
    "return true if one side of an or expressions is true" in {
      val expression = Or(LiteralTrue, LiteralFalse)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if one side of an and expression is false" in {
      val expression = And(LiteralTrue, LiteralFalse)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return false if the input of a not expression is true" in {
      val expression = Not(LiteralTrue)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }
  }

  "evaluation of equality expressions" should {
    "return true if booleans are equal" in {
      val expression = Equal(LiteralTrue, LiteralTrue)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if booleans are not equal" in {
      val expression = Equal(LiteralTrue, LiteralFalse)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if numbers are equal" in {
      val expression = Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if numbers are not equal" in {
      val expression = Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if strings are equal" in {
      val expression = Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if strings are not equal" in {
      val expression = Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return false if booleans are equal" in {
      val expression = NotEqual(LiteralTrue, LiteralTrue)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if booleans are not equal" in {
      val expression = NotEqual(LiteralTrue, LiteralFalse)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if numbers are equal" in {
      val expression = NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if numbers are not equal" in {
      val expression = NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if strings are equal" in {
      val expression = NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if strings are not equal" in {
      val expression = NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }
  }

  "evaluation of relational expressions" should {
    "return true if the first number is less than the second number" in {
      val expression = LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if the first number is equal to the second number" in {
      val expression = LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return false if the first number is greater than the second number" in {
      val expression = LessThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if the first number is less than the second number" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return true if the first number is equal to the second number" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if the first number is greater than the second number" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if the first number is greater than the second number" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if the first number is equal to the second number" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return false if the first number is less than the second number" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }

    "return true if the first number is equal to the second number" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return true if the first number is greater than the second number" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return false if the first number is less than the second number" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueFalse)
    }
  }

  "evaluation of arithmetic expressions" should {
    "return the numbers added" in {
      val expression = Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))
      val result = NumberValue(3)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "return the numbers substracted" in {
      val expression = Sub(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))
      val result = NumberValue(1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "return the numbers multiplied" in {
      val expression = Mul(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(3)))
      val result = NumberValue(6)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "return the numbers divided" in {
      val expression = Div(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))
      val result = NumberValue(2)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "return the number negated" in {
      val expression = Negation(NumberLiteral(NumberValue(1)))
      val result = NumberValue(-1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "return the original number if it is negated twice" in {
      val anyNumberValue = NumberValue(1)
      val anyNumberLiteral = NumberLiteral(anyNumberValue)
      val expression = Negation(Negation(anyNumberLiteral))

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(anyNumberValue)
    }
  }

  "evaluation of variable expressions" should {
    "return the value retrieved from the enviroment" in {
      val expression = Variable("test")
      val environment = EmptyEnvironment += ("test" -> NumberValue(3))
      val result = NumberValue(3)

      evaluators.eval(expression, environment) must beEqualTo(result)
    }
  }

  "evaluation of literal expressions" should {
    "return the boolean value that is in the boolean literal" in {
      val expression = LiteralTrue

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }

    "return the number value that is in the number literal" in {
      val expression = NumberLiteral(NumberValue(1))
      val result = NumberValue(1)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "return the string value that is in the string literal" in {
      val expression = StringLiteral(StringValue("a"))
      val result = StringValue("a")

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }
  }

  "evaluation of complex expressions" should {
    "evaluate the nested expression first (to be able to follow mathematical precedence rules)" in {
      val expression = Mul(NumberLiteral(NumberValue(5)),
        Add(NumberLiteral(NumberValue(3)), NumberLiteral(NumberValue(2)))
      )
      val result = NumberValue(25)

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(result)
    }

    "evaluate the nested expression first" in {
      val expression = And(
        Equal(NumberLiteral(NumberValue(1)),
          Add(NumberLiteral(NumberValue(4)),
            Div(NumberLiteral(NumberValue(6)), Negation(NumberLiteral(NumberValue(2))))
          )
        ),
        Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))
      )

      evaluators.eval(expression, EmptyEnvironment) must beEqualTo(ValueTrue)
    }
  }
}
