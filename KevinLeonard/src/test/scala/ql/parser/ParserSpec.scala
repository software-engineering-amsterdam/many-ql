package ql.parser

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import ql.ast._

class ParserSpec extends Specification with ParserMatchers {
  val parsers = new Parser

  val LiteralTrue: BooleanLiteral = BooleanLiteral(BooleanValue(true))
  val LiteralFalse: BooleanLiteral = BooleanLiteral(BooleanValue(false))
  val LiteralOne: NumberLiteral = NumberLiteral(NumberValue(1))
  val LiteralTwo: NumberLiteral = NumberLiteral(NumberValue(2))
  val LiteralA: StringLiteral = StringLiteral(StringValue("a"))
  val LiteralB: StringLiteral = StringLiteral(StringValue("b"))

  "variable parser" should {
    "parse a valid Java identifier" in {
      val variableName = "var1"
      val result = Variable(variableName)

      parsers.variable must succeedOn(variableName).withResult(result)
    }
  }

  "form parser" should {
    "ignore single line comments" in {
      val formWithSingleLineComment = "form form1 {\n// Single line comment\n}"
      val result = Form("form1", Sequence(List()))

      parsers.form must succeedOn(formWithSingleLineComment).withResult(result)
    }

    "ignore multiline comments" in {
      val formWithMultilineComment = "form form1 {\n/**\n* Multiline comment\n*/}"
      val result = Form("form1", Sequence(List()))

      parsers.form must succeedOn(formWithMultilineComment).withResult(result)
    }
  }

  "question parser" should {
    "parse boolean questions" in {
      val booleanQuestion = "question var \"label\"\nanswer boolean"
      val result = Question(BooleanType(), Variable("var"), "label", None)

      parsers.question must succeedOn(booleanQuestion).withResult(result)
    }

    "parse number questions" in {
      val numberQuestion = "question var \"label\"\nanswer number"
      val result = Question(NumberType(), Variable("var"), "label", None)

      parsers.question must succeedOn(numberQuestion).withResult(result)
    }

    "parse string questions" in {
      val stringQuestion = "question var \"label\"\nanswer string"
      val result = Question(StringType(), Variable("var"), "label", None)

      parsers.question must succeedOn(stringQuestion).withResult(result)
    }

    "parse computed number questions" in {
      val computedNumberQuestion = "question var \"label\"\nanswer number is (fieldA + fieldB)"
      val result = Question(NumberType(), Variable("var"), "label", Some(Add(Variable("fieldA"), Variable("fieldB"))))

      parsers.question must succeedOn(computedNumberQuestion).withResult(result)
    }

    "parse computed boolean questions" in {
      val computedBooleanQuestion = "question var \"label\"\n    answer boolean is (fieldA and fieldB < fieldC)"
      val result = Question(BooleanType(), Variable("var"), "label",
        Some(And(Variable("fieldA"), LessThan(Variable("fieldB"), Variable("fieldC"))))
      )

      parsers.question must succeedOn(computedBooleanQuestion).withResult(result)
    }

    "parse computed string questions" in {
      val computedStringQuestion = "question var \"label\"\n    answer string is (fieldA + fieldB)"
      val result = Question(StringType(), Variable("var"), "label", Some(Add(Variable("fieldA"), Variable("fieldB"))))

      parsers.question must succeedOn(computedStringQuestion).withResult(result)
    }
  }

  "if statement parser" should {
    "parse if statements without an else clause" in {
      val emptyIf = "if var {}"
      val result = IfStatement(Variable("var"), Sequence(List()), None)

      parsers.ifStatement must succeedOn(emptyIf).withResult(result)
    }

    "parse if statements with an else clause" in {
      val emptyIfElse = "if var {} else {}"
      val result = IfStatement(Variable("var"), Sequence(List()), Some(Sequence(List())))

      parsers.ifStatement must succeedOn(emptyIfElse).withResult(result)
    }
  }

  "and parser" should {
    "parse an and operator" in {
      val andOperation = "true and false"
      val result = And(LiteralTrue, LiteralFalse)

      parsers.and must succeedOn(andOperation).withResult(result)
    }

    "parse multiple and operators" in {
      val andOperation = "true and false and true"
      val result = And(
        And(LiteralTrue, LiteralFalse),
        LiteralTrue
      )

      parsers.and must succeedOn(andOperation).withResult(result)
    }
  }

  "or parser" should {
    "parse an or operator" in {
      val orOperation = "true or false"
      val result = Or(LiteralTrue, LiteralFalse)

      parsers.or must succeedOn(orOperation).withResult(result)
    }

    "parse mulitple or operators" in {
      val orOperation = "true or false or true"
      val result = Or(
        Or(LiteralTrue, LiteralFalse),
        LiteralTrue
      )

      parsers.or must succeedOn(orOperation).withResult(result)
    }
  }

  "not parser" should {
    "parse a not operator" in {
      val notOperation = "not true"
      val result = Not(LiteralTrue)

      parsers.not must succeedOn(notOperation).withResult(result)
    }

    "parse if there is not a negation operator" in {
      val notOperation = "true"
      val result = LiteralTrue

      parsers.not must succeedOn(notOperation).withResult(result)
    }
  }

