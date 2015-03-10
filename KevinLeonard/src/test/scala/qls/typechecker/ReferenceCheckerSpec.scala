package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Variable}
import ql.typechecker.{Error, TypeEnvironment}
import qls.ast.{Text, Question}

import scala.util.parsing.input.NoPosition

class ReferenceCheckerSpec extends Specification {
  val checker = new ReferenceChecker
  import checker._

  "question" should {
    "return no error if question is defined in QL program" in {
      check(Question(Variable("x"), Text(List())), new TypeEnvironment(Map("x" -> BooleanType()))) must beNone
    }

    "return error if question is not defined in QL program" in {
      check(Question(Variable("x"), Text(List())), new TypeEnvironment()) must beSome(new Error("Variable x is not defined", NoPosition))
    }
  }
}
