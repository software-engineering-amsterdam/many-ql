package parser

import ast._
import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification

class ParserSpec extends Specification with ParserMatchers {
  val parsers = new Parser

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
        .withResult(new Form("form1", Sequence(List())))
    }

    "ignore multiline comments" in {
      form must succeedOn("form form1 {\n/**\n* Multiline comment\n*/}")
        .withResult(new Form("form1", Sequence(List())))
    }
  }

  "question parser" should {
    "parse boolean questions" in {
      question must succeedOn("question var \"label\"\nanswer boolean")
        .withResult(Question(BooleanType(), Variable("var"), "label", None))
    }

    "parse number questions" in {
      question must succeedOn("question var \"label\"\nanswer number")
        .withResult(Question(NumberType(), Variable("var"), "label", None))
    }

    "parse string questions" in {
      question must succeedOn("question var \"label\"\nanswer string")
        .withResult(Question(StringType(), Variable("var"), "label", None))
    }

    "parse computed number questions" in {
      question must succeedOn("question var \"label\"\nanswer number is (fieldA + fieldB)")
        .withResult(Question(NumberType(), Variable("var"), "label", Some(Add(Variable("fieldA"), Variable("fieldB")))))
    }

    "parse computed boolean questions" in {
      question must succeedOn("question var \"label\"\n    answer boolean is (fieldA and fieldB < fieldC)")
        .withResult(Question(BooleanType(), Variable("var"), "label", Some(And(Variable("fieldA"), LessThan(Variable("fieldB"), Variable("fieldC"))))))
    }

    "parse computed string questions" in {
      question must succeedOn("question var \"label\"\n    answer string is (fieldA + fieldB)")
        .withResult(Question(StringType(), Variable("var"), "label", Some(Add(Variable("fieldA"), Variable("fieldB")))))
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
        .withResult(And(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))))
    }

    "be valid with multiple and operators" in {
      and must succeedOn("true and false and true")
        .withResult(And(And(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), Literal(BooleanType(), BooleanValue(true))))
    }
  }

  "or parser" should {
    "be valid with an or operator" in {
      or must succeedOn("true or false")
        .withResult(Or(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))))
    }

    "be valid with multiple or operators" in {
      or must succeedOn("true or false or true")
        .withResult(Or(Or(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(false))), Literal(BooleanType(), BooleanValue(true))))
    }
  }

  "not parser" should {
    "be valid with a not operator" in {
      parsers.not must succeedOn("not true")
        .withResult(Not(Literal(BooleanType(), BooleanValue(true))))
    }
  }

  "equality parser" should {
    "be valid with a == operator on booleans" in {
      equality must succeedOn("true == true")
        .withResult(Equal(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))))
    }

    "be valid with a == operator on numbers" in {
      equality must succeedOn("1 == 2")
        .withResult(Equal(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with a == operator on strings" in {
      equality must succeedOn("\"a\" == \"b\"")
        .withResult(Equal(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("b"))))
    }

    "be valid with a != operator on booleans" in {
      equality must succeedOn("true != true")
        .withResult(NotEqual(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))))
    }

    "be valid with a != operator on numbers" in {
      equality must succeedOn("1 != 2")
        .withResult(NotEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with a != operator on strings" in {
      equality must succeedOn("\"a\" != \"b\"")
        .withResult(NotEqual(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("b"))))
    }
  }

  "comparison parser" should {
    "be valid with a < operator" in {
      comparison must succeedOn("1 < 2")
        .withResult(LessThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with a <= operator" in {
      comparison must succeedOn("1 <= 2")
        .withResult(LessThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with a > operator" in {
      comparison must succeedOn("1 > 2")
        .withResult(GreaterThan(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with a >= operator" in {
      comparison must succeedOn("1 >= 2")
        .withResult(GreaterThanEqual(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }
  }

  "sum parser" should {
    "be valid with an plus operator on numbers" in {
      sum must succeedOn("1 + 2")
        .withResult(Add(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with an plus operator on strings" in {
      sum must succeedOn("\"a\" + \"b\"")
        .withResult(Add(Literal(StringType(), StringValue("a")), Literal(StringType(), StringValue("b"))))
    }

    "be valid with multiple plus operators" in {
      sum must succeedOn("1 + 2 + 3")
        .withResult(Add(Add(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), Literal(NumberType(), NumberValue(3))))
    }

    "be valid with an minus operator" in {
      sum must succeedOn("1 - 2")
        .withResult(Sub(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with multiple minus operators" in {
      sum must succeedOn("1 - 2 - 3")
        .withResult(Sub(Sub(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), Literal(NumberType(), NumberValue(3))))
    }
  }

  "product parser" should {
    "be valid with an product operator" in {
      product must succeedOn("1 * 2")
        .withResult(Mul(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with multiple product operators" in {
      product must succeedOn("1 * 2 * 3")
        .withResult(Mul(Mul(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), Literal(NumberType(), NumberValue(3))))
    }

    "be valid with an divide operator" in {
      product must succeedOn("1 / 2")
        .withResult(Div(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))))
    }

    "be valid with multiple divide operators" in {
      product must succeedOn("1 / 2 / 3")
        .withResult(Div(Div(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), Literal(NumberType(), NumberValue(3))))
    }
  }

  "expressions" should {
    "be valid with a literal" in {
      expression must succeedOn("true")
        .withResult(Literal(BooleanType(), BooleanValue(true)))
    }

    "be valid with a variable" in {
      expression must succeedOn("var1")
        .withResult(Variable("var1"))
    }

    "have the correct precedence when using parenthesis" in {
      expression must succeedOn("true and (false or true)")
        .withResult(And(Literal(BooleanType(), BooleanValue(true)), Or(Literal(BooleanType(), BooleanValue(false)), Literal(BooleanType(), BooleanValue(true)))))
    }

    "be valid with multiple different operators" in {
      expression must succeedOn("true and true and false or true")
        .withResult(Or(And(And(Literal(BooleanType(), BooleanValue(true)), Literal(BooleanType(), BooleanValue(true))), Literal(BooleanType(), BooleanValue(false))), Literal(BooleanType(), BooleanValue(true))))
    }

    "give product precedence over sum" in {
      expression must succeedOn("1 * 2 + 3")
        .withResult(Add(Mul(Literal(NumberType(), NumberValue(1)), Literal(NumberType(), NumberValue(2))), Literal(NumberType(), NumberValue(3))))
    }

    "give product precedence over sum" in {
      expression must succeedOn("1 + 2 * 3")
        .withResult(Add(Literal(NumberType(), NumberValue(1)), Mul(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(3)))))
    }

    "have the correct precedence when using parenthesis" in {
      expression must succeedOn("1 * (2 - 3)")
        .withResult(Mul(Literal(NumberType(), NumberValue(1)), Sub(Literal(NumberType(), NumberValue(2)), Literal(NumberType(), NumberValue(3)))))
    }
  }
}
