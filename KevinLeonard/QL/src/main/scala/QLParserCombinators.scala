package main.scala

import java.io.Serializable

import scala.util.parsing.combinator.JavaTokenParsers
import scala.io.Source

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
      case Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
