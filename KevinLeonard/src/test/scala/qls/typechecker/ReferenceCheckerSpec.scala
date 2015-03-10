package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.{Error, TypeEnvironment}
import qls.ast.{Section, Text, Question}

import scala.util.parsing.input.NoPosition

class ReferenceCheckerSpec extends Specification {
  val checker = new ReferenceChecker
  import checker._

  val EmptyEnvironment = new TypeEnvironment()

  "reference checker for sections" should {
    "return multiple errors, if multiple questions are defined in QL program" in {
      val sectionWithMultipleQuestion = Section("section", List(Question(Variable("x"), Text(List())), Question(Variable("x"), Text(List()))), List())
      val errorList = List(new Error("Variable x is not defined", NoPosition), new Error("Variable x is not defined", NoPosition))

      check(sectionWithMultipleQuestion, EmptyEnvironment) must beEqualTo(errorList)
    }
  }

  "reference checker for questions" should {
    "return no error, if question is defined in QL program" in {
      val question = Question(Variable("x"), Text(List()))
      val environmentWithQuestion = new TypeEnvironment(Map("x" -> BooleanType()))

      check(question, environmentWithQuestion) must beNone
    }

    "return error, if question is not defined in QL program" in {
      val question = Question(Variable("x"), Text(List()))
      val error = new Error("Variable x is not defined", NoPosition)

      check(question, EmptyEnvironment) must beSome(error)
    }
  }
}
