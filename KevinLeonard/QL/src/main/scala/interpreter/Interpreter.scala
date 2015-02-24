package interpreter

import ast.Form
import evaluator.Evaluator
import parser.Parser
import typechecker.TypeChecker

import scala.io.Source

object Interpreter {
  def main(args: Array[String]) {
    val parser = new Parser()
    val evaluator = new Evaluator()
    val typeChecker = new TypeChecker()
    val formFile = Source.fromFile(args(0)).mkString

    parser.parseAll[Form](parser.form, formFile) match {
      case parser.Success(ast: Form, _) => {
        typeChecker.check(ast) match {
          case Right(_) => evaluator.eval(ast)
          case Left(e) => println(e)
        }
      }
      case parser.Failure(msg, next) => println("Parse failure at line " + next.pos + ": " + msg)
      case parser.Error(msg, next) => println("Parse error at line " + next.pos + ": " + msg)
    }
  }
}
