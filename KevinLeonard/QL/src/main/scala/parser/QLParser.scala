package parser

import ast.QLAST

import scala.util.parsing.combinator.JavaTokenParsers

class QLParser extends JavaTokenParsers with QLAST {

  // general parsers
  override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r
  def label: Parser[String] = stringLiteral
  def variable: Parser[Variable] = ident ^^ Variable

  // literal parsers
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

  // form parsers
  def form: Parser[Form] = "form" ~> ident ~ statement ^^ {
    case label ~ statement => Form(label, statement)
  }
  def statement: Parser[Statement] = "{" ~> rep(question | ifStatement) <~ "}" ^^ Sequence

  // question parsers
  def question: Parser[Question] = "question" ~> variable ~ label ~ questionType ~ opt("is" ~ "(" ~> expression <~ ")") ^^ {
    case v ~ label ~ BooleanType() ~ None => BooleanQuestion(v, label)
    case v ~ label ~ BooleanType() ~ Some(value) => ComputedBooleanQuestion(v, label, value)
    case v ~ label ~ IntegerType() ~ None => IntegerQuestion(v, label)
    case v ~ label ~ IntegerType() ~ Some(value) => ComputedIntegerQuestion(v, label, value)
    case v ~ label ~ StringType() ~ None => StringQuestion(v, label)
    case v ~ label ~ StringType() ~ Some(value) => ComputedStringQuestion(v, label, value)
  }
  def questionType: Parser[QuestionType] = "answer" ~> ("boolean" ^^^ BooleanType() | "integer" ^^^ IntegerType() | "string" ^^^ StringType())

  // if statement parsers
  def ifStatement: Parser[IfStatement] = ("if" ~> expression) ~ statement ~ opt("else" ~> statement) ^^ {
    case e ~ s1 ~ s2 => IfStatement(e, s1, s2)
  }

  // boolean and arithmetic expressions parsers
  def expression: Parser[Expression] = or
  def or: Parser[Expression] = rep1sep(and, "or") ^^ {
    _.reduceLeft(Or)
  }
  def and: Parser[Expression] = rep1sep(not, "and") ^^ {
    _.reduceLeft(And)
  }
  def not: Parser[Expression] = opt("not") ~ equality ^^ {
    case Some(_) ~ x => Not(x)
    case _ ~ x => x
  }
  def equality: Parser[Expression] = comparison ~ opt(("==" | "!=") ~ comparison) ^^ {
    case l ~ Some("==" ~ r) => Equal(l, r)
    case l ~ Some("!=" ~ r) => NotEqual(l, r)
    case x ~ _ => x
  }
  def comparison: Parser[Expression] = sum ~ opt(("<=" | "<" | ">=" | ">") ~ sum) ^^ {
    case l ~ Some("<=" ~ r) => LessThanEqual(l, r)
    case l ~ Some("<" ~ r) => LessThan(l, r)
    case l ~ Some(">=" ~ r) => GreaterThanEqual(l, r)
    case l ~ Some(">" ~ r) => GreaterThan(l, r)
    case x ~ _ => x
  }
  def sum: Parser[Expression] = product ~ rep("+" ~ product | "-" ~ product) ^^ {
    case l ~ xs => xs.foldLeft(l) {
      case (x, "+" ~ y) => Add(x, y)
      case (x, "-" ~ y) => Sub(x, y)
    }
  }
  def product: Parser[Expression] = atom ~ rep("*" ~ atom | "/" ~ atom) ^^ {
    case l ~ xs => xs.foldLeft(l) {
      case (x, "*" ~ y) => Mul(x, y)
      case (x, "/" ~ y) => Div(x, y)
    }
  }
  def atom: Parser[Expression] = literal | variable | "(" ~> expression <~ ")"

}
