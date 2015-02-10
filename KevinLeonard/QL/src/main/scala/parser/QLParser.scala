package parser

import ast.QLAST

import scala.util.parsing.combinator.JavaTokenParsers

class QLParser extends JavaTokenParsers with QLAST {
  
  override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r
  def literal: Parser[Literal] = booleanLiteral | numberLiteral
  def booleanLiteral: Parser[BooleanLiteral] = ("true" | "false") ^^ {
    s => BooleanLiteral(s.toBoolean)
  }
  def numberLiteral: Parser[NumberLiteral] = wholeNumber ^^ {
    s => NumberLiteral(s.toInt)
  }
  def variable: Parser[Variable] = ident ^^ Variable
  def label: Parser[String] = stringLiteral

  def form: Parser[Form] = "form" ~> ident ~ expression ^^ {
    case name ~ expr => Form(name, expr)
  }

  def expression: Parser[Expr] = "{" ~> rep(questionExpression | ifExpression) <~ "}" ^^ Sequence

  // parse questions
  def questionExpression: Parser[QuestionExpr] = "question" ~> variable ~ label ~ answer ^^ {
    // Normal Questions
    case v ~ label ~ (BooleanType ~ None) => BooleanQuestion(v, label)
    case v ~ label ~ (IntegerType ~ None) => IntegerQuestion(v, label)
    case v ~ label ~ (StringType ~ None) => StringQuestion(v, label)
    // Computed Questions
    case v ~ label ~ (BooleanType ~ Some(value)) => ComputedBooleanQuestion(v, label, value)
    case v ~ label ~ (IntegerType ~ Some(value)) => ComputedIntegerQuestion(v, label)
    case v ~ label ~ (StringType ~ Some(value)) => ComputedStringQuestion(v, label)
    case _ => StringQuestion(Variable("NONE"), "NONE")
  }
  // TODO: Check allowed expression for each type.
  def answer = "answer" ~> (booleanAnswer | integerAnswer | stringAnswer)
  def booleanAnswer = ("boolean" ^^^ {BooleanType}) ~ opt("is" ~ "(" ~> (booleanExpression) <~ ")")
  def integerAnswer = ("integer" ^^^ {IntegerType}) ~ opt("is" ~ "(" ~> ("") <~ ")")
  def stringAnswer = ("string" ^^^ {StringType}) ~ opt("is" ~ "(" ~> (stringLiteral) <~ ")")

  // parse if statements
  def ifExpression: Parser[IfExpr] = ("if" ~> variable) ~ expression ~ ("else" ~> expression ?) ^^ {
    case v ~ expr1 ~ expr2 => IfExpr(v, expr1, expr2)
  }

  // parse boolean expression
  def booleanExpression: Parser[Expr] = or
  def or: Parser[Expr] = rep1sep(and, "or") ^^ {
    _.reduceLeft(Or)
  }
  def and: Parser[Expr] = rep1sep(not, "and") ^^ {
    _.reduceLeft(And)
  }
  def not: Parser[Expr] = opt("not") ~ arithmeticExpression ^^ {
    case Some(_) ~ x => Not(x)
    case _ ~ x => x
  }

  // Arithmetic expressions
  def arithmeticExpression: Parser[Expr] = plus
  def plus: Parser[Expr] = rep1sep(minus, "+") ^^ {
    _.reduceLeft(Add)
  }
  def minus: Parser[Expr] = rep1sep(product, "-") ^^ {
    _.reduceLeft(Sub)
  }
  def product: Parser[Expr] = rep1sep(divide, "*") ^^ {
    _.reduceLeft(Mul)
  }
  def divide: Parser[Expr] = rep1sep(atom, "/") ^^ {
    _.reduceLeft(Div)
  }
  def atom: Parser[Expr] = (
    literal
    | variable
    | "(" ~> booleanExpression <~ ")"
    )

}
