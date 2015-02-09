package test.scala

import org.specs2.matcher.ParserMatchers
import org.specs2.mutable.Specification
import parser.QLParser

class QLParserSpec extends Specification with ParserMatchers {
  val parsers = new QLParser

  import parsers._

  "question expressions" should {
    "have a variable, label and type" in {
      questionExpression must succeedOn("question var \"label\"\nanswer string")
        .withResult(new QuestionExpr(new Variable("var"), "\"label\"", "string"))
    }
  }

  "if expressions" should {
    "be valid without an else clause" in {
      ifExpression must succeedOn("if var {}")
        .withResult(new IfExpr(new Variable("var"), new Sequence(List()), None))
    }
  }

  "if expressions" should {
    "be valid with an else clause" in {
      ifExpression must succeedOn("if var {} else {}")
        .withResult(new IfExpr(new Variable("var"), new Sequence(List()), Some(new Sequence(List()))))
    }
  }
}
