package ql.typechecker

import ql.ast._
import org.specs2.mutable.Specification

class DuplicateLabelsCheckerSpec extends Specification {

  val checker = new DuplicateLabelsChecker
  import checker._

  "duplicate labels checker" should {
    "detect duplicate label" in {
      
      val form = new Form("form", Sequence(List(
        Question(BooleanType(), Variable("X"), "label", None),
        Question(BooleanType(), Variable("Y"), "label", None),
        Question(BooleanType(), Variable("Z"), "label", None),
        Question(BooleanType(), Variable("A"), "label2", None),
        Question(BooleanType(), Variable("B"), "label2", None)
      )))
      val result = List(new Warning("Label \'label2\' is used 2 times"), new Warning("Label \'label\' is used 3 times"))

      check(form) must beEqualTo(result)
    }
  }

}
