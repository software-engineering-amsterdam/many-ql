package ql.typechecker

import org.specs2.mutable.Specification
import ql.ast._
import types.TypeEnvironment

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification {
  val checker = new TypeChecker
  import checker._

  val EmptyEnvironment: TypeEnvironment = Map()
  val EmptyErrorList: List[Error] = List()
  
  val Boolean: BooleanType = BooleanType()
  val Number: NumberType = NumberType()
  val String: StringType = StringType()

  val DefaultBooleanValue: BooleanValue = BooleanValue()
  val DefaultNumberValue: NumberValue = DefaultNumberValue
  val DefaultStringValue: StringValue = DefaultStringValue

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      val question = Question(BooleanType(), Variable("X"), "label", None)
      val result = (EmptyErrorList, Map("X" -> BooleanType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is number question" in {
      val question = Question(NumberType(), Variable("X"), "label", None)
      val result = (EmptyErrorList, Map("X" -> NumberType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is string question" in {
      val question = Question(StringType(), Variable("X"), "label", None)
      val result = (EmptyErrorList, Map("X" -> StringType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      val question = Question(BooleanType(), Variable("X"), "label", Some(BooleanLiteral(DefaultBooleanValue)))
      val result = (EmptyErrorList, Map("X" -> BooleanType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed boolean question with invalid expression" in {
      val question = Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(DefaultNumberValue)))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> BooleanType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      val question = Question(NumberType(), Variable("X"), "label", Some(NumberLiteral(DefaultNumberValue)))
      val result = (EmptyErrorList, Map("X" -> NumberType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed number question with invalid expression" in {
      val question = Question(NumberType(), Variable("X"), "label", Some(BooleanLiteral(DefaultBooleanValue)))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> NumberType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      val question = Question(StringType(), Variable("X"), "label", Some(StringLiteral(DefaultStringValue)))
      val result = (EmptyErrorList, Map("X" -> StringType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed string question with invalid expression" in {
      val question = Question(StringType(), Variable("X"), "label", Some(NumberLiteral(DefaultNumberValue)))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> StringType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return empty environment, if valid boolean condition" in {
      val ifBlock = IfStatement(BooleanLiteral(DefaultBooleanValue), Question(BooleanType(), Variable("X"), "label", None), None)
      val result = (EmptyErrorList, EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if invalid boolean condition" in {
      val ifBlock = IfStatement(NumberLiteral(DefaultNumberValue), Question(BooleanType(), Variable("X"), "label", None), None)
      val result = (List(Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in if block" in {
      val ifBlock = IfStatement(BooleanLiteral(DefaultBooleanValue), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(DefaultNumberValue))), None)
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return empty environment, if valid boolean condition (with else block)" in {
      val ifBlock = IfStatement(BooleanLiteral(DefaultBooleanValue), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))) 
      val result = (EmptyErrorList, EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if invalid boolean condition (with else block)" in {
      val ifBlock = IfStatement(NumberLiteral(DefaultNumberValue), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (List(Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in if block (with else block)" in {
      val ifBlock = IfStatement(BooleanLiteral(DefaultBooleanValue), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(DefaultNumberValue))), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in else block" in {
      val ifBlock = IfStatement(BooleanLiteral(DefaultBooleanValue), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(DefaultNumberValue)))))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment " in {
      val sequence = Sequence(List(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (EmptyErrorList, Map("X" -> BooleanType()))
      
      check(sequence, EmptyEnvironment) must beEqualTo(result)
    }

    "add variables + types to environment" in {
      val sequence = Sequence(List(Question(BooleanType(), Variable("X"), "label1", None), Question(NumberType(), Variable("Y"), "label2", None), Question(StringType(), Variable("Z"), "label3", None)))
      val result = (EmptyErrorList, Map("X" -> BooleanType(), "Y" -> NumberType(), "Z" -> StringType()))
      
      check(sequence, EmptyEnvironment) must beEqualTo(result)
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      val expression = Not(And(Variable("X"), GreaterThan(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))))
      val environment = Map("X" -> BooleanType())
      
      check(expression, environment) must beRight(Boolean)
    }
  }

  "literals" should {
    "type check on booleans" in {
      val literal = BooleanLiteral(DefaultBooleanValue) 
      
      check(literal, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on numbers" in {
      val literal = NumberLiteral(DefaultNumberValue)
      
      check(literal, EmptyEnvironment) must beRight(Number)
    }

    "type check on strings" in {
      val literal = StringLiteral(StringValue("Test"))
      
      check(literal, EmptyEnvironment) must beRight(String)
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      val expression = Or(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = Or(Or(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue)), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on other types" in {
      val expression = Or(StringLiteral(StringValue("Test")), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      val expression = And(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = And(And(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue)), BooleanLiteral(DefaultBooleanValue)) 
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on other types" in {
      val expression = And(StringLiteral(StringValue("Test")), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      val expression = Not(BooleanLiteral(DefaultBooleanValue)) 
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on other types" in {
      val expression = Not(StringLiteral(DefaultStringValue))

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      val expression = Equal(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on numbers" in {
      val expression = Equal(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on strings" in {
      val expression = Equal(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on two different types" in {
      val expression = Equal(StringLiteral(DefaultStringValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      val expression = NotEqual(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on numbers" in {
      val expression = NotEqual(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on strings" in {
      val expression = NotEqual(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on two different types" in {
      val expression = NotEqual(StringLiteral(DefaultStringValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      val expression = LessThan(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = LessThan(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThan(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      val expression = LessThanEqual(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = LessThanEqual(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThanEqual(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      val expression = GreaterThan(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))

      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = GreaterThan(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThan(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      val expression = GreaterThanEqual(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = GreaterThanEqual(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThanEqual(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      val expression = Add(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "type check on 2 + 2 + 2" in {
      val expression = Add(NumberLiteral(DefaultNumberValue), Add(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue)))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Add(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Add(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      val expression = Sub(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Sub(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue)) 
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Sub(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      val expression = Mul(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Mul(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Mul(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      val expression = Div(NumberLiteral(DefaultNumberValue), NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Div(StringLiteral(DefaultStringValue), StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Div(BooleanLiteral(DefaultBooleanValue), BooleanLiteral(DefaultBooleanValue))

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "negation expressions" should {
    "type check on -1" in {
      val expression = Negation(NumberLiteral(DefaultNumberValue))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Negation(StringLiteral(DefaultStringValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Negation(BooleanLiteral(DefaultBooleanValue))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "variable expressions" should {
    "lookup booleans" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> BooleanType())

      check(variable, environmentWithQuestion) must beRight(Boolean)
    }

    "lookup integers" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> NumberType())

      check(variable, environmentWithQuestion) must beRight(Number)
    }

    "lookup strings" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> StringType())

      check(variable, environmentWithQuestion) must beRight(String)
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
