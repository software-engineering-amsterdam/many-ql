package interpreter

import ast.Form
import gui.FormBuilder
import parser.Parser
import typechecker.{DuplicateLabelsChecker, TypeChecker}

import scala.io.Source

object Interpreter {

  def main(args: Array[String]) {
    val parser = new Parser()
    val typeChecker = new TypeChecker()
    val duplicateLabelsChecker = new DuplicateLabelsChecker()
    val formBuilder = new FormBuilder()

    val source = Source.fromFile(args(0)).mkString

    parser.parseAll[Form](parser.form, source) match {
      case parser.Success(ast: Form, _) =>
        typeChecker.check(ast) match {
          case Right(_) =>
            duplicateLabelsChecker.check(ast).foreach(println)
            formBuilder.build(ast).main(Array())
          case Left(e) => println(e)
        }
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
