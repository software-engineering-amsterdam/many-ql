package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.Error
import qls.ast.{Section, Text, Question}
import types.TypeEnvironment

import scala.util.parsing.input.NoPosition

class ReferenceCheckerSpec extends Specification {
  val checker = new ReferenceChecker
  import checker._

  val EmptyEnvironment: TypeEnvironment = Map()

  "reference checker for sections" should {
    "return multiple errors, if multiple questions are defined in QL program" in {
      val sectionWithMultipleQuestion = Section("section", List(Question(Variable("x"), Text(List())), Question(Variable("x"), Text(List()))))
      val errorList = List(new Error("Question x is not defined in your QL program", Some(NoPosition)), new Error("Question x is not defined in your QL program", Some(NoPosition)))

      check(sectionWithMultipleQuestion, EmptyEnvironment) must beEqualTo(errorList)
    }
  }

  "reference checker for questions" should {
    "return no error, if question is defined in QL program" in {
      val question = Question(Variable("x"), Text(List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      check(question, environmentWithQuestion) must beNone
    }

    "return error, if question is not defined in QL program" in {
      val question = Question(Variable("x"), Text(List()))
      val error = new Error("Question x is not defined in your QL program", Some(NoPosition))

      check(question, EmptyEnvironment) must beSome(error)
    }
  }
}
