package test.scala

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import parser.QLParser

class QLParserSpec extends Specification with ParserMatchers {
  val parsers = new QLParser

  import parsers._

  "boolean question" should {
    "have a variable and a label" in {
      questionExpression must succeedOn("question var \"label\"\nanswer boolean")
        .withResult(BooleanQuestion(Variable("var"), "\"label\""))
    }
  }

  "integer question" should {
    "have a variable and a label" in {
      questionExpression must succeedOn("question var \"label\"\nanswer integer")
        .withResult(IntegerQuestion(Variable("var"), "\"label\""))
    }
  }

  "string question" should {
    "have a variable and a label" in {
      questionExpression must succeedOn("question var \"label\"\nanswer string")
        .withResult(StringQuestion(Variable("var"), "\"label\""))
    }
  }

  "if statements" should {
    "be valid without an else clause" in {
      ifExpression must succeedOn("if var {}")
        .withResult(IfExpr(Variable("var"), Sequence(List()), None))
    }

    "be valid with an else clause" in {
      ifExpression must succeedOn("if var {} else {}")
        .withResult(IfExpr(Variable("var"), Sequence(List()), Some(Sequence(List()))))
    }
  }

  "boolean expressions" should {
    "be valid with a constant" in {
      booleanExpression must succeedOn("true")
        .withResult(Const("true"))
    }

    "be valid with a variable" in {
      booleanExpression must succeedOn("not var1")
        .withResult(Not(Variable("var1")))
    }

    "be valid with an and operator" in {
      booleanExpression must succeedOn("true and false")
        .withResult(And(Const("true"), Const("false")))
    }

    "be valid with an or operator" in {
      booleanExpression must succeedOn("true or false")
        .withResult(Or(Const("true"), Const("false")))
    }

    "be valid with a not operator" in {
      booleanExpression must succeedOn("not true")
        .withResult(Not(Const("true")))
    }

    "be valid with parenthesis" in {
      booleanExpression must succeedOn("true and (false or true)")
        .withResult(And(Const("true"), Or(Const("false"), Const("true"))))
    }

    "be valid multiple operators" in {
      booleanExpression must succeedOn("true and true and false and true")
        .withResult(And(And(And(Const("true"), Const("true")), Const("false")), Const("true")))
    }
  }
}
