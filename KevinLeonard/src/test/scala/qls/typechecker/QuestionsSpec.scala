package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.Variable
import qls.ast._

class QuestionsSpec extends Specification {
  val questions = Questions

  val AnyLabel = "label"

  "questions extractor" should {
    "return a list with questions" in  {
      val exampleStyleSheet = StyleSheet(AnyLabel, List(
        Page(AnyLabel, List(
          Section(AnyLabel, List(
            Question(Variable("var1"), Widget(Slider(), List())),
            Question(Variable("var2"), Widget(Slider(), List())),
            Question(Variable("var3"), Widget(Slider(), List()))
          )),
          Section(AnyLabel, List(
            Question(Variable("var4"), Widget(Slider(), List())),
            Question(Variable("var5"), Widget(Slider(), List())),
            Question(Variable("var6"), Widget(Slider(), List())),
            Section(AnyLabel, List(
              Question(Variable("var7"), Widget(Slider(), List())),
              Question(Variable("var8"), Widget(Slider(), List())),
              Question(Variable("var9"), Widget(Slider(), List()))
            ))
          ))
        ))
      ))
      val result = List(
        Question(Variable("var1"), Widget(Slider(), List())),
        Question(Variable("var2"), Widget(Slider(), List())),
        Question(Variable("var3"), Widget(Slider(), List())),
        Question(Variable("var4"), Widget(Slider(), List())),
        Question(Variable("var5"), Widget(Slider(), List())),
        Question(Variable("var6"), Widget(Slider(), List())),
        Question(Variable("var7"), Widget(Slider(), List())),
        Question(Variable("var8"), Widget(Slider(), List())),
        Question(Variable("var9"), Widget(Slider(), List()))
      )

      Questions.extract(exampleStyleSheet) must beEqualTo(result)
    }
  }
}
