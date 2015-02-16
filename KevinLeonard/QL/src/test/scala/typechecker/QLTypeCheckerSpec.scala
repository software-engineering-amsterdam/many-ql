package typechecker

import ast.QLAST._
import org.specs2.matcher.ExceptionMatchers
import org.specs2.mutable.Specification

class QLTypeCheckerSpec extends Specification with ExceptionMatchers {
  val checkers = new QLTypeChecker
  import checkers._
  
  "literals" should {
    "BooleanLiteral" in {
      check(BooleanLiteral(true)) must beEqualTo(BooleanLiteral(true))
    }
    "NumberLiteral" in {
      check(NumberLiteral(10)) must beEqualTo(NumberLiteral(1))
    }
    "StringLiteral" in {
      check(StringLiteral("Test")) must beEqualTo(StringLiteral(""))
    }
  }

  "OR expressions" should {
    "be true (both boolean literals)" in {
      check(Or(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(BooleanLiteral(true))
    }
    "be true (an expression and a boolean literal)" in {
      check(Or(Or(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false))) must beEqualTo(BooleanLiteral(true))
    }
    "be false (an string literal and a number literal)" in {
      check(Or(StringLiteral("Test"), NumberLiteral(100))) must throwA[RuntimeException](message = "Invalid OR expression")
    }
  }

  "AND expressions" should {
    "be true (both boolean literals)" in {
      check(And(BooleanLiteral(true), BooleanLiteral(false))) must beEqualTo(BooleanLiteral(true))
    }
    "be true (an expression and a boolean literal)" in {
      check(And(And(BooleanLiteral(true), BooleanLiteral(false)), BooleanLiteral(false))) must beEqualTo(BooleanLiteral(true))
    }
    "be false (an string literal and a number literal)" in {
      check(And(StringLiteral("Test"), NumberLiteral(100))) must throwA[RuntimeException](message = "Invalid AND expression")
    }
  }

  "NOT expressions" should {
    "be true" in {
      check(Not(BooleanLiteral(true))) must beEqualTo(BooleanLiteral(true))
    }
    "be false" in {
      check(Not(StringLiteral("")))  must throwA[RuntimeException](message = "Invalid NOT expression")
    }
  }

  "EQUAL expressions" should {
    "booleans be true" in {
      check(Equal(BooleanLiteral(true), BooleanLiteral(true))) must beEqualTo(BooleanLiteral(true))
    }
    "numbers be true" in {
      check(Equal(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings true" in {
      check(Equal(StringLiteral(""), StringLiteral(""))) must beEqualTo(BooleanLiteral(true))
    }
    "two different types be false" in {
      check(Equal(StringLiteral(""), BooleanLiteral(true))) must throwA[RuntimeException](message = "Invalid EQUAL expression")
    }
  }

  "NOT EQUAL expressions" should {
    "booleans be true" in {
      check(NotEqual(BooleanLiteral(true), BooleanLiteral(true))) must beEqualTo(BooleanLiteral(true))
    }
    "numbers be true" in {
      check(NotEqual(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be true" in {
      check(NotEqual(StringLiteral(""), StringLiteral(""))) must beEqualTo(BooleanLiteral(true))
    }
    "two different types be false" in {
      check(NotEqual(StringLiteral(""), BooleanLiteral(true))) must throwA[RuntimeException](message = "Invalid NOT EQUAL expression")
    }
  }

  "LESS THAN expressions" should {
    "numbers be true" in {
      check(LessThan(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(LessThan(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid LESS THAN expression")
    }
    "booleans be false" in {
      check(LessThan(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid LESS THAN expression")
    }
  }

  "LESS THAN EQUAL expressions" should {
    "numbers be true" in {
      check(LessThanEqual(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(LessThanEqual(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid LESS THAN EQUAL expression")
    }
    "booleans be false" in {
      check(LessThanEqual(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid LESS THAN EQUAL expression")
    }
  }

  "GREATER THAN expressions" should {
    "numbers be true" in {
      check(GreaterThan(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(GreaterThan(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid GREATER THAN expression")
    }
    "booleans be false" in {
      check(GreaterThan(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid GREATER THAN expression")
    }
  }

  "GREATER THAN EQUAL expressions" should {
    "numbers be true" in {
      check(GreaterThanEqual(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(GreaterThanEqual(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid GREATER THAN EQUAL expression")
    }
    "booleans be false" in {
      check(GreaterThanEqual(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid GREATER THAN EQUAL expression")
    }
  }

  "ADD expressions" should {
    "numbers be true" in {
      check(Add(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(Add(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid ADD expression")
    }
    "booleans be false" in {
      check(Add(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid ADD expression")
    }
  }

  "SUB expressions" should {
    "numbers be true" in {
      check(Sub(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(Sub(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid SUB expression")
    }
    "booleans be false" in {
      check(Sub(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid SUB expression")
    }
  }

  "MUL expressions" should {
    "numbers be true" in {
      check(Mul(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(Mul(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid MUL expression")
    }
    "booleans be false" in {
      check(Mul(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid MUL expression")
    }
  }

  "DIV expressions" should {
    "numbers be true" in {
      check(Div(NumberLiteral(1), NumberLiteral(1))) must beEqualTo(BooleanLiteral(true))
    }
    "strings be false" in {
      check(Div(StringLiteral(""), StringLiteral(""))) must throwA[RuntimeException](message = "Invalid DIV expression")
    }
    "booleans be false" in {
      check(Div(BooleanLiteral(true), BooleanLiteral(false))) must throwA[RuntimeException](message = "Invalid DIV expression")
    }
  }

}