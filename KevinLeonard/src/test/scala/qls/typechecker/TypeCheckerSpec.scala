package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, NumberType, StringType, Variable}
import ql.typechecker.Error
import qls.ast._
import types.TypeEnvironment

import scala.util.parsing.input.NoPosition

class TypeCheckerSpec extends Specification {
  val checker = new TypeChecker

  val AnyLabel = "label"
  val AnySectionName = "section"
  val EmptyEnvironment: TypeEnvironment = Map()

  "type checker for default widgets" should {
    "return empty list if a correct default widget is used for a type" in {
      val styleSheet = StyleSheet(AnyLabel, List(DefaultWidget(BooleanType(), Widget(CheckBox(), List()))))

      checker.check(styleSheet, EmptyEnvironment) must beEmpty
    }

    "return list with two errors if an incorrect default widget is used for two types" in {
      val styleSheet = StyleSheet(AnyLabel, List(
        DefaultWidget(BooleanType(), Widget(Text(), List())),
        DefaultWidget(NumberType(), Widget(CheckBox(), List()))
      ))
      val errors = List(
        Error("Text widget not allowed for type boolean", Some(NoPosition)),
        Error("Check box widget not allowed for type number", Some(NoPosition))
      )

      checker.check(styleSheet, EmptyEnvironment) must beEqualTo(errors)
    }
  }

  "type checker for section elements" should {
    "return empty list if a correct widget is used for a question" in {
      val question = Question(Variable("x"), Widget(SpinBox(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      checker.check(question, environmentWithQuestion) must beEmpty
    }

    "return list with two errors if two questions with incorrect widget are used" in {
      val section = Section(AnySectionName,
        List(Question(Variable("x"), Widget(SpinBox(), List())), Question(Variable("y"), Widget(SpinBox(), List())))
      )
      val environmentWithQuestion = Map("x" -> BooleanType(), "y" -> BooleanType())
      val errors = List(
        Error("Spin box widget not allowed for type boolean", Some(NoPosition)),
        Error("Spin box widget not allowed for type boolean", Some(NoPosition))
      )

      checker.check(section, environmentWithQuestion) must beEqualTo(errors)
    }
  }

  "type checker for questions" should {
    "return no error if spin box widget is used for a number question" in {
      val question = Question(Variable("x"), Widget(SpinBox(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if spin box widget is used for a non number question" in {
      val question = Question(Variable("x"), Widget(SpinBox(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = Error("Spin box widget not allowed for type boolean", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if slider widget is used for a number question" in {
      val question = Question(Variable("x"), Widget(Slider(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if slider widget is used for a non number question" in {
      val question = Question(Variable("x"), Widget(Slider(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = Error("Slider widget not allowed for type boolean", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if text widget is used for a string question" in {
      val question = Question(Variable("x"), Widget(Text(), List()))
      val environmentWithQuestion = Map("x" -> StringType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return no error if text widget is used for a number question" in {
      val question = Question(Variable("x"), Widget(Text(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if text widget is used for a non number/text question" in {
      val question = Question(Variable("x"), Widget(Text(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = Error("Text widget not allowed for type boolean", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if text block widget is used for a string question" in {
      val question = Question(Variable("x"), Widget(TextBlock(), List()))
      val environmentWithQuestion = Map("x" -> StringType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if text block widget is used for a non string question" in {
      val question = Question(Variable("x"), Widget(TextBlock(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())
      val error = Error("Text block widget not allowed for type boolean", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if radio widget is used for a boolean question" in {
      val question = Question(Variable("x"), Widget(Radio(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if radio widget is used for a non boolean question" in {
      val question = Question(Variable("x"), Widget(Radio(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())
      val error = Error("Radio widget not allowed for type number", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if check box widget is used for a boolean question" in {
      val question = Question(Variable("x"), Widget(CheckBox(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if check box widget is used for a non boolean question" in {
      val question = Question(Variable("x"), Widget(CheckBox(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())
      val error = Error("Check box widget not allowed for type number", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }

    "return no error if drop down widget is used for a boolean question" in {
      val question = Question(Variable("x"), Widget(DropDown(), List()))
      val environmentWithQuestion = Map("x" -> BooleanType())

      checker.check(question, environmentWithQuestion) must beNone
    }

    "return error if drop down widget is used for a non boolean question" in {
      val question = Question(Variable("x"), Widget(DropDown(), List()))
      val environmentWithQuestion = Map("x" -> NumberType())
      val error = Error("Drop down widget not allowed for type number", Some(NoPosition))

      checker.check(question, environmentWithQuestion) must beSome(error)
    }
  }
}
