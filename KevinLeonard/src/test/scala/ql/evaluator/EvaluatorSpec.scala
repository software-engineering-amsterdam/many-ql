package ql.evaluator

import org.specs2.mutable.Specification
import ql.ast._
import types.VariableName

import scalafx.collections.ObservableMap

class EvaluatorSpec extends Specification {
  val evaluators = new Evaluator

  import evaluators._

  "evaluation of expressions" should {
    "succeed for or expressions" in {
      eval(Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for and expressions" in {
      eval(And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for not expressions" in {
      eval(Not(BooleanLiteral(BooleanValue(true))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for equal expressions on booleans" in {
      eval(Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for equal expressions on booleans" in {
      eval(Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for equal expressions on numbers" in {
      eval(Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for equal expressions on numbers" in {
      eval(Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for equal expressions on strings" in {
      eval(Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("a"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for equal expressions on strings" in {
      eval(Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("b"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on booleans" in {
      eval(NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on booleans" in {
      eval(NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for notEqual expressions on numbers" in {
      eval(NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on numbers" in {
      eval(NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for notEqual expressions on strings" in {
      eval(NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("a"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on strings" in {
      eval(NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("b"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for add expressions" in {
      eval(Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(3))
    }

    "succeed for sub expressions" in {
      eval(Sub(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(1))
    }

    "succeed for mul expressions" in {
      eval(Mul(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(3))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(6))
    }

    "succeed for div expressions" in {
      eval(Div(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(2))
    }

    "succeed for negation expressions" in {
      eval(Negation(NumberLiteral(NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(-1))
    }

    "succeed for nested negation expressions" in {
      eval(Negation(Negation(NumberLiteral(NumberValue(1)))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(1))
    }

    "succeed for variable expressions" in {
      eval(Variable("test"), ObservableMap.empty[VariableName, Value] += ("test" -> NumberValue(3))) must beEqualTo(NumberValue(3))
    }

    "succeed for boolean literals" in {
      eval(BooleanLiteral(BooleanValue(true)), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for number literals" in {
      eval(NumberLiteral(NumberValue(1)), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(1))
    }

    "succeed for string literals" in {
      eval(StringLiteral(StringValue("a")), ObservableMap.empty[VariableName, Value]) must beEqualTo(StringValue("a"))
    }

    "succeed for nested expressions" in {
      eval(Mul(NumberLiteral(NumberValue(5)), Add(NumberLiteral(NumberValue(3)), NumberLiteral(NumberValue(2)))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(25))
    }

    "succeed for multiple nested expressions" in {
      eval(And(Equal(NumberLiteral(NumberValue(1)), Add(NumberLiteral(NumberValue(4)), Div(NumberLiteral(NumberValue(6)), Negation(NumberLiteral(NumberValue(2)))))), Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("a")))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }
  }

}
