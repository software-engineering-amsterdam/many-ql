package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.Variable
import ql.typechecker.Error
import qls.ast._

class DuplicatePlacementCheckerSpec extends Specification {
  val checker = new DuplicatePlacementChecker

  val AnyLabel = "label"

  "duplicate placement checker" should {
    "return no error if no question is placed multiple times" in {
      val styleSheetWithQuestions = StyleSheet(AnyLabel, List(Page(AnyLabel, List(
        Section("section", List(Question(Variable("x"), Widget(Text(), List())), Question(Variable("y"), Widget(Text(), List()))))
      ))))

      checker.check(styleSheetWithQuestions) must beEmpty
    }

    "return one error if one question is placed multiple times" in {
      val styleSheetWithQuestions = StyleSheet(AnyLabel, List(Page(AnyLabel, List(Section("section", List(
        Question(Variable("x"), Widget(Text(), List())),
        Question(Variable("x"), Widget(Text(), List())),
        Question(Variable("y"), Widget(Text(), List()))
      ))))))
      val errors = List(Error("Question x is placed 2 times"))

      checker.check(styleSheetWithQuestions) must beEqualTo(errors)
    }

    "return multiple errors if multiple questions are placed multiple times" in {
      val styleSheetWithQuestions = StyleSheet(AnyLabel, List(Page(AnyLabel, List(Section("section", List(
        Question(Variable("x"), Widget(Text(), List())),
        Question(Variable("x"), Widget(Text(), List())),
        Question(Variable("y"), Widget(Text(), List())),
        Question(Variable("y"), Widget(Text(), List()))
      ))))))
      val errors = List(Error("Question y is placed 2 times"), Error("Question x is placed 2 times"))

      checker.check(styleSheetWithQuestions) must beEqualTo(errors)
    }
  }
}
