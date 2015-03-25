package ql.parser

import ql.ast._

import scala.util.parsing.combinator.JavaTokenParsers

class Parser extends JavaTokenParsers {

  // general parsers
  override val whiteSpace = """(\s|//.*|(?m)/\*(\*(?!/)|[^*])*\*/)+""".r
  def label: Parser[String] = stringLiteral ^^ {
    s => s.substring(1, s.length - 1).replace("\\", "")
  }
  def variable: Parser[Variable] = positioned(ident ^^ Variable)

  // literal parsers
  def literal: Parser[Literal] = boolean | number | string
  def boolean: Parser[BooleanLiteral] = ("true" | "false") ^^ {
    s => BooleanLiteral(BooleanValue(s.toBoolean))
  }
  def number: Parser[NumberLiteral] = wholeNumber ^^ {
    s => NumberLiteral(NumberValue(s.toInt))
  }
  def string: Parser[StringLiteral] = stringLiteral ^^ {
    s => StringLiteral(StringValue(s.substring(1, s.length - 1).replace("\\", "")))
  }

  // form parsers
  def form: Parser[Form] = "form" ~> ident ~ statement ^^ {
    case label ~ statement => Form(label, statement)
  }
  def statement: Parser[Statement] = "{" ~> rep(question | ifStatement) <~ "}" ^^ Sequence

  // question parsers
  def question: Parser[Question] = positioned("question" ~> variable ~ label ~ "answer" ~ questionType ~ opt("is" ~> expression) ^^ {
    case v ~ label ~ "answer" ~ _type ~ e => Question(_type, v, label, e)
  })
  def questionType: Parser[Type] = ("boolean" | "number" | "string") ^^ {
    case "boolean" => BooleanType()
    case "number" => NumberType()
    case "string" => StringType()
  }

  // if statement parsers
  def ifStatement: Parser[IfStatement] = positioned(("if" ~> expression) ~ statement ~ opt("else" ~> statement) ^^ {
    case e ~ s1 ~ s2 => IfStatement(e, s1, s2)
  })

  // boolean and arithmetic expressions parsers
  def expression: Parser[Expression] = positioned(or)
  def or: Parser[Expression] = positioned(rep1sep(and, "or") ^^ {
    _.reduceLeft(Or)
  })
  def and: Parser[Expression] = positioned(rep1sep(not, "and") ^^ {
    _.reduceLeft(And)
  })
  def not: Parser[Expression] = positioned(opt("not") ~ equality ^^ {
    case Some(_) ~ x => Not(x)
    case _ ~ x => x
  })
  def equality: Parser[Expression] = positioned(relational ~ opt(("==" | "!=") ~ relational) ^^ {
    case l ~ Some("==" ~ r) => Equal(l, r)
    case l ~ Some("!=" ~ r) => NotEqual(l, r)
    case x ~ _ => x
  })
  def relational: Parser[Expression] = positioned(sum ~ opt(("<=" | "<" | ">=" | ">") ~ sum) ^^ {
    case l ~ Some("<=" ~ r) => LessThanEqual(l, r)
    case l ~ Some("<" ~ r) => LessThan(l, r)
    case l ~ Some(">=" ~ r) => GreaterThanEqual(l, r)
    case l ~ Some(">" ~ r) => GreaterThan(l, r)
    case x ~ _ => x
  })
  def sum: Parser[Expression] = positioned(product ~ rep("+" ~ product | "-" ~ product) ^^ {
    case l ~ xs => xs.foldLeft(l) {
      case (x, "+" ~ y) => Add(x, y)
      case (x, "-" ~ y) => Sub(x, y)
    }
  })
  def product: Parser[Expression] = positioned(negation ~ rep("*" ~ negation | "/" ~ negation) ^^ {
    case l ~ xs => xs.foldLeft(l) {
      case (x, "*" ~ y) => Mul(x, y)
      case (x, "/" ~ y) => Div(x, y)
    }
  })
  def negation: Parser[Expression] = positioned(opt("-") ~ atom ^^ {
    case Some(_) ~ x => Negation(x)
    case _ ~ x => x
  })
  def atom: Parser[Expression] = positioned(literal | variable | "(" ~> expression <~ ")")
}
