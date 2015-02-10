package test.scala

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import parser.QLParser

class QLParserSpec extends Specification with ParserMatchers {
  val parsers = new QLParser

  import parsers._

  "form parser" should {
    "ignore singleline comments" in {
      form must succeedOn("form form1 {\n    // SINGLE LINE COMMENT\n}")
        .withResult(Form("form1", Sequence(List())))
    }

    "ignore multi line comments" in {
      form must succeedOn("form form1 {\n    /**\n     * Multiline comment\n     */}")
        .withResult(Form("form1", Sequence(List())))
    }
  }

  "question parser" should {
    "parse boolean questions" in {
      questionExpression must succeedOn("question var \"label\"\nanswer boolean")
        .withResult(BooleanQuestion(Variable("var"), "\"label\""))
    }

    "parse integer questions" in {
      questionExpression must succeedOn("question var \"label\"\nanswer integer")
        .withResult(IntegerQuestion(Variable("var"), "\"label\""))
    }

    "parse string questions" in {
      questionExpression must succeedOn("question var \"label\"\nanswer string")
        .withResult(StringQuestion(Variable("var"), "\"label\""))
    }

    "parse computed integer questions" in {
      questionExpression must succeedOn("question var \"label\"\nanswer integer is (fieldA + fieldB)")
        .withResult(ComputedIntegerQuestion(Variable("var"), "\"label\"", Add(Variable("fieldA"), Variable("fieldB"))))
    }

    "parse computed boolean questions" in {
      questionExpression must succeedOn("question var \"label\"\n    answer boolean is (fieldA and fieldB < fieldC)")
        .withResult(ComputedBooleanQuestion(Variable("var"), "\"label\"", And(Variable("fieldA"), LessThan(Variable("fieldB"), Variable("fieldC")))))
    }

    "parse computed string questions" in {
      questionExpression must succeedOn("question var \"label\"\n    answer string is (fieldA + fieldB)")
        .withResult(ComputedStringQuestion(Variable("var"), "\"label\"", Add(Variable("fieldA"), Variable("fieldB"))))
    }
  }

  "if statement parser" should {
    "parse if statements without an else clause" in {
      ifExpression must succeedOn("if var {}")
        .withResult(IfExpr(Variable("var"), Sequence(List()), None))
    }

    "parse if statements with an else clause" in {
      ifExpression must succeedOn("if var {} else {}")
        .withResult(IfExpr(Variable("var"), Sequence(List()), Some(Sequence(List()))))
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
    "be valid with a == operator" in {
      equality must succeedOn("1 == 2")
        .withResult(Equal(NumberLiteral(1), NumberLiteral(2)))
    }

    "be valid with a != operator" in {
      equality must succeedOn("1 != 2")
        .withResult(NotEqual(NumberLiteral(1), NumberLiteral(2)))
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

  "boolean expressions" should {
    "be valid with a literal" in {
      booleanExpression must succeedOn("true")
        .withResult(BooleanLiteral(true))
    }

    "be valid with a variable" in {
      booleanExpression must succeedOn("var1")
        .withResult(Variable("var1"))
    }

    "have the correct precedence when using parenthesis" in {
      booleanExpression must succeedOn("true and (false or true)")
        .withResult(And(BooleanLiteral(true), Or(BooleanLiteral(false), BooleanLiteral(true))))
    }

    "be valid with multiple different operators" in {
      booleanExpression must succeedOn("true and true and false or true")
        .withResult(Or(And(And(BooleanLiteral(true), BooleanLiteral(true)), BooleanLiteral(false)), BooleanLiteral(true)))
    }
  }

  "sum parser" should {
    "be valid with an plus operator" in {
      sum must succeedOn("1 + 2")
        .withResult(Add(NumberLiteral(1), NumberLiteral(2)))
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

  "arithmetic expressions" should {
    "give product precedence over sum" in {
      arithmeticExpression must succeedOn("1 * 2 + 3")
        .withResult(Add(Mul(NumberLiteral(1), NumberLiteral(2)), NumberLiteral(3)))

      arithmeticExpression must succeedOn("1 + 2 * 3")
        .withResult(Add(NumberLiteral(1), Mul(NumberLiteral(2), NumberLiteral(3))))
    }

    "have the correct precedence when using parenthesis" in {
      arithmeticExpression must succeedOn("1 * (2 - 3)")
        .withResult(Mul(NumberLiteral(1), Sub(NumberLiteral(2), NumberLiteral(3))))
    }
  }
}