  "equality parser" should {
    "parse a == operator with booleans" in {
      val equalityOperation = "true == true"
      val result = Equal(LiteralTrue, LiteralTrue)

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "parse a == operator with numbers" in {
      val equalityOperation = "1 == 2"
      val result = Equal(LiteralOne, LiteralTwo)

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "parse a == operator with strings" in {
      val equalityOperation = "\"a\" == \"b\""
      val result = Equal(LiteralA, LiteralB)

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "parse a != operator with booleans" in {
      val equalityOperation = "true != true"
      val result = NotEqual(LiteralTrue, LiteralTrue)

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "parse a != operator with numbers" in {
      val equalityOperation = "1 != 2"
      val result = NotEqual(LiteralOne, LiteralTwo)

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "parse a != operator with strings" in {
      val equalityOperation = "\"a\" != \"b\""
      val result = NotEqual(LiteralA, LiteralB)

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }
  }

  "relational parser" should {
    "parse a < operator" in {
      val relationalOperation = "1 < 2"
      val result = LessThan(LiteralOne, LiteralTwo)

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }

    "parse a <= operator" in {
      val relationalOperation = "1 <= 2"
      val result = LessThanEqual(LiteralOne, LiteralTwo)

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }

    "parse a > operator" in {
      val relationalOperation = "1 > 2"
      val result = GreaterThan(LiteralOne, LiteralTwo)

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }

    "parse a >= operator" in {
      val relationalOperation = "1 >= 2"
      val result = GreaterThanEqual(LiteralOne, LiteralTwo)

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }
  }

  "sum parser" should {
    "parse a plus operator" in {
      val expression = "1 + 2"
      val result = Add(LiteralOne, LiteralTwo)

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "parse multiple plus operators" in {
      val expression = "1 + 2 + 3"
      val result = Add(Add(LiteralOne, LiteralTwo), NumberLiteral(NumberValue(3)))

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "parse a minus operator" in {
      val expression = "1 - 2"
      val result = Sub(LiteralOne, LiteralTwo)

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "parse multiple minus operators" in {
      val expression = "1 - 2 - 3"
      val result = Sub(Sub(LiteralOne, LiteralTwo), NumberLiteral(NumberValue(3)))

      parsers.sum must  succeedOn(expression).withResult(result)
    }
  }

  "product parser" should {
    "parse a product operator" in {
      val expression = "1 * 2"
      val result = Mul(LiteralOne, LiteralTwo)

      parsers.product must succeedOn(expression).withResult(result)
    }

    "parse multiple product operators" in {
      val expression = "1 * 2 * 3"
      val result = Mul(Mul(LiteralOne, LiteralTwo), NumberLiteral(NumberValue(3)))

      parsers.product must succeedOn(expression).withResult(result)
    }

    "parse a divide operator" in {
      val expression = "1 / 2"
      val result = Div(LiteralOne, LiteralTwo)

      parsers.product must succeedOn(expression).withResult(result)
    }

    "parse multiple divide operators" in {
      val expression = "1 / 2 / 3"
      val result = Div(Div(LiteralOne, LiteralTwo), NumberLiteral(NumberValue(3)))

      parsers.product must succeedOn(expression).withResult(result)
    }
  }

  "negation parser" should {
    "parse a unary negation" in {
      val expression = "-1"
      val result = Negation(LiteralOne)

      parsers.negation must succeedOn(expression).withResult(result)
    }

    "parse input without a unary negation" in {
      val expression = "1"
      val result = LiteralOne

      parsers.negation must succeedOn(expression).withResult(result)
    }
  }

  "expression parser" should {
    "parse a literal" in {
      val expression = "true"
      val result = LiteralTrue

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "parse a variable" in {
      val expression = "var1"
      val result = Variable(expression)

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "have the correct precedence when using parenthesis" in {
      val expression = "true and (false or true)"
      val result = And(
        LiteralTrue,
        Or(LiteralFalse, LiteralTrue)
      )

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "parse multiple different operators" in {
      val expression = "true and true and false or true"
      val result = Or(
        And(
          And(LiteralTrue, LiteralTrue),
          LiteralFalse), BooleanLiteral(BooleanValue(true)
        )
      )

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "give negation precedence over sum" in {
      val expression = "-1 + 3"
      val result = Add(Negation(LiteralOne), NumberLiteral(NumberValue(3)))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "give product precedence over sum" in {
      val expression = "1 * 2 + 3"
      val result = Add(Mul(LiteralOne, LiteralTwo), NumberLiteral(NumberValue(3)))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "give product precedence over sum" in {
      val expression = "1 + 2 * 3"
      val result = Add(LiteralOne, Mul(LiteralTwo, NumberLiteral(NumberValue(3))))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "have the correct precedence when using parenthesis" in {
      val expression = "1 * (2 - 3)"
      val result = Mul(LiteralOne, Sub(LiteralTwo, NumberLiteral(NumberValue(3))))

      parsers.expression must succeedOn(expression).withResult(result)
    }
  }
}
