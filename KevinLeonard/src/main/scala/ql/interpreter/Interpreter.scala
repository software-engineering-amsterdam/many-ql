package ql.interpreter

import ql.ast.Form
import ql.gui.FormBuilder
import ql.parser.Parser
import ql.typechecker.{DuplicateLabelsChecker, TypeChecker}

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
        val typeCheckErrors = typeChecker.check(ast)
        typeCheckErrors.foreach(println)
        duplicateLabelsChecker.check(ast).foreach(println)
        if (typeCheckErrors.isEmpty) {
          formBuilder.build(ast).main(Array())
        }
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
