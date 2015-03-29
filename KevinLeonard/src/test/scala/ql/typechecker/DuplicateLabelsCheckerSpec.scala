package ql.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Form, Question, Sequence, Variable}

class DuplicateLabelsCheckerSpec extends Specification {

  val checker = new DuplicateLabelsChecker

  "duplicate labels checker" should {
    "detect duplicate label" in {
      val aLabel = "label1"
      val anotherLabel = "label2"
      val form = Form("form", Sequence(List(
        Question(BooleanType(), Variable("X"), aLabel, None),
        Question(BooleanType(), Variable("Y"), aLabel, None),
        Question(BooleanType(), Variable("Z"), aLabel, None),
        Question(BooleanType(), Variable("A"), anotherLabel, None),
        Question(BooleanType(), Variable("B"), anotherLabel, None)
      )))
      val result = List(
        Warning(s"Label \'$anotherLabel\' is used 2 times"),
        Warning(s"Label \'$aLabel\' is used 3 times")
      )

      checker.check(form) must beEqualTo(result)
    }
  }
}
