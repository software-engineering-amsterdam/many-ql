package parser

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification

class QLParserSpec extends Specification with ParserMatchers {
  val parsers = new QLParser

  import parsers._

  "variable parser" should {
    "parse a valid Java identifier" in {
      variable must succeedOn("var1")
        .withResult(Variable("var1"))
    }
  }

  "form parser" should {
    "ignore single line comments" in {
      form must succeedOn("form form1 {\n// Single line comment\n}")
        .withResult(Form("form1", Sequence(List())))
    }

    "ignore multiline comments" in {
      form must succeedOn("form form1 {\n/**\n* Multiline comment\n*/}")
        .withResult(Form("form1", Sequence(List())))
    }
  }

  "question parser" should {
    "parse boolean questions" in {
      question must succeedOn("question var \"label\"\nanswer boolean")
        .withResult(BooleanQuestion(Variable("var"), "\"label\""))
    }

    "parse integer questions" in {
      question must succeedOn("question var \"label\"\nanswer integer")
        .withResult(IntegerQuestion(Variable("var"), "\"label\""))
    }

    "parse string questions" in {
      question must succeedOn("question var \"label\"\nanswer string")
        .withResult(StringQuestion(Variable("var"), "\"label\""))
    }

    "parse computed integer questions" in {
      question must succeedOn("question var \"label\"\nanswer integer is (fieldA + fieldB)")
        .withResult(ComputedIntegerQuestion(Variable("var"), "\"label\"", Add(Variable("fieldA"), Variable("fieldB"))))
    }

    "parse computed boolean questions" in {
      question must succeedOn("question var \"label\"\n    answer boolean is (fieldA and fieldB < fieldC)")
        .withResult(ComputedBooleanQuestion(Variable("var"), "\"label\"", And(Variable("fieldA"), LessThan(Variable("fieldB"), Variable("fieldC")))))
    }

    "parse computed string questions" in {
      question must succeedOn("question var \"label\"\n    answer string is (fieldA + fieldB)")
        .withResult(ComputedStringQuestion(Variable("var"), "\"label\"", Add(Variable("fieldA"), Variable("fieldB"))))
    }
  }

  "if statement parser" should {
    "parse if statements without an else clause" in {
      ifStatement must succeedOn("if var {}")
        .withResult(IfStatement(Variable("var"), Sequence(List()), None))
    }

    "parse if statements with an else clause" in {
      ifStatement must succeedOn("if var {} else {}")
        .withResult(IfStatement(Variable("var"), Sequence(List()), Some(Sequence(List()))))
    }
  }

