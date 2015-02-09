package parser

import ast.QLAST

import scala.util.parsing.combinator.JavaTokenParsers

class QLParser extends JavaTokenParsers with QLAST {

  def form: Parser[Expr] = "form" ~> formName ~ expression ^^ { case name~expr => Form(name, expr) }
  def formName: Parser[String] = ident

  def expression: Parser[Expr] = "{" ~> rep(questionExpression | ifExpression) <~ "}" ^^ Sequence

  def questionExpression : Parser[QuestionExpr] = "question" ~> variable ~ questionLabel ~ answer ^^ { case v~label~_type => QuestionExpr(v, label, _type) }
  def questionLabel : Parser[String] = stringLiteral
  def answer : Parser[String] = "answer" ~> answerType
  def answerType : Parser[String] = "boolean" | "integer" | "string"

  def ifExpression: Parser[IfExpr] = ("if" ~> variable) ~ expression ~ ("else" ~> expression?) ^^ { case v~e1~e2 => IfExpr(v, e1, e2) }

  def variable : Parser[Variable] = ident ^^ Variable

}
