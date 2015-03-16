package ql.parser

import ql.ast._
import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification

class ParserSpec extends Specification with ParserMatchers {
  val parsers = new Parser

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

      parsers.question must succeedOn(numberQuestion).withResult(Question(NumberType(), Variable("var"), "label", None))
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
      val result = Question(BooleanType(), Variable("var"), "label", Some(And(Variable("fieldA"), LessThan(Variable("fieldB"), Variable("fieldC")))))

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
    "be valid with an and operator" in {
      val andOperation = "true and false"
      val result = And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      parsers.and must succeedOn(andOperation).withResult(result)
    }

    "be valid with multiple and operators" in {
      val andOperation = "true and false and true"
      val result = And(
        And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))),
        BooleanLiteral(BooleanValue(true))
      )

      parsers.and must succeedOn(andOperation).withResult(result)
    }
  }

  "or parser" should {
    "be valid with an or operator" in {
      val orOperation = "true or false"
      val result = Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false)))

      parsers.or must succeedOn(orOperation).withResult(result)
    }

    "be valid with multiple or operators" in {
      val orOperation = "true or false or true"
      val result = Or(
        Or(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(false))),
        BooleanLiteral(BooleanValue(true))
      )

      parsers.or must succeedOn(orOperation).withResult(result)
    }
  }

  "not parser" should {
    "be valid with a not operator" in {
      val notOperation = "not true"
      val result = Not(BooleanLiteral(BooleanValue(true)))

      parsers.not must succeedOn(notOperation).withResult(result)
    }

    "be valid without a not operator" in {
      val notOperation = "true"
      val result = BooleanLiteral(BooleanValue(true))

      parsers.not must succeedOn(notOperation).withResult(result)
    }
  }

  "equality parser" should {
    "be valid with a == operator on booleans" in {
      val equalityOperation = "true == true"
      val result = Equal(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true)))

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "be valid with a == operator on numbers" in {
      val equalityOperation = "1 == 2"
      val result = Equal(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "be valid with a == operator on strings" in {
      val equalityOperation = "\"a\" == \"b\""
      val result = Equal(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "be valid with a != operator on booleans" in {
      val equalityOperation = "true != true"
      val result = NotEqual(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true)))

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "be valid with a != operator on numbers" in {
      val equalityOperation = "1 != 2"
      val result = NotEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }

    "be valid with a != operator on strings" in {
      val equalityOperation = "\"a\" != \"b\""
      val result = NotEqual(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      parsers.equality must succeedOn(equalityOperation).withResult(result)
    }
  }

  "relational parser" should {
    "be valid with a < operator" in {
      val relationalOperation = "1 < 2"
      val result = LessThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }

    "be valid with a <= operator" in {
      val relationalOperation = "1 <= 2"
      val result = LessThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }

    "be valid with a > operator" in {
      val relationalOperation = "1 > 2"
      val result = GreaterThan(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }

    "be valid with a >= operator" in {
      val relationalOperation = "1 >= 2"
      val result = GreaterThanEqual(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.relational must succeedOn(relationalOperation).withResult(result)
    }
  }

  "sum parser" should {
    "be valid with an plus operator on numbers" in {
      val expression = "1 + 2"
      val result = Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "be valid with an plus operator on strings" in {
      val expression = "\"a\" + \"b\""
      val result = Add(StringLiteral(StringValue("a")), StringLiteral(StringValue("b")))

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "be valid with multiple plus operators" in {
      val expression = "1 + 2 + 3"
      val result = Add(Add(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), NumberLiteral(NumberValue(3)))

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "be valid with an minus operator" in {
      val expression = "1 - 2"
      val result = Sub(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.sum must  succeedOn(expression).withResult(result)
    }

    "be valid with multiple minus operators" in {
      val expression = "1 - 2 - 3"
      val result = Sub(Sub(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), NumberLiteral(NumberValue(3)))

      parsers.sum must  succeedOn(expression).withResult(result)
    }
  }

  "product parser" should {
    "be valid with an product operator" in {
      val expression = "1 * 2"
      val result = Mul(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.product must succeedOn(expression).withResult(result)
    }

    "be valid with multiple product operators" in {
      val expression = "1 * 2 * 3"
      val result = Mul(Mul(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), NumberLiteral(NumberValue(3)))

      parsers.product must succeedOn(expression).withResult(result)
    }

    "be valid with an divide operator" in {
      val expression = "1 / 2"
      val result = Div(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2)))

      parsers.product must succeedOn(expression).withResult(result)
    }

    "be valid with multiple divide operators" in {
      val expression = "1 / 2 / 3"
      val result = Div(Div(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), NumberLiteral(NumberValue(3)))

      parsers.product must succeedOn(expression).withResult(result)
    }
  }

  "negation parser" should {
    "be valid with an unary negation" in {
      val expression = "-1"
      val result = Negation(NumberLiteral(NumberValue(1)))

      parsers.negation must succeedOn("-1").withResult(result)
    }

    "be valid without an unary negation" in {
      val expression = "1"
      val result = NumberLiteral(NumberValue(1))

      parsers.negation must succeedOn("1").withResult(result)
    }
  }

  "expressions" should {
    "be valid with a literal" in {
      val expression = "true"
      val result = BooleanLiteral(BooleanValue(true))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "be valid with a variable" in {
      val expression = "var1"
      val result = Variable(expression)

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "have the correct precedence when using parenthesis" in {
      val expression = "true and (false or true)"
      val result = And(
        BooleanLiteral(BooleanValue(true)),
        Or(BooleanLiteral(BooleanValue(false)), BooleanLiteral(BooleanValue(true)))
      )

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "be valid with multiple different operators" in {
      val expression = "true and true and false or true"
      val result = Or(
        And(
          And(BooleanLiteral(BooleanValue(true)), BooleanLiteral(BooleanValue(true))),
          BooleanLiteral(BooleanValue(false))), BooleanLiteral(BooleanValue(true)
        )
      )

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "give negation precedence over sum" in {
      val expression = "-1 + 3"
      val result = Add(Negation(NumberLiteral(NumberValue(1))), NumberLiteral(NumberValue(3)))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "give product precedence over sum" in {
      val expression = "1 * 2 + 3"
      val result = Add(Mul(NumberLiteral(NumberValue(1)), NumberLiteral(NumberValue(2))), NumberLiteral(NumberValue(3)))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "give product precedence over sum" in {
      val expression = "1 + 2 * 3"
      val result = Add(NumberLiteral(NumberValue(1)), Mul(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(3))))

      parsers.expression must succeedOn(expression).withResult(result)
    }

    "have the correct precedence when using parenthesis" in {
      val expression = "1 * (2 - 3)"
      val result = Mul(NumberLiteral(NumberValue(1)), Sub(NumberLiteral(NumberValue(2)), NumberLiteral(NumberValue(3))))

      parsers.expression must succeedOn(expression).withResult(result)
    }
  }
}
