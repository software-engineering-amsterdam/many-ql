package ql.typechecker

import org.specs2.mutable.Specification
import ql.ast._
import types.{Label, TypeEnvironment, VariableName}

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification {
  val checker = new TypeChecker

  val EmptyEnvironment: TypeEnvironment = Map()
  val EmptyErrorList: List[Error] = List()
  val AnyBoolean: BooleanLiteral = BooleanLiteral(BooleanValue())
  val AnyNumber: NumberLiteral = NumberLiteral(NumberValue())
  val AnyString: StringLiteral = StringLiteral(StringValue())

  val AnyVariableName: VariableName = "X"
  val AnyLabel: Label = "label"

  "statement" should {
    "add variable + type to environment, if statement is boolean question" in {
      val question = Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None)
      val result = (EmptyErrorList, Map(AnyVariableName -> BooleanType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is number question" in {
      val question = Question(NumberType(), Variable(AnyVariableName), AnyLabel, None)
      val result = (EmptyErrorList, Map(AnyVariableName -> NumberType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is string question" in {
      val question = Question(StringType(), Variable(AnyVariableName), AnyLabel, None)
      val result = (EmptyErrorList, Map(AnyVariableName -> StringType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed boolean question with valid expression" in {
      val question = Question(BooleanType(), Variable(AnyVariableName), AnyLabel, Some(AnyBoolean))
      val result = (EmptyErrorList, Map(AnyVariableName -> BooleanType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed boolean question with invalid expression" in {
      val question = Question(BooleanType(), Variable(AnyVariableName), AnyLabel, Some(AnyNumber))
      val result = (List(Error("Invalid expression type for computed question: expected boolean, got number", Some(NoPosition))), Map(AnyVariableName -> BooleanType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      val question = Question(NumberType(), Variable(AnyVariableName), AnyLabel, Some(AnyNumber))
      val result = (EmptyErrorList, Map(AnyVariableName -> NumberType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed number question with invalid expression" in {
      val question = Question(NumberType(), Variable(AnyVariableName), AnyLabel, Some(AnyBoolean))
      val result = (List(Error("Invalid expression type for computed question: expected number, got boolean", Some(NoPosition))), Map(AnyVariableName -> NumberType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      val question = Question(StringType(), Variable(AnyVariableName), AnyLabel, Some(AnyString))
      val result = (EmptyErrorList, Map(AnyVariableName -> StringType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed string question with invalid expression" in {
      val question = Question(StringType(), Variable(AnyVariableName), AnyLabel, Some(AnyNumber))
      val result = (List(Error("Invalid expression type for computed question: expected string, got number", Some(NoPosition))), Map(AnyVariableName -> StringType()))

      checker.check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if valid boolean condition" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None), None)
      val result = (EmptyErrorList, Map(AnyVariableName -> BooleanType()))

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if invalid boolean condition" in {
      val ifBlock = IfStatement(AnyNumber, Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None), None)
      val result = (List(Error("Invalid boolean condition for if statement", Some(NoPosition))), Map(AnyVariableName -> BooleanType()))

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if error in if block" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable(AnyVariableName), AnyLabel, Some(AnyNumber)), None)
      val result = (List(Error("Invalid expression type for computed question: expected boolean, got number", Some(NoPosition))), Map(AnyVariableName -> BooleanType()))

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type only once to environment, if valid boolean condition (with else block)" in {
      val ifBlock = IfStatement(
        AnyBoolean,
        Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None),
        Some(Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None))
      )
      val result = (EmptyErrorList, Map(AnyVariableName -> BooleanType()))

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type only once to environment, if invalid boolean condition (with else block)" in {
      val ifBlock = IfStatement(
        AnyNumber,
        Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None),
        Some(Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None))
      )
      val result = (
        List(Error("Invalid boolean condition for if statement", Some(NoPosition))),
        Map(AnyVariableName -> BooleanType())
      )

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type only once to environment, if error in if block (with else block)" in {
      val ifBlock = IfStatement(
        AnyBoolean,
        Question(BooleanType(), Variable(AnyVariableName), AnyLabel, Some(AnyNumber)),
        Some(Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None))
      )
      val result = (
        List(Error("Invalid expression type for computed question: expected boolean, got number", Some(NoPosition))),
        Map(AnyVariableName -> BooleanType())
      )

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type only once to environment, if error in else block" in {
      val ifBlock = IfStatement(
        AnyBoolean,
        Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None),
        Some(Question(BooleanType(), Variable(AnyVariableName), AnyLabel, Some(AnyNumber)))
      )
      val result = (
        List(Error("Invalid expression type for computed question: expected boolean, got number", Some(NoPosition))),
        Map(AnyVariableName -> BooleanType())
      )

      checker.check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment " in {
      val sequence = Sequence(List(Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None)))
      val result = (EmptyErrorList, Map(AnyVariableName -> BooleanType()))

      checker.check(sequence, EmptyEnvironment) must beEqualTo(result)
    }

    "add variables + types to environment" in {
      val sequence = Sequence(List(
        Question(BooleanType(), Variable(AnyVariableName), "label1", None),
        Question(NumberType(), Variable("Y"), "label2", None),
        Question(StringType(), Variable("Z"), "label3", None)
      ))
      val result = (EmptyErrorList, Map(AnyVariableName -> BooleanType(), "Y" -> NumberType(), "Z" -> StringType()))

      checker.check(sequence, EmptyEnvironment) must beEqualTo(result)
    }
  }

  "expression" should {
    "type check multiple expressions" in {
      val expression = Not(And(Variable(AnyVariableName), GreaterThan(AnyNumber, AnyNumber)))
      val environment = Map(AnyVariableName -> BooleanType())

      checker.check(expression, environment) must beRight(BooleanType())
    }
  }

  "literals" should {
    "type check on booleans" in {
      val literal = AnyBoolean

      checker.check(literal, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      val literal = AnyNumber

      checker.check(literal, EmptyEnvironment) must beRight(NumberType())
    }

    "type check on strings" in {
      val literal = AnyString

      checker.check(literal, EmptyEnvironment) must beRight(StringType())
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      val expression = Or(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = Or(Or(AnyBoolean, AnyBoolean), AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      val expression = Or(AnyString, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      val expression = And(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = And(And(AnyBoolean, AnyBoolean), AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      val expression = And(AnyString, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      val expression = Not(AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      val expression = Not(AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      val expression = Equal(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      val expression = Equal(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on strings" in {
      val expression = Equal(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      val expression = Equal(AnyString, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      val expression = NotEqual(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      val expression = NotEqual(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on strings" in {
      val expression = NotEqual(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      val expression = NotEqual(AnyString, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      val expression = LessThan(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = LessThan(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThan(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      val expression = LessThanEqual(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = LessThanEqual(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThanEqual(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      val expression = GreaterThan(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = GreaterThan(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThan(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      val expression = GreaterThanEqual(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = GreaterThanEqual(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThanEqual(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      val expression = Add(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "type check on 2 + 2 + 2" in {
      val expression = Add(AnyNumber, Add(AnyNumber, AnyNumber))

      checker.check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Add(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Add(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      val expression = Sub(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Sub(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Sub(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      val expression = Mul(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Mul(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Mul(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      val expression = Div(AnyNumber, AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Div(AnyString, AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Div(AnyBoolean, AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "negation expressions" should {
    "type check on -1" in {
      val expression = Negation(AnyNumber)

      checker.check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Negation(AnyString)

      checker.check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Negation(AnyBoolean)

      checker.check(expression, EmptyEnvironment) must beLeft
    }
  }

  "variable expressions" should {
    "lookup booleans" in {
      val variable = Variable(AnyVariableName)
      val environmentWithQuestion = Map(AnyVariableName -> BooleanType())

      checker.check(variable, environmentWithQuestion) must beRight(BooleanType())
    }

    "lookup integers" in {
      val variable = Variable(AnyVariableName)
      val environmentWithQuestion = Map(AnyVariableName -> NumberType())

      checker.check(variable, environmentWithQuestion) must beRight(NumberType())
    }

    "lookup strings" in {
      val variable = Variable(AnyVariableName)
      val environmentWithQuestion = Map(AnyVariableName -> StringType())

      checker.check(variable, environmentWithQuestion) must beRight(StringType())
    }
  }

  "type checker" should {
    "allow duplicate question declarations with same types" in {
      val question = Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None)
      val environmentWithQuestion = Map(AnyVariableName -> BooleanType())

      checker.check(question, environmentWithQuestion) must beEqualTo((EmptyErrorList, environmentWithQuestion))
    }

    "detect duplicate question declarations with different types" in {
      val question = Question(BooleanType(), Variable(AnyVariableName), AnyLabel, None)
      val environmentWithQuestion = Map(AnyVariableName -> NumberType())
      val errors = List(Error("Variable X is already defined as a number", Some(NoPosition)))

      checker.check(question, environmentWithQuestion) must beEqualTo((errors, environmentWithQuestion))
    }
  }
}
