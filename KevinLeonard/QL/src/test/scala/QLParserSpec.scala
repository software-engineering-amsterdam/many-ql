package test.scala

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import parser.QLParser

class QLParserSpec extends Specification with ParserMatchers {
  val parsers = new QLParser

  import parsers._

  "boolean question expressions" should {
    "have a variable and label" in {
      questionExpression must succeedOn("question var \"label\"\nanswer boolean")
        .withResult(BooleanQuestionExpr(Variable("var"), "\"label\""))
    }
  }

  "integer question expressions" should {
    "have a variable and label" in {
      questionExpression must succeedOn("question var \"label\"\nanswer integer")
        .withResult(IntegerQuestionExpr(Variable("var"), "\"label\""))
    }
  }

  "string question expressions" should {
    "have a variable and label" in {
      questionExpression must succeedOn("question var \"label\"\nanswer string")
        .withResult(StringQuestionExpr(Variable("var"), "\"label\""))
    }
  }

  "if expressions" should {
    "be valid without an else clause" in {
      ifExpression must succeedOn("if var {}")
        .withResult(IfExpr(Variable("var"), Sequence(List()), None))
    }
  }

  "if expressions" should {
    "be valid with an else clause" in {
      ifExpression must succeedOn("if var {} else {}")
        .withResult(IfExpr(Variable("var"), Sequence(List()), Some(Sequence(List()))))
    }
  }
}
