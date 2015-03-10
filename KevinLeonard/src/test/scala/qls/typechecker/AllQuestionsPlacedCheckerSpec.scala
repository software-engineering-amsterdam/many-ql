package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.{Error, TypeEnvironment}
import qls.ast.{Text, Question, Section}

import scala.util.parsing.input.NoPosition

class AllQuestionsPlacedCheckerSpec extends Specification {
  val checker = new AllQuestionsPlacedChecker()
  import checker._

  val emptySection = Section("section", List(), List())

  "all question placed checker" should {
    "return None if all questions are placed" in {
      val sectionWithQuestion = Section("section", List(Question(Variable("x"), Text(List()))), List())
      val environmentWithQuestion = new TypeEnvironment(Map("x" -> BooleanType()))

      check(sectionWithQuestion, environmentWithQuestion) should beNone
    }

    "return Some with one error, if one question isn't placed" in {
      val environmentWithQuestion = new TypeEnvironment(Map("x" -> BooleanType()))
      val error = new Error(s"The question(s) x are not placed", NoPosition)

      check(emptySection, environmentWithQuestion) should beSome(error)
    }

    "return Some with one error, if multiple questions aren't placed" in {
      val environmentWithMultipleQuestions = new TypeEnvironment(Map("x" -> BooleanType(), "y" -> BooleanType()))
      val error = new Error(s"The question(s) x, y are not placed", NoPosition)

      check(emptySection, environmentWithMultipleQuestions) should beSome(error)
    }
  }
}
