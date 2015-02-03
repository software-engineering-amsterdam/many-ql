package main.scala

import java.io.Serializable

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

  def form : Parser[String] = "form" ~> formName ~ formBlock ^^ { _.toString }
  def formName : Parser[String] = ident
  def formBlock : Parser[String] = "{" ~> rep(questionBlock | ifStatement) <~ "}" ^^ { _.toString }

  def questionBlock : Parser[String] = question ~ answer ^^ { _.toString }
  def question : Parser[String] = "question" ~> questionKey ~ questionLabel ^^ { _.toString() }
  def questionKey : Parser[String] = ident
  def questionLabel : Parser[String] = stringLiteral

  def answer : Parser[String] = "answer" ~> answerType
  def answerType : Parser[String] = "boolean" | "integer" | "string"

  def ifStatement : Parser[Serializable] = ifBlock ~ elseBlock | ifBlock
  def ifBlock : Parser[String] = "if" ~ ident ~ "{" ~> rep(questionBlock) <~ "}" ^^ { _.toString }
  def elseBlock : Parser[String] = "else" ~ "{" ~> rep(questionBlock) <~ "}" ^^ { _.toString }

}

object QLParser extends QLParserCombinators {
  def main(args: Array[String]) {

    val formFile = Source.fromFile(args(0)).mkString

    parseAll(form, formFile) match {
      case Success(result, _) => println(result)
      case Failure(msg, _) => println(msg)
      case Error(msg, _) => println(msg)
    }
  }
}
