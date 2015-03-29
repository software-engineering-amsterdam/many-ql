package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.Error
import qls.ast._

class QuestionPlacementCheckerSpec extends Specification {
  val checker = new QuestionPlacementChecker()

  val AnyLabel = "label"
  val AnyVariable = Variable("x")
  val EmptyStyleSheet = StyleSheet(AnyLabel, List(Page(AnyLabel, List(Section(AnyLabel, List())))))

  "all question placed checker" should {
    "return None if all questions are placed" in {
      val styleSheetWithQuestions = StyleSheet(AnyLabel, List(Page(AnyLabel, List(
        Section(AnyLabel, List(Question(Variable("x"), Widget(Text(), List())))),
        Section(AnyLabel, List(Section(AnyLabel, List(Question(Variable("y"), Widget(Text(), List()))))))
      ))))
      val environmentWithQuestion = Map("x" -> BooleanType(), "y" -> BooleanType())

      checker.check(styleSheetWithQuestions, environmentWithQuestion) should beNone
    }

    "return Some with one error, if one question isn't placed" in {
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = Error(s"The question(s) x are not placed")

      checker.check(EmptyStyleSheet, environmentWithQuestion) should beSome(error)
    }

    "return Some with one error, if multiple questions aren't placed" in {
      val environmentWithMultipleQuestions = Map("x" -> BooleanType(), "y" -> BooleanType())
      val error = Error(s"The question(s) x, y are not placed")

      checker.check(EmptyStyleSheet, environmentWithMultipleQuestions) should beSome(error)
    }
  }
}