  "and parser" should {
    "be valid with an and operator" in {
      and must succeedOn("true and false")
        .withResult(And(BooleanLiteral(true), BooleanLiteral(false)))
    }

    "be valid with multiple and operators" in {
      and must succeedOn("true and false and true")
        .withResult(And(And(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(true)))
    }
  }

  "or parser" should {
    "be valid with an or operator" in {
      or must succeedOn("true or false")
        .withResult(Or(BooleanLiteral(true), BooleanLiteral(false)))
    }

    "be valid with multiple or operators" in {
      or must succeedOn("true or false or true")
        .withResult(Or(Or(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(true)))
    }
  }

  "not parser" should {
    "be valid with a not operator" in {
      parsers.not must succeedOn("not true")
        .withResult(Not(BooleanLiteral(true)))
    }
  }

  "equality parser" should {
    "be valid with a == operator on booleans" in {
      equality must succeedOn("true == true")
        .withResult(Equal(BooleanLiteral(true), BooleanLiteral(true)))
    }

    "be valid with a == operator on numbers" in {
      equality must succeedOn("1 == 2")
        .withResult(Equal(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with a == operator on strings" in {
      equality must succeedOn("\"a\" == \"b\"")
        .withResult(Equal(StringLiteral("\"a\""), StringLiteral("\"b\"")))
    }

    "be valid with a != operator on booleans" in {
      equality must succeedOn("true != true")
        .withResult(NotEqual(BooleanLiteral(true), BooleanLiteral(true)))
    }

    "be valid with a != operator on numbers" in {
      equality must succeedOn("1 != 2")
        .withResult(NotEqual(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with a != operator on strings" in {
      equality must succeedOn("\"a\" != \"b\"")
        .withResult(NotEqual(StringLiteral("\"a\""), StringLiteral("\"b\"")))
    }
  }

  "comparison parser" should {
    "be valid with a < operator" in {
      comparison must succeedOn("1 < 2")
        .withResult(LessThan(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with a <= operator" in {
      comparison must succeedOn("1 <= 2")
        .withResult(LessThanEqual(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with a > operator" in {
      comparison must succeedOn("1 > 2")
        .withResult(GreaterThan(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with a >= operator" in {
      comparison must succeedOn("1 >= 2")
        .withResult(GreaterThanEqual(NumberLiteral(1), NumberLiteral(2)))
    }
  }

  "sum parser" should {
    "be valid with an plus operator on numbers" in {
      sum must succeedOn("1 + 2")
        .withResult(Add(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with an plus operator on strings" in {
      sum must succeedOn("\"a\" + \"b\"")
        .withResult(Add(StringLiteral("\"a\""), StringLiteral("\"b\"")))
    }

    "be valid with multiple plus operators" in {
      sum must succeedOn("1 + 2 + 3")
        .withResult(Add(Add(NumberLiteral(1), NumberLiteral(2)), NumberLiteral(3)))
    }

    "be valid with an minus operator" in {
      sum must succeedOn("1 - 2")
        .withResult(Sub(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with multiple minus operators" in {
      sum must succeedOn("1 - 2 - 3")
        .withResult(Sub(Sub(NumberLiteral(1), NumberLiteral(2)), NumberLiteral(3)))
    }
  }

  "product parser" should {
    "be valid with an product operator" in {
      product must succeedOn("1 * 2")
        .withResult(Mul(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with multiple product operators" in {
      product must succeedOn("1 * 2 * 3")
        .withResult(Mul(Mul(NumberLiteral(1), NumberLiteral(2)), NumberLiteral(3)))
    }

    "be valid with an divide operator" in {
      product must succeedOn("1 / 2")
        .withResult(Div(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with multiple divide operators" in {
      product must succeedOn("1 / 2 / 3")
        .withResult(Div(Div(NumberLiteral(1), NumberLiteral(2)), NumberLiteral(3)))
    }
  }

  "expressions" should {
    "be valid with a literal" in {
      expression must succeedOn("true")
        .withResult(BooleanLiteral(true))
    }

    "be valid with a variable" in {
      expression must succeedOn("var1")
        .withResult(Variable("var1"))
    }

    "have the correct precedence when using parenthesis" in {
      expression must succeedOn("true and (false or true)")
        .withResult(And(BooleanLiteral(true), Or(BooleanLiteral(false), BooleanLiteral(true))))
    }

    "be valid with multiple different operators" in {
      expression must succeedOn("true and true and false or true")
        .withResult(Or(And(And(BooleanLiteral(true), BooleanLiteral(true)), BooleanLiteral(false)), BooleanLiteral(true)))
    }

    "give product precedence over sum" in {
      expression must succeedOn("1 * 2 + 3")
        .withResult(Add(Mul(NumberLiteral(1), NumberLiteral(2)), NumberLiteral(3)))
    }

    "give product precedence over sum" in {
      expression must succeedOn("1 + 2 * 3")
        .withResult(Add(NumberLiteral(1), Mul(NumberLiteral(2), NumberLiteral(3))))
    }

    "have the correct precedence when using parenthesis" in {
      expression must succeedOn("1 * (2 - 3)")
        .withResult(Mul(NumberLiteral(1), Sub(NumberLiteral(2), NumberLiteral(3))))
    }
  }
}
