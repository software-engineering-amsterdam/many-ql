package parser

import ast.QLAST

import scala.util.parsing.combinator.JavaTokenParsers

class QLParser extends JavaTokenParsers with QLAST {

  // Basic
  override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r
  def const: Parser[Const] = ("true" | "false") ^^ Const
  def variable: Parser[Variable] = ident ^^ Variable
  def label: Parser[String] = stringLiteral

  // Form
  def form: Parser[Form] = "form" ~> ident ~ expression ^^ {
    case name ~ expr => Form(name, expr)
  }
  def expression: Parser[Expr] = "{" ~> rep(questionExpression | ifExpression) <~ "}" ^^ Sequence

  // Questions
  def questionExpression: Parser[QuestionExpr] = "question" ~> variable ~ label ~ answer ^^ {
    case v ~ label ~ "boolean" => BooleanQuestion(v, label)
    case v ~ label ~ "integer" => IntegerQuestion(v, label)
    case v ~ label ~ "string" => StringQuestion(v, label)
  }
  def answer: Parser[String] = "answer" ~> ("boolean" | "integer" | "string")

  // If statements
  def ifExpression: Parser[IfExpr] = ("if" ~> variable) ~ expression ~ ("else" ~> expression?) ^^ {
    case v ~ expr1 ~ expr2 => IfExpr(v, expr1, expr2)
  }

  // Boolean expression
  def booleanExpression: Parser[Expr] = or
  def or: Parser[Expr] = rep1sep(and, "or") ^^ {
    _.reduceLeft(Or)
  }
  def and: Parser[Expr] = rep1sep(not, "and") ^^ {
    _.reduceLeft(And)
  }
  def not: Parser[Expr] = opt("not") ~ atom ^^ {
    case Some(_) ~ x => Not(x)
    case _ ~ x => x
  }
  def atom: Parser[Expr] = (
    const
    | variable
    | "(" ~> booleanExpression <~ ")"
    )

}
