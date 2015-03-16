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
      val question = Question(BooleanType(), Variable("X"), "label", Some(BooleanLiteral(BooleanValue(true))))
      val result = (EmptyErrorList, Map("X" -> BooleanType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed boolean question with invalid expression" in {
      val question = Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1))))
      val result = (List(new Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> BooleanType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      val question = Question(NumberType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1))))
      val result = (EmptyErrorList, Map("X" -> NumberType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed number question with invalid expression" in {
      val question = Question(NumberType(), Variable("X"), "label", Some(BooleanLiteral(BooleanValue(false))))
      val result = (List(new Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> NumberType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      val question = Question(StringType(), Variable("X"), "label", Some(StringLiteral(StringValue(""))))
      val result = (EmptyErrorList, Map("X" -> StringType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed string question with invalid expression" in {
      val question = Question(StringType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1))))
      val result = (List(new Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> StringType()))
      
      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return empty environment, if valid boolean condition" in {
      val ifBlock = IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), None)
      val result = (EmptyErrorList, EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if invalid boolean condition" in {
      val ifBlock = IfStatement(NumberLiteral(NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), None)
      val result = (List(new Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in if block" in {
      val ifBlock = IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), None)
      val result = (List(new Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return empty environment, if valid boolean condition (with else block)" in {
      val ifBlock = IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None))) 
      val result = (EmptyErrorList, EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if invalid boolean condition (with else block)" in {
      val ifBlock = IfStatement(NumberLiteral(NumberValue(0)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (List(new Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in if block (with else block)" in {
      val ifBlock = IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1)))), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (List(new Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
      
      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in else block" in {
      val ifBlock = IfStatement(BooleanLiteral(BooleanValue(true)), Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", Some(NumberLiteral(NumberValue(1))))))
      val result = (List(new Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)
      
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
      val expression = Not(And(Variable("X"), GreaterThan(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(1)))))
      val environment = Map("X" -> BooleanType())
      
      check(expression, environment) must beRight(Boolean)
    }
  }

  "literals" should {
    "type check on booleans" in {
      val literal = BooleanLiteral(BooleanValue(true)) 
      
      check(literal, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on numbers" in {
      val literal = NumberLiteral(NumberValue(10))
      
      check(literal, EmptyEnvironment) must beRight(Number)
    }

    "type check on strings" in {
      val literal = StringLiteral(StringValue("Test"))
      
      check(literal, EmptyEnvironment) must beRight(String)
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      val expression = Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = Or(Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on other types" in {
      val expression = Or(StringLiteral(StringValue("Test")), NumberLiteral(NumberValue(100)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      val expression = And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = And(And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(false))) 
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on other types" in {
      val expression = And(StringLiteral(StringValue("Test")), NumberLiteral(NumberValue(100)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      val expression = Not(BooleanLiteral(BooleanValue(true))) 
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on other types" in {
      val expression = Not(StringLiteral(StringValue("")))

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      val expression = Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on numbers" in {
      val expression = Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on strings" in {
      val expression = Equal(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on two different types" in {
      val expression = Equal(StringLiteral(StringValue("")), BooleanLiteral(BooleanValue(true)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      val expression = NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on numbers" in {
      val expression = NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "type check on strings" in {
      val expression = NotEqual(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on two different types" in {
      val expression = NotEqual(StringLiteral(StringValue("")), BooleanLiteral(BooleanValue(true)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      val expression = LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = LessThan(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThan(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      val expression = LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = LessThanEqual(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThanEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      val expression = GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))

      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = GreaterThan(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThan(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      val expression = GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Boolean)
    }

    "not type check on strings" in {
      val expression = GreaterThanEqual(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThanEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      val expression = Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "type check on 2 + 2 + 2" in {
      val expression = Add(NumberLiteral(NumberValue(2)), Add(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(2))))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Add(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Add(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      val expression = Sub(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Sub(StringLiteral(StringValue("")), StringLiteral(StringValue(""))) 
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Sub(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      val expression = Mul(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Mul(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Mul(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))
      
      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      val expression = Div(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(1)))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Div(StringLiteral(StringValue("")), StringLiteral(StringValue("")))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Div(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "negation expressions" should {
    "type check on -1" in {
      val expression = Negation(NumberLiteral(NumberValue()))
      
      check(expression, EmptyEnvironment) must beRight(Number)
    }

    "not type check on strings" in {
      val expression = Negation(StringLiteral(StringValue()))
      
      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Negation(BooleanLiteral(BooleanValue()))
      
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
      val errors = List(new Error("Variable X is already defined", Some(NoPosition)))

      check(question, environmentWithQuestion) must beEqualTo((errors, environmentWithQuestion))
    }
  }
}
