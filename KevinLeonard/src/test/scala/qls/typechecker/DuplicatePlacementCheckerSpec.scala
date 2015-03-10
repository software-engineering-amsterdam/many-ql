package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.Variable
import ql.typechecker.Error
import qls.ast.{Text, Question, Section}

class DuplicatePlacementCheckerSpec extends Specification {
  val checker = new DuplicatePlacementChecker
  import checker._

  "duplicate placement checker" should {
    "return no error if no question is placed multiple times" in {
      val sectionWithQuestions = Section("section", List(Question(Variable("x"), Text(List())), Question(Variable("y"), Text(List()))), List())

      check(sectionWithQuestions) must beEmpty
    }

    "return one error if one question is placed multiple times" in {
      val sectionWithQuestions = Section("section", List(Question(Variable("x"), Text(List())), Question(Variable("x"), Text(List())), Question(Variable("y"), Text(List()))), List())
      val errors = List(new Error("Question x is placed 2 times"))

      check(sectionWithQuestions) must beEqualTo(errors)
    }

    "return multiple errors if multiple questions are placed multiple times" in {
      val sectionWithQuestions = Section("section", List(Question(Variable("x"), Text(List())), Question(Variable("x"), Text(List())), Question(Variable("y"), Text(List())), Question(Variable("y"), Text(List()))), List())
      val errors = List(new Error("Question y is placed 2 times"), new Error("Question x is placed 2 times"))

      check(sectionWithQuestions) must beEqualTo(errors)
    }
  }
}
