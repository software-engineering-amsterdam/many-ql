package qls.typechecker

import org.specs2.mutable.Specification
import ql.ast.Variable
import qls.ast._

class QuestionsSpec extends Specification {

  val questions = Questions

  val AnyLabel = "label"
  val ExampleStyleSheet = StyleSheet(AnyLabel, List(
    Page(AnyLabel, List(
      Section(AnyLabel, List(
        Question(Variable("var1"), Slider(List())),
        Question(Variable("var2"), Slider(List())),
        Question(Variable("var3"), Slider(List()))
      )),
      Section(AnyLabel, List(
        Question(Variable("var4"), Slider(List())),
        Question(Variable("var5"), Slider(List())),
        Question(Variable("var6"), Slider(List())),
        Section(AnyLabel, List(
          Question(Variable("var7"), Slider(List())),
          Question(Variable("var8"), Slider(List())),
          Question(Variable("var9"), Slider(List()))
        ))
      ))
    ))
  ))

  "Question object" should {
    "return a list with style Questions" in  {
      val result = List(
        Question(Variable("var1"), Slider(List())),
        Question(Variable("var2"), Slider(List())),
        Question(Variable("var3"), Slider(List())),
        Question(Variable("var4"), Slider(List())),
        Question(Variable("var5"), Slider(List())),
        Question(Variable("var6"), Slider(List())),
        Question(Variable("var7"), Slider(List())),
        Question(Variable("var8"), Slider(List())),
        Question(Variable("var9"), Slider(List()))
      )

      Questions.extract(ExampleStyleSheet) must beEqualTo(result)
    }

  }

}
