package main.scala

import scala.util.parsing.combinator.JavaTokenParsers
import scala.io.Source


/*
QL Language description example:

form TaxForm {

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer

    question hasSoldHouse3 "How many houses did you sell in 2014?"
    answer string

    question hasSoldHouse "How many houses did you sell in 2014?"
    answer boolean

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    } else {
        question sellingPrice "What was the selling price?"
        answer integer

        question houseBuyer "To whom did you sell the house?"
        answer string
    }

    if hasSoldHouse {
        question totalHousesSold "How many houses did you sell in 2014?"
        answer integer
    }

    question hasSoldHouse2 "How many houses did you sell in 2014?"
    answer integer
}

 */
class QLParserCombinators extends JavaTokenParsers {

  def form = "form" ~> formName ~ formBlock ^^ { _.toString }
  def formName = ident
  def formBlock = "{" ~> rep(questionBlock | ifStatement) <~ "}"

  def questionBlock = question ~ answer
  def question = "question" ~> questionKey ~ questionLabel ^^ { _.toString() }
  def questionKey = ident
  def questionLabel = stringLiteral

  def answer = "answer" ~> answerType
  def answerType = "boolean" | "integer" | "string"

  def ifStatement = ifBlock ~ elseBlock | ifBlock
  def ifBlock = "if" ~ ident ~ "{" ~> rep(questionBlock) <~ "}"
  def elseBlock = "else" ~ "{" ~> rep(questionBlock) <~ "}"

}

object QLParser extends QLParserCombinators {
  def main(args: Array[String]) {

    val formFile = Source.fromFile(args(0)).mkString

    parseAll(form, formFile) match {
      case Success(r, _) => print(r)
      case x => println(x)
    }
  }
}