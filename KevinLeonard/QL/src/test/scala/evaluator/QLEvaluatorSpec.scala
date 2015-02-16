package evaluator

import org.specs2.mutable.Specification

class QLEvaluatorSpec extends Specification {
  val evaluators = new QLEvaluator

  import evaluators._

  "evaluation of expressions" should {

  }

  "evaluation of expressions" should {
    "evaluate or expressions" in {
      eval(Or(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(true)
    }

    "evaluate and expressions" in {
      eval(And(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(false)
    }

    "evaluate not expressions" in {
      eval(Not(BooleanLiteral(true))) must beEqualTo(false)
    }

    "evaluate equal expressions on booleans" in {
      eval(Equal(BooleanLiteral(true), BooleanLiteral(true))) must beEqualTo(true)
    }

    "evaluate equal expressions on booleans" in {
      eval(Equal(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(false)
    }

    "evaluate equal expressions on numbers" in {
      eval(Equal(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(true)
    }

    "evaluate equal expressions on numbers" in {
      eval(Equal(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(false)
    }

    "evaluate equal expressions on strings" in {
      eval(Equal(StringLiteral("a"), StringLiteral("a"))) must beEqualTo(true)
    }

    "evaluate equal expressions on strings" in {
      eval(Equal(StringLiteral("a"), StringLiteral("b"))) must beEqualTo(false)
    }

    "evaluate notEqual expressions on booleans" in {
      eval(NotEqual(BooleanLiteral(true), BooleanLiteral(true))) must beEqualTo(false)
    }

    "evaluate notEqual expressions on booleans" in {
      eval(NotEqual(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(true)
    }

    "evaluate notEqual expressions on numbers" in {
      eval(NotEqual(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(false)
    }

    "evaluate notEqual expressions on numbers" in {
      eval(NotEqual(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(true)
    }

    "evaluate notEqual expressions on strings" in {
      eval(NotEqual(StringLiteral("a"), StringLiteral("a"))) must beEqualTo(false)
    }

    "evaluate notEqual expressions on strings" in {
      eval(NotEqual(StringLiteral("a"), StringLiteral("b"))) must beEqualTo(true)
    }

    "evaluate lessThan expressions" in {
      eval(LessThan(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(true)
    }

    "evaluate lessThan expressions" in {
      eval(LessThan(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(false)
    }

    "evaluate lessThan expressions" in {
      eval(LessThan(NumberLiteral(2), NumberLiteral(1))) must beEqualTo(false)
    }

    "evaluate lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(true)
    }

    "evaluate lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(true)
    }

    "evaluate lessThanEqual expressions" in {
      eval(LessThanEqual(NumberLiteral(2), NumberLiteral(1))) must beEqualTo(false)
    }

    "evaluate greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(2), NumberLiteral(1))) must beEqualTo(true)
    }

    "evaluate greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(false)
    }

    "evaluate greaterThan expressions" in {
      eval(GreaterThan(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(false)
    }

    "evaluate greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(true)
    }

    "evaluate greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(2), NumberLiteral(1))) must beEqualTo(true)
    }

    "evaluate greaterThanEqual expressions" in {
      eval(GreaterThanEqual(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(false)
    }

    "evaluate add expressions" in {
      eval(Add(NumberLiteral(1), NumberLiteral(2))) must beEqualTo(3)
    }

    "evaluate sub expressions" in {
      eval(Sub(NumberLiteral(2), NumberLiteral(1))) must beEqualTo(1)
    }

    "evaluate mul expressions" in {
      eval(Mul(NumberLiteral(2), NumberLiteral(3))) must beEqualTo(6)
    }

    "evaluate div expressions" in {
      eval(Div(NumberLiteral(2), NumberLiteral(1))) must beEqualTo(2)
    }

    "evaluate boolean literals" in {
      eval(BooleanLiteral(true)) must beEqualTo(true)
    }

    "evaluate number literals" in {
      eval(NumberLiteral(1)) must beEqualTo(1)
    }

    "evaluate string literals" in {
      eval(StringLiteral("a")) must beEqualTo("a")
    }

    "evaluate nested expressions" in {
      eval(Mul(NumberLiteral(5), Add(NumberLiteral(3), NumberLiteral(2)))) must beEqualTo(25)
    }

    "evaluate multiple nested expressions" in {
      eval(And(Equal(NumberLiteral(7), Add(NumberLiteral(4), Div(NumberLiteral(6), NumberLiteral(2)))), Equal(StringLiteral("a"), StringLiteral("a")))) must beEqualTo(true)
    }
  }

}
