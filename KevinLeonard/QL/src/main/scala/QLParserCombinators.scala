package main.scala

import scala.util.parsing.combinator.JavaTokenParsers

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
class QLFormParser extends JavaTokenParsers {

  def form = "form" ~> formName ~ formBlock
  def formName = ident
  def formBlock = "{" ~> rep(questionBlock | ifStatement) <~ "}"

  def questionBlock = question ~ answer
  def question = "question" ~> questionKey ~ questionLabel
  def questionKey = ident
  def questionLabel = stringLiteral

  def answer = "answer" ~> answerType
  def answerType = "boolean" | "integer" | "string"

  def ifStatement = ifBlock ~ elseBlock | ifBlock
  def ifBlock = "if" ~ ident ~ "{" ~> rep(questionBlock) <~ "}"
  def elseBlock = "else" ~ "{" ~> rep(questionBlock) <~ "}"

}

object QLParser extends QLFormParser {
  def main(args: Array[String]) {

    val formFile = scala.io.Source.fromFile(args(0)).mkString

    parseAll(form, formFile) match {
      case Success(r, _) => print(r)
      case x => println(x)
    }
  }
}