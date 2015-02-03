package main.scala

import scala.util.parsing.combinator.JavaTokenParsers

class QLParserCombinators extends JavaTokenParsers {

  def form = "form" ~> formName ~ "{" ~> rep(question) <~ "}"

  def formName = ident

  def question = questionLabel ~ questionKey ~ questionType

  def questionLabel = stringLiteral

  def questionKey = ident <~ ":"

  def questionType = "boolean" | "string" | "integer"

}

object QLParser extends QLParserCombinators {
  def main(args: Array[String]) {
    parseAll(form, args(0)) match {
      case Success(r, _) => println(r)
      case x => println(x)
    }
  }
}