package parser

import ast.QLAST

import scala.util.parsing.combinator.JavaTokenParsers

class QLParser extends JavaTokenParsers with QLAST {

  override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r
  def literal: Parser[Literal] = boolean | number | string
  def boolean: Parser[BooleanLiteral] = ("true" | "false") ^^ {
    s => BooleanLiteral(s.toBoolean)
  }
  def number: Parser[NumberLiteral] = wholeNumber ^^ {
    s => NumberLiteral(s.toInt)
  }
  def string: Parser[StringLiteral] = stringLiteral ^^ {
    s => StringLiteral(s)
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
    case v ~ label ~ (IntegerType ~ Some(value)) => ComputedIntegerQuestion(v, label, value)
    case v ~ label ~ (StringType ~ Some(value)) => ComputedStringQuestion(v, label, value)
  }
  def answer = "answer" ~> (booleanAnswer | integerAnswer | stringAnswer)
  def booleanAnswer= ("boolean" ^^^ BooleanType) ~ opt("is" ~ "(" ~> booleanExpression <~ ")")
  def integerAnswer = ("integer" ^^^ IntegerType) ~ opt("is" ~ "(" ~> arithmeticExpression <~ ")")
  def stringAnswer = ("string" ^^^ StringType) ~ opt("is" ~ "(" ~> arithmeticExpression <~ ")")

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
  def not: Parser[Expr] = opt("not") ~ equality ^^ {
    case Some(_) ~ x => Not(x)
    case _ ~ x => x
  }
  def equality: Parser[Expr] = comparison ~ opt(("==" | "!=") ~ comparison) ^^ {
    case l ~ Some("==" ~ r) => Equal(l, r)
    case l ~ Some("!=" ~ r) => NotEqual(l, r)
    case x ~ _ => x
  }
  def comparison: Parser[Expr] = arithmeticExpression ~ opt(("<=" | "<" | ">=" | ">") ~ arithmeticExpression) ^^ {
    case l ~ Some("<=" ~ r) => LessThanEqual(l, r)
    case l ~ Some("<" ~ r) => LessThan(l, r)
    case l ~ Some(">=" ~ r) => GreaterThanEqual(l, r)
    case l ~ Some(">" ~ r) => GreaterThan(l, r)
    case x ~ _ => x
  }

  // Arithmetic expressions
  def arithmeticExpression: Parser[Expr] = sum
  def sum: Parser[Expr] = product ~ rep("+" ~ product | "-" ~ product) ^^ {
    case l ~ xs => xs.foldLeft(l) {
      case (x, "+" ~ y) => Add(x, y)
      case (x, "-" ~ y) => Sub(x, y)
    }
  }
  def product: Parser[Expr] = atom ~ rep("*" ~ atom | "/" ~ atom) ^^ {
    case l ~ xs => xs.foldLeft(l) {
      case (x, "*" ~ y) => Mul(x, y)
      case (x, "/" ~ y) => Div(x, y)
    }
  }
  def atom: Parser[Expr] = literal | variable | "(" ~> booleanExpression <~ ")"

}
