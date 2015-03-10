package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.Error
import qls.ast.{Question, Section, Text}

class QuestionPlacementCheckerSpec extends Specification {
  val checker = new QuestionPlacementChecker()
  import checker._

  val EmptySection = Section("section", List(), List())

  "all question placed checker" should {
    "return None if all questions are placed" in {
      val sectionWithQuestion = Section("section", List(Question(Variable("x"), Text(List()))), List())
      val environmentWithQuestion = Map("x" -> BooleanType())

      check(sectionWithQuestion, environmentWithQuestion) should beNone
    }

    "return Some with one error, if one question isn't placed" in {
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = new Error(s"The question(s) x are not placed")

      check(EmptySection, environmentWithQuestion) should beSome(error)
    }

    "return Some with one error, if multiple questions aren't placed" in {
      val environmentWithMultipleQuestions = Map("x" -> BooleanType(), "y" -> BooleanType())
      val error = new Error(s"The question(s) x, y are not placed")

      check(EmptySection, environmentWithMultipleQuestions) should beSome(error)
    }
  }
}
