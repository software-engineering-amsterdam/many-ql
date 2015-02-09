package main.scala

import ast.QLAST

import scala.io.Source
import scala.util.parsing.combinator.JavaTokenParsers

class QLParserCombinators extends JavaTokenParsers with QLAST {

  def form: Parser[String] = "form" ~> formName ~ expression ^^ { _.toString }
  def formName: Parser[String] = ident

  def expression: Parser[Expr] = "{" ~> rep(questionExpression | ifExpression) <~ "}" ^^ Sequence

  def questionExpression : Parser[QuestionExpr] = "question" ~> variable ~ questionLabel ~ answer ^^ { case v~label~_type => QuestionExpr(v, label, _type) }
  def questionLabel : Parser[String] = stringLiteral
  def answer : Parser[String] = "answer" ~> answerType
  def answerType : Parser[String] = "boolean" | "integer" | "string"

  def ifExpression: Parser[IfExpr] = ("if" ~> variable) ~ expression ~ ("else" ~> expression?) ^^ { case v~e1~e2 => IfExpr(v, e1, e2) }

  def variable : Parser[Variable] = ident ^^ Variable

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
