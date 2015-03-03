package evaluator

import ast._
import org.specs2.mutable.Specification

import scalafx.collections.ObservableMap

class EvaluatorSpec extends Specification {
  val evaluators = new Evaluator

  import evaluators._

  "evaluation of statements" should {
    "add default value of boolean to environment when evaluating boolean question" in {
      eval(Question(BooleanType(), Variable("a"), "label", None), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> BooleanValue()))
    }

    "add default value of number to environment when evaluating number question" in {
      eval(Question(NumberType(), Variable("a"), "label", None), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> NumberValue()))
    }

    "add default value of string to environment when evaluating string question" in {
      eval(Question(StringType(), Variable("a"), "label", None), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> StringValue()))
    }

    "add default value of boolean to environment when evaluating boolean question" in {
      eval(Question(BooleanType(), Variable("a"), "label", Some(Literal(BooleanType(), BooleanValue(true)))), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> BooleanValue(true)))
    }

    "add default value of number to environment when evaluating number question" in {
      eval(Question(NumberType(), Variable("a"), "label", Some(Literal(NumberType(), NumberValue(1)))), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> NumberValue(1)))
    }

    "add default value of string to environment when evaluating string question" in {
      eval(Question(StringType(), Variable("a"), "label", Some(Literal(StringType(), StringValue("b")))), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> StringValue("b")))
    }

    "eval all statements, if the expression evaluates to true" in {
      eval(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("a"), "label", None), None), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> BooleanValue(false)))
    }

    "eval all statements, if the expression evaluates to false" in {
      eval(IfStatement(Literal(BooleanType(), BooleanValue(false)), Question(BooleanType(), Variable("a"), "label", None), None), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("a" -> BooleanValue(false)))
    }

    "eval all statements, if the expression evaluates to true" in {
      eval(IfStatement(Literal(BooleanType(), BooleanValue(true)), Question(BooleanType(), Variable("a"), "label", None), Some(Question(BooleanType(), Variable("b"), "label", None))), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("b" -> BooleanValue(false), "a" -> BooleanValue(false)))
    }

    "eval all statements, if the expression evaluates to false" in {
      eval(IfStatement(Literal(BooleanType(), BooleanValue(false)), Question(BooleanType(), Variable("a"), "label", None), Some(Question(BooleanType(), Variable("b"), "label", None))), ObservableMap.empty[VariableName, Value]) must beEqualTo(Map("b" -> BooleanValue(false), "a" -> BooleanValue(false)))
    }

    "eval all the statements in a sequence" in {
      eval(Sequence(List(Question(BooleanType(), Variable("a"), "label", None), Question(BooleanType(), Variable("b"), "label", None), Question(BooleanType(), Variable("c"), "label", None))), ObservableMap.empty[VariableName, Value]) must beEqualTo(ObservableMap.empty[VariableName, Value] += ("a" -> BooleanValue(false), "b" -> BooleanValue(false), "c" -> BooleanValue(false)))
    }
  }

  "evaluation of expressions" should {
    "succeed for or expressions" in {
      eval(Or(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for and expressions" in {
      eval(And(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for not expressions" in {
      eval(Not(Literal(BooleanType(), BooleanValue(true))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for equal expressions on booleans" in {
      eval(Equal(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for equal expressions on booleans" in {
      eval(Equal(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for equal expressions on numbers" in {
      eval(Equal(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for equal expressions on numbers" in {
      eval(Equal(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for equal expressions on strings" in {
      eval(Equal(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("a"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for equal expressions on strings" in {
      eval(Equal(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("b"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on booleans" in {
      eval(NotEqual(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on booleans" in {
      eval(NotEqual(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for notEqual expressions on numbers" in {
      eval(NotEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on numbers" in {
      eval(NotEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for notEqual expressions on strings" in {
      eval(NotEqual(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("a"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for notEqual expressions on strings" in {
      eval(NotEqual(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("b"))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for lessThan expressions" in {
      eval(LessThan(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for lessThanEqual expressions" in {
      eval(LessThanEqual(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for greaterThan expressions" in {
      eval(GreaterThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for greaterThanEqual expressions" in {
      eval(GreaterThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(false))
    }

    "succeed for add expressions" in {
      eval(Add(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(3))
    }

    "succeed for sub expressions" in {
      eval(Sub(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(1))
    }

    "succeed for mul expressions" in {
      eval(Mul(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(3))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(6))
    }

    "succeed for div expressions" in {
      eval(Div(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(1))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(2))
    }

    "succeed for variable expressions" in {
      eval(Variable("test"), ObservableMap.empty[VariableName, Value] += ("test" -> NumberValue(3))) must beEqualTo(NumberValue(3))
    }

    "succeed for boolean literals" in {
      eval(Literal(BooleanType(), BooleanValue(true)), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }

    "succeed for number literals" in {
      eval(Literal(NumberType(), NumberValue(1)), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(1))
    }

    "succeed for string literals" in {
      eval(Literal(StringType(), StringValue("a")), ObservableMap.empty[VariableName, Value]) must beEqualTo(StringValue("a"))
    }

    "succeed for nested expressions" in {
      eval(Mul(Literal(NumberType(), NumberValue(5)), Add(Literal(NumberType(), NumberValue(3)), Literal(NumberType(), NumberValue(2)))), ObservableMap.empty[VariableName, Value]) must beEqualTo(NumberValue(25))
    }

    "succeed for multiple nested expressions" in {
      eval(And(Equal(Literal(NumberType(), NumberValue(7)), Add(Literal(NumberType(), NumberValue(4)), Div(Literal(NumberType(), NumberValue(6)), Literal(NumberType(), NumberValue(2))))), Equal(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("a")))), ObservableMap.empty[VariableName, Value]) must beEqualTo(BooleanValue(true))
    }
  }

}
