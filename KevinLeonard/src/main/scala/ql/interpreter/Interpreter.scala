package ql.interpreter

import ql.ast.Form
import ql.gui.FormBuilder
import ql.parser.Parser
import ql.typechecker.{DuplicateLabelsChecker, Error, TypeChecker}
import types.TypeEnvironment

import scala.io.Source

object Interpreter {

  def main(args: Array[String]) {
    val source = Source.fromFile(args(0)).mkString

    parse(source) match {
      case Some(ast) =>
        val result = checkTypes(ast)
        val typeChecks = result._1.isEmpty

        if (typeChecks) {
          render(ast)
        }
      case None => ()
    }
  }

  def parse(source: String): Option[Form] = {
    val parser = new Parser()

    parser.parseAll[Form](parser.form, source) match {
      case parser.Success(ast: Form, _) => Some(ast)
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg); None
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg); None
    }
  }

  def checkTypes(ast: Form): (List[Error], TypeEnvironment) = {
    val typeChecker = new TypeChecker()
    val duplicateLabelsChecker = new DuplicateLabelsChecker()

    val result = typeChecker.check(ast)
    val errors = result._1
    val warnings = duplicateLabelsChecker.check(ast)

    errors.foreach(println)
    warnings.foreach(println)

    result
  }

  def render(ast: Form): Unit = {
    val formBuilder = new FormBuilder()

    formBuilder.build(ast).main(Array())
  }
}
