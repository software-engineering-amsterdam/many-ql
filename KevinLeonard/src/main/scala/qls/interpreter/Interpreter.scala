package qls.interpreter

import ql.interpreter.{Interpreter => QLInterpreter}
import qls.ast.StyleSheet
import qls.parser.Parser
import qls.typechecker.TypeChecker
import types.TypeEnvironment

import scala.io.Source

object Interpreter {

  def main(args: Array[String]) {
    val qlSource = Source.fromFile(args(0)).mkString
    val qlsSource = Source.fromFile(args(1)).mkString

    val optionalQlAst = QLInterpreter.parse(qlSource)
    val optionalQlsAst = parse(qlsSource)

    (optionalQlAst, optionalQlsAst) match {
      case (Some(qlAst), Some(qlsAst)) =>
        val result = QLInterpreter.checkTypes(qlAst)
        val qlTypeChecks = result._1.isEmpty
        val qlsTypeChecks = checkTypes(qlsAst, result._2)

        if (qlTypeChecks && qlsTypeChecks) {
          QLInterpreter.render(qlAst)
        }
      case _ => ()
    }
  }

  def parse(source: String): Option[StyleSheet] = {
    val parser = new Parser()

    parser.parseAll(parser.style, source) match {
      case parser.Success(ast: StyleSheet, _) => Some(ast)
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg); None
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg); None
    }
  }

  def checkTypes(ast: StyleSheet, env: TypeEnvironment): Boolean = {
    // TODO: add all four type checkers
    val typeChecker = new TypeChecker()

    val errors = typeChecker.check(ast, env)

    errors.foreach(println)

    errors.isEmpty
  }
}
