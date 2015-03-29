package ql.interpreter

import ql.ast.Form
import ql.gui.FormBuilder
import ql.parser.Parser
import ql.typechecker.{DuplicateLabelsChecker, Error, TypeChecker, Warning}
import types.TypeEnvironment

import scala.io.Source

object Interpreter {

  def main(args: Array[String]) {
    val source = Source.fromFile(args(0)).mkString

    parse(source) match {
      case Some(ast) =>
        val (errors, warnings, _) = checkTypes(ast)

        warnings.foreach(println)
        if (errors.isEmpty) {
          render(ast)
        } else {
          errors.foreach(println)
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

  def checkTypes(ast: Form): (List[Error], List[Warning], TypeEnvironment) = {
    val typeChecker = new TypeChecker()
    val duplicateLabelsChecker = new DuplicateLabelsChecker()

    val (errors, env) = typeChecker.check(ast)
    val warnings = duplicateLabelsChecker.check(ast)

    (errors, warnings, env)
  }

  def render(ast: Form): Unit = {
    val formBuilder = new FormBuilder()

    formBuilder.build(ast).main(Array())
  }
}
