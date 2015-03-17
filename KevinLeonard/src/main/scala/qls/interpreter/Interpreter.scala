package qls.interpreter

import ql.interpreter.{Interpreter => QLInterpreter}

import qls.ast.Style
import qls.parser.Parser

import scala.io.Source

object Interpreter {

  def main(args: Array[String]) {
    val qlSource = Source.fromFile(args(0)).mkString
    val qlsSource = Source.fromFile(args(1)).mkString

    val optionalQlAst = QLInterpreter.parse(qlSource)
    val optionalQlsAst = parse(qlsSource)
    (optionalQlAst, optionalQlsAst) match {
      case (Some(qlAst), Some(qlsAst)) =>
        val qlTypeChecks = QLInterpreter.checkTypes(qlAst)
        val qlsTypeChecks = checkTypes(qlsAst)
        if (qlTypeChecks && qlsTypeChecks) {
          QLInterpreter.render(qlAst)
        }
      case _ => ()
    }
  }

  def parse(source: String): Option[Style] = {
    val parser = new Parser()

    parser.parseAll(parser.style, source) match {
      case parser.Success(ast: Style, _) => Some(ast)
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg); None
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg); None
    }
  }

  def checkTypes(ast: Style): Boolean = {
    // TODO: add all four type checkers
    true
  }
}
