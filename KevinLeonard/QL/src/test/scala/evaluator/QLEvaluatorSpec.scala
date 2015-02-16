package evaluator

import org.specs2.mutable.Specification

class QLEvaluatorSpec extends Specification {
  val evals = new QLEvaluator

  import evals._

  "eval of expressions" should {
    "evaluate or expressions" in {
      evals.eval(Or(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(true)
    }

    "evaluate and expressions" in {
      evals.eval(And(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(false)
    }
  }

}
