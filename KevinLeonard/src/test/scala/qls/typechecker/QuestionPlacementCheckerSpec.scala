package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.Error
import qls.ast.{Page, Question, Section, StyleSheet, Text}

class QuestionPlacementCheckerSpec extends Specification {
  val checker = new QuestionPlacementChecker()
  import checker._

  val AnyLabel = "label"
  val AnyVariable = Variable("x")
  val EmptyStyleSheet = StyleSheet(AnyLabel, List(Page(AnyLabel, List(Section(AnyLabel, List())))))

  "all question placed checker" should {
    "return None if all questions are placed" in {
      val sectionWithQuestion = StyleSheet(AnyLabel, List(Page(AnyLabel, List(
        Section(AnyLabel, List(Question(Variable("x"), Text(List())))),
        Section(AnyLabel, List(Section(AnyLabel, List(Question(Variable("y"), Text(List()))))))
      ))))
      val environmentWithQuestion = Map("x" -> BooleanType(), "y" -> BooleanType())

      check(sectionWithQuestion, environmentWithQuestion) should beNone
    }

    "return Some with one error, if one question isn't placed" in {
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = Error(s"The question(s) x are not placed")

      check(EmptyStyleSheet, environmentWithQuestion) should beSome(error)
    }

    "return Some with one error, if multiple questions aren't placed" in {
      val environmentWithMultipleQuestions = Map("x" -> BooleanType(), "y" -> BooleanType())
      val error = Error(s"The question(s) x, y are not placed")

      check(EmptyStyleSheet, environmentWithMultipleQuestions) should beSome(error)
    }
  }
}
