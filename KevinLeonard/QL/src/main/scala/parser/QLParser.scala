package parser

import ast.QLAST

import scala.util.parsing.combinator.JavaTokenParsers

class QLParser extends JavaTokenParsers with QLAST {
  def form: Parser[Form] = "form" ~> ident ~ expression ^^ {
    case name ~ expr => Form(name, expr)
  }

  def expression: Parser[Expr] = "{" ~> rep(questionExpression | ifExpression) <~ "}" ^^ Sequence

  def questionExpression: Parser[QuestionExpr] = "question" ~> variable ~ label ~ answer ^^ {
    case v ~ label ~ "boolean" => BooleanQuestionExpr(v, label)
    case v ~ label ~ "integer" => IntegerQuestionExpr(v, label)
    case v ~ label ~ "string" => StringQuestionExpr(v, label)
  }

  def answer: Parser[String] = "answer" ~> ("boolean" | "integer" | "string")

  def ifExpression: Parser[IfExpr] = ("if" ~> variable) ~ expression ~ ("else" ~> expression ?) ^^ {
    case v ~ expr1 ~ expr2 => IfExpr(v, expr1, expr2)
  }

  def variable: Parser[Variable] = ident ^^ Variable

  def label: Parser[String] = stringLiteral
}
