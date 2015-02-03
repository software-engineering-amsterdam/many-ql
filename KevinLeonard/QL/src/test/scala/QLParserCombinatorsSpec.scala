package test.scala

import org.specs2.mutable.Specification


class QLParserCombinatorsSpec extends Specification {

  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world" must have size (11)
    }
  }

}
