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
  val AnyBoolean: BooleanLiteral = BooleanLiteral(BooleanValue())
  val AnyNumber: NumberLiteral = NumberLiteral(NumberValue())
  val AnyString: StringLiteral = StringLiteral(StringValue())

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
      val question = Question(BooleanType(), Variable("X"), "label", Some(AnyBoolean))
      val result = (EmptyErrorList, Map("X" -> BooleanType()))

      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed boolean question with invalid expression" in {
      val question = Question(BooleanType(), Variable("X"), "label", Some(AnyNumber))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> BooleanType()))

      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed number question with valid expression" in {
      val question = Question(NumberType(), Variable("X"), "label", Some(AnyNumber))
      val result = (EmptyErrorList, Map("X" -> NumberType()))

      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed number question with invalid expression" in {
      val question = Question(NumberType(), Variable("X"), "label", Some(AnyBoolean))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> NumberType()))

      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "add variable + type to environment, if statement is computed string question with valid expression" in {
      val question = Question(StringType(), Variable("X"), "label", Some(AnyString))
      val result = (EmptyErrorList, Map("X" -> StringType()))

      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return error and add variable + type to environment, if statement is computed string question with invalid expression" in {
      val question = Question(StringType(), Variable("X"), "label", Some(AnyNumber))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), Map("X" -> StringType()))

      check(question, EmptyEnvironment) must beEqualTo(result)
    }

    "return empty environment, if valid boolean condition" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable("X"), "label", None), None)
      val result = (EmptyErrorList, EmptyEnvironment)

      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if invalid boolean condition" in {
      val ifBlock = IfStatement(AnyNumber, Question(BooleanType(), Variable("X"), "label", None), None)
      val result = (List(Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment)

      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in if block" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable("X"), "label", Some(AnyNumber)), None)
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)

      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return empty environment, if valid boolean condition (with else block)" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (EmptyErrorList, EmptyEnvironment)

      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if invalid boolean condition (with else block)" in {
      val ifBlock = IfStatement(AnyNumber, Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (List(Error("Invalid boolean condition for if statement", Some(NoPosition))), EmptyEnvironment)

      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in if block (with else block)" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable("X"), "label", Some(AnyNumber)), Some(Question(BooleanType(), Variable("X"), "label", None)))
      val result = (List(Error("Invalid expression type for computed question", Some(NoPosition))), EmptyEnvironment)

      check(ifBlock, EmptyEnvironment) must beEqualTo(result)
    }

    "return error, if error in else block" in {
      val ifBlock = IfStatement(AnyBoolean, Question(BooleanType(), Variable("X"), "label", None), Some(Question(BooleanType(), Variable("X"), "label", Some(AnyNumber))))
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
      val expression = Not(And(Variable("X"), GreaterThan(AnyNumber, AnyNumber)))
      val environment = Map("X" -> BooleanType())

      check(expression, environment) must beRight(BooleanType())
    }
  }

  "literals" should {
    "type check on booleans" in {
      val literal = AnyBoolean

      check(literal, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      val literal = AnyNumber

      check(literal, EmptyEnvironment) must beRight(NumberType())
    }

    "type check on strings" in {
      val literal = AnyString

      check(literal, EmptyEnvironment) must beRight(StringType())
    }
  }

  "or expressions" should {
    "type check on booleans" in {
      val expression = Or(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = Or(Or(AnyBoolean, AnyBoolean), AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      val expression = Or(AnyString, AnyNumber)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "and expressions" should {
    "type check on booleans" in {
      val expression = And(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on booleans and expressions that resolve to booleans" in {
      val expression = And(And(AnyBoolean, AnyBoolean), AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      val expression = And(AnyString, AnyNumber)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not expressions" should {
    "type check on booleans" in {
      val expression = Not(AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on other types" in {
      val expression = Not(AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "equal expressions" should {
    "type check on booleans" in {
      val expression = Equal(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      val expression = Equal(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on strings" in {
      val expression = Equal(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      val expression = Equal(AnyString, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "not equal expressions" should {
    "type check on booleans" in {
      val expression = NotEqual(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on numbers" in {
      val expression = NotEqual(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "type check on strings" in {
      val expression = NotEqual(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on two different types" in {
      val expression = NotEqual(AnyString, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than expressions" should {
    "type check on numbers" in {
      val expression = LessThan(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = LessThan(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThan(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "less than or equal expressions" should {
    "type check on numbers" in {
      val expression = LessThanEqual(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = LessThanEqual(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = LessThanEqual(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than expressions" should {
    "type check on numbers" in {
      val expression = GreaterThan(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = GreaterThan(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThan(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "greater than or equal expressions" should {
    "type check on numbers" in {
      val expression = GreaterThanEqual(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(BooleanType())
    }

    "not type check on strings" in {
      val expression = GreaterThanEqual(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = GreaterThanEqual(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "addition expressions" should {
    "type check on 1 + 1" in {
      val expression = Add(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "type check on 2 + 2 + 2" in {
      val expression = Add(AnyNumber, Add(AnyNumber, AnyNumber))

      check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Add(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Add(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "subtraction expressions" should {
    "type check 1 - 1" in {
      val expression = Sub(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Sub(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Sub(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "multiplication expressions" should {
    "type check on 1 * 1" in {
      val expression = Mul(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Mul(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Mul(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "division expressions" should {
    "type check on 1 / 1" in {
      val expression = Div(AnyNumber, AnyNumber)

      check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Div(AnyString, AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Div(AnyBoolean, AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "negation expressions" should {
    "type check on -1" in {
      val expression = Negation(AnyNumber)

      check(expression, EmptyEnvironment) must beRight(NumberType())
    }

    "not type check on strings" in {
      val expression = Negation(AnyString)

      check(expression, EmptyEnvironment) must beLeft
    }

    "not type check on booleans" in {
      val expression = Negation(AnyBoolean)

      check(expression, EmptyEnvironment) must beLeft
    }
  }

  "variable expressions" should {
    "lookup booleans" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> BooleanType())

      check(variable, environmentWithQuestion) must beRight(BooleanType())
    }

    "lookup integers" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> NumberType())

      check(variable, environmentWithQuestion) must beRight(NumberType())
    }

    "lookup strings" in {
      val variable = Variable("X")
      val environmentWithQuestion = Map("X" -> StringType())

      check(variable, environmentWithQuestion) must beRight(StringType())
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
